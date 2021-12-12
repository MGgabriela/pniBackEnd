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

import br.com.pni.controller.dto.DepartamentoDto;
import br.com.pni.controller.form.DepartamentoForm;
import br.com.pni.controller.form.alter.AlterDepartamentoForm;
import br.com.pni.model.Departamento;
import br.com.pni.repository.DepartamentoRepository;
import br.com.pni.repository.SecretariaRepository;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository dRepository;
	
	@Autowired
	private SecretariaRepository secretariaRepository;

	@GetMapping
	public List<DepartamentoDto> lista() {
		List<Departamento> d = dRepository.findAll();
		return DepartamentoDto.converter(d);
	}
	
	@GetMapping("/{id}")
	public DepartamentoDto detalhar(@PathVariable Long id) {
		Departamento d = dRepository.getById(id);
		return new DepartamentoDto(d);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<DepartamentoDto> detalhar(@PathVariable Long id) {
//	 	Optional<Departamento> d = dRepository.findById(id);
//	 	if(d.isPresent()) {
//	 		return 
//	 	}
//		return new DepartamentoDto(d);
//	}
	

	@PostMapping
	public ResponseEntity<DepartamentoDto> cadastrar(
			@RequestBody @Valid DepartamentoForm form, 
			UriComponentsBuilder uriBuilder) {		
		Departamento d = form.converter(secretariaRepository);
		dRepository.save(d);	
		URI uri = uriBuilder.path("/departamento/{id}").buildAndExpand(d.getId()).toUri();
		return ResponseEntity.created(uri).body(new DepartamentoDto(d));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DepartamentoDto> alterar(@PathVariable long id, @RequestBody @Valid AlterDepartamentoForm form) {		
		Optional<Departamento> op = dRepository.findById(id);
		if(op.isPresent()) {
			Departamento s = form.atualizar(id, dRepository,secretariaRepository);
			return ResponseEntity.ok(new DepartamentoDto(s));
		}
		return ResponseEntity.notFound().build();	
		
	}
}
