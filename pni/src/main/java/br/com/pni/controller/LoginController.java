package br.com.pni.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pni.config.security.SecurityConfig;
import br.com.pni.controller.dto.custom.LoginAddDto;
import br.com.pni.controller.form.LoginAddForm;
import br.com.pni.controller.form.alter.AlterLoginCustomForm;
import br.com.pni.controller.form.alter.AlteraSenhaForm;
import br.com.pni.model.custom.LoginCustom;
import br.com.pni.repository.custom.LoginAddRepository;
import br.com.pni.repository.custom.NivelAddRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginAddRepository loginRepository;

	@Autowired
	private NivelAddRepository nRepository;
	
	@Autowired
	private SecurityConfig config;


	@GetMapping("/nivel/{id}")
	public List<LoginAddDto> lista(@PathVariable Long id) {
		List<LoginCustom> login = loginRepository.findByNivelId(id);
		return LoginAddDto.converter(login);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoginAddDto> listaPorId(@PathVariable Long id) {
		Optional<LoginCustom> login = loginRepository.findById(id);
		if (login.isPresent()) {
			return ResponseEntity.ok( new LoginAddDto(login.get()) );
		}
		return ResponseEntity.notFound().build();		
	}

	@GetMapping("/all/{nivel}")
	public ResponseEntity<List<LoginAddDto>> listAll(@PathVariable Long nivel) {		
		if(nivel == 1) {
			List<LoginCustom> login = loginRepository.findAll();
			return ResponseEntity.ok( LoginAddDto.converter(login) );
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@PostMapping
	public ResponseEntity<LoginAddDto> cadastrar(
			@RequestBody @Valid LoginAddForm form,
			UriComponentsBuilder uriBuilder) {	
		if(form.getNivelUserLog() == 1) {
			LoginCustom s = form.converter(nRepository);
			s.setSenha(config.criptografa(s.getSenha()));			
			Optional<LoginCustom> emailExiste = loginRepository.findByEmail(s.getEmail());
			if(emailExiste.isPresent()) {
				System.out.println("email ja existe");
				return ResponseEntity.badRequest().build();
			}
			loginRepository.save(s);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LoginAddDto> alteraLogin(
			@PathVariable Long id, 
			@RequestBody @Valid AlterLoginCustomForm form) {	
		
		Optional<LoginCustom> op = loginRepository.findById(id);
		if(op.isPresent()) {			
			LoginCustom s = form.atualizar(id, loginRepository,nRepository);			
			s.setSenha(config.criptografa(s.getSenha()));			
			return ResponseEntity.ok(new LoginAddDto(s));
		}
		return ResponseEntity.notFound().build();			
	}
	
	@PutMapping("/senha/{id}")
	@Transactional
	public ResponseEntity<LoginAddDto> alteraSenha(
			@PathVariable Long id, 
			@RequestBody @Valid AlteraSenhaForm form) {	
	
		Optional<LoginCustom> op = loginRepository.findById(id);
		if(op.isPresent()) {			
			LoginCustom s = form.atualizar(id, loginRepository);			
			s.setSenha(config.criptografa(s.getSenha()));			
			return ResponseEntity.ok(new LoginAddDto(s));
		}
		return ResponseEntity.notFound().build();			
	}

}
