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

import br.com.pni.controller.dto.AtuacaoDto;
import br.com.pni.controller.dto.custom.AtuacaoCustomDto;
import br.com.pni.controller.form.AtuacaoForm;
import br.com.pni.controller.form.alter.AlterAtuacaoForm;
import br.com.pni.model.Atuacao;
import br.com.pni.model.custom.AtuacaoCustom;
import br.com.pni.repository.AtuacaoRepository;
import br.com.pni.repository.custom.AtuacaoCustomRepository;

@RestController
@RequestMapping("/atuacao")
public class AtuacaoController {

	@Autowired
	private AtuacaoRepository aRepository;
	
	@Autowired
	private AtuacaoCustomRepository atuacaoCustomRepository;

	@GetMapping
	public List<AtuacaoDto> lista() {
		List<Atuacao> a = aRepository.findAll();
		return AtuacaoDto.converter(a);
	}
	
	@GetMapping("/{id}")
	public AtuacaoDto detalhar(@PathVariable Long id) {
		Atuacao a = aRepository.getById(id);
		return new AtuacaoDto(a);
	}
	
	@GetMapping("/gastoPorAtuacao")
	public List<AtuacaoCustomDto> gastoPorAtuacao() {
		List<AtuacaoCustom> s = atuacaoCustomRepository.gastoPorAtuacao();
		return AtuacaoCustomDto.converter(s);
	}
	
	@PostMapping
	public ResponseEntity<AtuacaoDto> cadastrar(@RequestBody @Valid AtuacaoForm form, UriComponentsBuilder uriBuilder) {		
		Atuacao s = form.converter();
		aRepository.save(s);	
		URI uri = uriBuilder.path("/atuacao/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtuacaoDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AtuacaoDto> alteraStatus(@PathVariable Long id, @RequestBody @Valid AlterAtuacaoForm form) {		
		Optional<Atuacao> op = aRepository.findById(id);
		if(op.isPresent()) {
			Atuacao s = form.atualizar(id, aRepository);
			return ResponseEntity.ok(new AtuacaoDto(s));
		}
		return ResponseEntity.notFound().build();			
	}
}
