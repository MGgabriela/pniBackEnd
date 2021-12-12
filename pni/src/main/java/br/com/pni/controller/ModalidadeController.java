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

import br.com.pni.controller.dto.ModalidadeDto;
import br.com.pni.controller.form.ModalidadeForm;
import br.com.pni.controller.form.alter.AlterModalidadeForm;
import br.com.pni.model.Modalidade;
import br.com.pni.repository.ModalidadeRepository;

@RestController
@RequestMapping("/modalidade")
public class ModalidadeController {

	@Autowired
	private ModalidadeRepository modalidadeRepository;

	@GetMapping
	public List<ModalidadeDto> lista() {
		List<Modalidade> s = modalidadeRepository.findAll();
		return ModalidadeDto.converter(s);
	}
	
	@GetMapping("/{id}")
	public ModalidadeDto detalhar(@PathVariable Long id) {
		Modalidade s = modalidadeRepository.getById(id);
		return new ModalidadeDto(s);
	}

	@PostMapping
	public ResponseEntity<ModalidadeDto> cadastrar(@RequestBody @Valid ModalidadeForm form, UriComponentsBuilder uriBuilder) {		
		Modalidade s = form.converter();
		modalidadeRepository.save(s);	
		URI uri = uriBuilder.path("/modalidade/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new ModalidadeDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ModalidadeDto> alteraStatus(@PathVariable Long id, @RequestBody @Valid AlterModalidadeForm form) {		
		Optional<Modalidade> op = modalidadeRepository.findById(id);
		if(op.isPresent()) {
			Modalidade s = form.atualizar(id, modalidadeRepository);
			return ResponseEntity.ok(new ModalidadeDto(s));
		}
		return ResponseEntity.notFound().build();	
		
	}
}
