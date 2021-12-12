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

import br.com.pni.controller.dto.TitulacaoDto;
import br.com.pni.controller.form.TitulacaoForm;
import br.com.pni.controller.form.alter.AlterTitulacaoForm;
import br.com.pni.model.Titulacao;
import br.com.pni.repository.TitulacaoRepository;

@RestController
@RequestMapping("/titulo")
public class TitulacaoController {

	@Autowired
	private TitulacaoRepository titulacaoRepository;

	@GetMapping
	public List<TitulacaoDto> lista() {
		List<Titulacao> titulacao = titulacaoRepository.findAll();
		return TitulacaoDto.converter(titulacao);
	}
	
	@GetMapping("/{id}")
	public TitulacaoDto detalhar(@PathVariable Long id) {
		Titulacao titulacao = titulacaoRepository.getById(id);
		return new TitulacaoDto(titulacao);
	}

	@PostMapping
	public ResponseEntity<TitulacaoDto> cadastrar(@RequestBody @Valid TitulacaoForm form, UriComponentsBuilder uriBuilder) {		
		Titulacao s = form.converter();
		titulacaoRepository.save(s);	
		URI uri = uriBuilder.path("/titulo/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new TitulacaoDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TitulacaoDto> alteraTitulacao(@PathVariable Long id, @RequestBody @Valid AlterTitulacaoForm form) {		
		Optional<Titulacao> op = titulacaoRepository.findById(id);
		if(op.isPresent()) {			
			Titulacao x = form.atualizar(id, titulacaoRepository);
			return ResponseEntity.ok(new TitulacaoDto(x));
		}
		return ResponseEntity.notFound().build();	
		
	}
}
