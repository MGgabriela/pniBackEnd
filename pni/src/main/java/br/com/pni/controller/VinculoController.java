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

import br.com.pni.controller.dto.VinculoDto;
import br.com.pni.controller.dto.custom.GraficoVinculo;
import br.com.pni.controller.form.VinculoForm;
import br.com.pni.controller.form.alter.AlterVinculoForm;
import br.com.pni.model.Vinculo;
import br.com.pni.repository.VinculoRepository;
//import br.com.pni.repository.custom.VinculoCustomRepository;
import br.com.pni.repository.custom.VinculoCustomRepository;

@RestController
@RequestMapping("/vinculo")
public class VinculoController {

	@Autowired
	private VinculoCustomRepository vCustomRepository;
	
	@Autowired
	private VinculoRepository vRepository;
	
	@GetMapping
	public List<VinculoDto> lista() {
		List<Vinculo> x = vRepository.findAll();
		return VinculoDto.converter(x);
	}
	
	@GetMapping("/{id}")
	public VinculoDto detalhar(@PathVariable long id) {
		Vinculo u = vRepository.getById(id);
		return new VinculoDto(u);
	}
	
	@GetMapping("/vinculoGrafico")
	public List<GraficoVinculo> vinculoGrafico() {
		return vCustomRepository.getJoin();
	}
	
	@PostMapping
	public ResponseEntity<VinculoDto> cadastrar(@RequestBody @Valid VinculoForm form, UriComponentsBuilder uriBuilder) {		
		Vinculo s = form.converter();
		vRepository.save(s);	
		URI uri = uriBuilder.path("/vinculo/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new VinculoDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VinculoDto> alteraStatus(@PathVariable long id, @RequestBody @Valid AlterVinculoForm form) {		
		Optional<Vinculo> op = vRepository.findById(id);
		if(op.isPresent()) {
			Vinculo s = form.atualizar(id, vRepository);
			return ResponseEntity.ok(new VinculoDto(s));
		}
		return ResponseEntity.notFound().build();			
	}

}
