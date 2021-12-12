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

import br.com.pni.controller.dto.EscolaridadeDto;
import br.com.pni.controller.dto.GraficoEscolaridade;
import br.com.pni.controller.dto.custom.EscolaridadeCustomDto;
import br.com.pni.controller.form.EscolaridadeForm;
import br.com.pni.controller.form.alter.AlterEscolaridadeForm;
import br.com.pni.model.Escolaridade;
import br.com.pni.model.custom.EscolaridadeCustom;
import br.com.pni.repository.EscolaridadeRepository;
import br.com.pni.repository.custom.EscolaridadeCustomRepository;

@RestController
@RequestMapping("/escolaridade")
public class EscolaridadeController {

	@Autowired
	private EscolaridadeRepository escolaridadeRepository;
	
	@Autowired
	private EscolaridadeCustomRepository eCustomRepository;

	@GetMapping
	public List<EscolaridadeDto> lista() {
		List<Escolaridade> x = escolaridadeRepository.findAll();
		return EscolaridadeDto.converter(x);
	}
	
	@GetMapping("/geral")
	public List<EscolaridadeCustomDto> escolaridadeGeral() {
		List<EscolaridadeCustom> x = eCustomRepository.escolaridadeGeral();
		return EscolaridadeCustomDto.converter(x);
	}
	
	@GetMapping("/{id}")
	public EscolaridadeDto detalhar(@PathVariable Long id) {
		Escolaridade x = escolaridadeRepository.getById(id);
		return new EscolaridadeDto(x);
	}
	
    @GetMapping("/escolaGrafico")
    public List<GraficoEscolaridade> p(){
    	return eCustomRepository.getJoin();
    }
	

	@PostMapping
	public ResponseEntity<EscolaridadeDto> cadastrar(@RequestBody @Valid EscolaridadeForm form, UriComponentsBuilder uriBuilder) {		
		Escolaridade s = form.converter();
		escolaridadeRepository.save(s);	
		URI uri = uriBuilder.path("/escolaridade/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new EscolaridadeDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EscolaridadeDto> alterar(@PathVariable Long id, @RequestBody @Valid AlterEscolaridadeForm form) {		
		Optional<Escolaridade> op = escolaridadeRepository.findById(id);
		if(op.isPresent()) {
			Escolaridade x = form.atualizar(id, escolaridadeRepository);
			return ResponseEntity.ok(new EscolaridadeDto(x));
		}
		return ResponseEntity.notFound().build();	
		
	}
}
