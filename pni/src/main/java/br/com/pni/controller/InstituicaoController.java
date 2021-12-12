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

import br.com.pni.controller.dto.InstituicaoDto;
import br.com.pni.controller.form.InstituicaoForm;
import br.com.pni.controller.form.alter.AlterInstituicaoForm;
import br.com.pni.model.Instituicao;
import br.com.pni.repository.InstituicaoRepository;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	@GetMapping
	public List<InstituicaoDto> lista() {
		List<Instituicao> x = instituicaoRepository.findAll();
		return InstituicaoDto.converter(x);
	}
	
	@GetMapping("/{id}")
	public InstituicaoDto detalhar(@PathVariable Long id) {
		Instituicao x = instituicaoRepository.getById(id);
		return new InstituicaoDto(x);
	}

	@PostMapping
	public ResponseEntity<InstituicaoDto> cadastrar(@RequestBody @Valid InstituicaoForm form, UriComponentsBuilder uriBuilder) {		
		Instituicao s = form.converter();
		instituicaoRepository.save(s);	
		URI uri = uriBuilder.path("/instituicao/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new InstituicaoDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<InstituicaoDto> alterar(@PathVariable Long id, @RequestBody @Valid AlterInstituicaoForm form) {		
		Optional<Instituicao> op = instituicaoRepository.findById(id);
		if(op.isPresent()) {
			Instituicao s = form.atualizar(id, instituicaoRepository);
			return ResponseEntity.ok(new InstituicaoDto(s));
		}
		return ResponseEntity.notFound().build();	
		
	}
}
