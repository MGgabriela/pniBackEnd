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

import br.com.pni.controller.dto.UnidadeDto;
import br.com.pni.controller.form.UnidadeForm;
import br.com.pni.controller.form.alter.AlterUnidadeForm;
import br.com.pni.model.Unidade;
import br.com.pni.repository.DepartamentoRepository;
import br.com.pni.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@GetMapping
	public List<UnidadeDto> lista() {
		List<Unidade> u = unidadeRepository.findAll();
		return UnidadeDto.converter(u);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UnidadeDto> detalhar(@PathVariable Long id) {
		Optional<Unidade> u = unidadeRepository.findById(id);
		if(u.isPresent()) {
			return ResponseEntity.ok(new UnidadeDto(u.get()));
		}
		return ResponseEntity.notFound().build();
	}

//	
////	@GetMapping("/{id}")
////	public ResponseEntity<DetalhesDoStatusDto> detalhar(@PathVariable Long id) {
////	 	Optional<Status> status = statusRepository.findById(id);
////	 	if(status.isPresent()) {
////	 		return 
////	 	}
////		return new StatusDto(status);
////	}
	

	@PostMapping
	public ResponseEntity<UnidadeDto> cadastrar(@RequestBody @Valid UnidadeForm form, UriComponentsBuilder uriBuilder) {		
		Unidade u = form.converter(departamentoRepository);
		unidadeRepository.save(u);	
		URI uri = uriBuilder.path("/unidade/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(new UnidadeDto(u));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UnidadeDto> alterar(@PathVariable Long id, @RequestBody @Valid AlterUnidadeForm form) {		
		Optional<Unidade> op = unidadeRepository.findById(id);
		if(op.isPresent()) {
			Unidade u = form.atualizar(id, unidadeRepository, departamentoRepository);
			return ResponseEntity.ok(new UnidadeDto(u));
		}
		return ResponseEntity.notFound().build();	
		
	}
	
}
