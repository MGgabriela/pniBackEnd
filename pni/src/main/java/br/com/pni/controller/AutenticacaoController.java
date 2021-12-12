package br.com.pni.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pni.config.security.TokenService;
import br.com.pni.controller.dto.TokenDto;
import br.com.pni.controller.form.LoginForm;
import br.com.pni.model.custom.LoginCustom2;
import br.com.pni.repository.custom.LoginCustom2Repository;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
//	@Autowired
//	private LoginCustom2Repository lRepository;
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private LoginCustom2Repository loginRepository;
	
	Long nivelID = (long) 0;
	String nome = null;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.convert();

		try {
			
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			
			buscaUsuario(dadosLogin.getPrincipal().toString());					
			return ResponseEntity.ok(new TokenDto(token, "Bearer", nome, nivelID ));
			
			
			//É o tipo de autenticação a ser feita pelo cliente com o token que lhe foi devolvido
			//Bearer é um dos mecanismos de autenticação utilizados no protocolo HTTP, tal como o Basic e o Digest.
			
		} catch (AuthenticationException e) {
			System.out.println("Erro AuthenticationException - classe AutenticacaoController");
			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping
	public void buscaUsuario(String email) {
			
		List<LoginCustom2> result = loginRepository.findByEmail(email);			
		for (LoginCustom2 l : result) {
			nome = l.getNome();
		    nivelID = l.getNivel().getId();
		}		
	}

}
