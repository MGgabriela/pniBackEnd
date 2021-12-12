package br.com.pni.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pni.controller.dto.SecretariaDto;
import br.com.pni.controller.form.SecretariaForm;
import br.com.pni.controller.form.alter.AlterSecretariaForm;
import br.com.pni.model.Secretaria;
import br.com.pni.repository.SecretariaRepository;

@RestController
@RequestMapping("/secretaria")
public class SecretariaController {

	@Autowired
	private SecretariaRepository secretariaRepository;

	@GetMapping
	public List<SecretariaDto> lista() {
		List<Secretaria> s = secretariaRepository.findAll();
		return SecretariaDto.converter(s);
	}
	
	@GetMapping("/{id}")
	public SecretariaDto detalhar(@PathVariable Long id) {
		Secretaria s = secretariaRepository.getById(id);
		return new SecretariaDto(s);
	}

	@PostMapping
	public ResponseEntity<SecretariaDto> cadastrar(@RequestBody @Valid SecretariaForm form, UriComponentsBuilder uriBuilder) {		
		Secretaria s = form.converter();
		secretariaRepository.save(s);	
		URI uri = uriBuilder.path("/secretaria/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new SecretariaDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SecretariaDto> alteraStatus(@PathVariable Long id, @RequestBody @Valid AlterSecretariaForm form) {		
		Optional<Secretaria> op = secretariaRepository.findById(id);
		if(op.isPresent()) {
			Secretaria s = form.atualizar(id, secretariaRepository);
			return ResponseEntity.ok(new SecretariaDto(s));
		}
		return ResponseEntity.notFound().build();			
	}
}
