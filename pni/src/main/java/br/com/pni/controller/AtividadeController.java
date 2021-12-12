package br.com.pni.controller;

import br.com.pni.controller.dto.AtividadeDto;
import br.com.pni.controller.dto.custom.AtividadeCustomDto;
import br.com.pni.controller.form.AtividadeForm;
import br.com.pni.model.Atividade;
import br.com.pni.repository.AtividadeRepository;
import br.com.pni.repository.ContractsRepository;
import br.com.pni.repository.TedTcRepository;
import br.com.pni.repository.custom.AtividadeCustomRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({"/atividade"})
public class AtividadeController {
  @Autowired
  private AtividadeCustomRepository aCustomRepository;
  
  @Autowired
  private AtividadeRepository aRepository;
  
  @Autowired
  private ContractsRepository contractsRepository;
  
  @Autowired
  private TedTcRepository tedTcRepository;
  
  @GetMapping
  public List<AtividadeCustomDto> p() {
    return this.aCustomRepository.getJoin();
  }
  
  @GetMapping({"/{id}"})
  public ResponseEntity<AtividadeDto> detalhar(@PathVariable Long id) {
    Optional<Atividade> atividade = this.aRepository.findById(id);
    if (atividade.isPresent())
      return ResponseEntity.ok(new AtividadeDto(atividade.get())); 
    return ResponseEntity.notFound().build();
  }
  
  @GetMapping({"c/{id}"})
  public AtividadeDto detalhar2(@PathVariable Long id) {
    Atividade cargo = this.aRepository.getAtividade(id);
    return new AtividadeDto(cargo);
  }
  
  @PostMapping
  public ResponseEntity<AtividadeDto> cadastrar(@RequestBody @Valid AtividadeForm form, UriComponentsBuilder uriBuilder) {
    Atividade s = form.converter(this.contractsRepository, this.tedTcRepository);
    this.aRepository.save(s);
    URI uri = uriBuilder.path("/atividade/{id}").buildAndExpand(new Object[] { s.getId() }).toUri();
    return ResponseEntity.created(uri).body(new AtividadeDto(s));
  }
}
