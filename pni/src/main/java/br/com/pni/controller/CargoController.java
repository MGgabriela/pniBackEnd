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

import br.com.pni.controller.dto.CargoDto;
import br.com.pni.controller.form.CargoForm;
import br.com.pni.controller.form.alter.AlterCargoForm;
import br.com.pni.model.Cargo;
import br.com.pni.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping
	public List<CargoDto> lista() {
		List<Cargo> cargo = cargoRepository.findAll();
		return CargoDto.converter(cargo);
	}
	
	@GetMapping("/{id}")
	public CargoDto detalhar(@PathVariable Long id) {
		Cargo cargo = cargoRepository.getById(id);
		return new CargoDto(cargo);
	}

	@PostMapping
	public ResponseEntity<CargoDto> cadastrar(@RequestBody @Valid CargoForm form, UriComponentsBuilder uriBuilder) {		
		Cargo s = form.converter();
		cargoRepository.save(s);	
		URI uri = uriBuilder.path("/cargo/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new CargoDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CargoDto> alteraStatus(@PathVariable Long id, @RequestBody @Valid AlterCargoForm form) {		
		Optional<Cargo> op = cargoRepository.findById(id);
		if(op.isPresent()) {
			Cargo s = form.atualizar(id, cargoRepository);
			return ResponseEntity.ok(new CargoDto(s));
		}
		return ResponseEntity.notFound().build();	
		
	}
}
