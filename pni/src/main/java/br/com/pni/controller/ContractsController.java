package br.com.pni.controller;

import java.net.URI;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pni.controller.dto.ContractsDto;
import br.com.pni.controller.dto.ContractsPorUrgenciaDto;
import br.com.pni.controller.dto.custom.ContractsCustomDto;
import br.com.pni.controller.dto.custom.ContractsQuantidadeDto;
import br.com.pni.controller.dto.custom.ContractsTotalContratosDto;
import br.com.pni.controller.form.ContractsForm;
import br.com.pni.controller.form.alter.AlterContractsForm;
import br.com.pni.model.Contracts;
import br.com.pni.model.ContractsPorUrgencia;
import br.com.pni.model.custom.ContractsCustom;
//import br.com.pni.repository.AtividadeRepository;
import br.com.pni.repository.AtuacaoRepository;
import br.com.pni.repository.CargoRepository;
import br.com.pni.repository.ContractsPorUrgenciaRepository;
import br.com.pni.repository.ContractsRepository;
import br.com.pni.repository.EscolaridadeRepository;
import br.com.pni.repository.InstituicaoRepository;
import br.com.pni.repository.ModalidadeRepository;
import br.com.pni.repository.StatusRepository;
import br.com.pni.repository.VinculoRepository;
import br.com.pni.repository.custom.ContractsCustomRepository;
//import br.com.pni.repository.custom.VinculoCustomRepository;

@RestController
@RequestMapping("/contratos")
public class ContractsController {

	@Autowired
	private ContractsRepository contractsRepository;
	
	@Autowired
	private ContractsCustomRepository contractsCustomRepository;
	
	@Autowired
	private ContractsPorUrgenciaRepository contractsPorUrgenciaRepository;
		
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private VinculoRepository vinculoRepository;
	
//	@Autowired
//	private VinculoCustomRepository vinculoCustomRepository;
	
	@Autowired
	private EscolaridadeRepository escolaridadeRepository;
	
	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private AtuacaoRepository atuacaoRepository;
	
//	@Autowired
//	private AtividadeRepository atividadeRepository;

	@GetMapping
	public Page<ContractsDto> lista(
			@RequestParam(required = false) String status,
//			@RequestParam(required = true) int pag,
//			@RequestParam(required = true) int qtd,
			Pageable paginacao
			) {
			
		// enviar
		// localhost:8080/contratos?pag=1&qtd2
		// localhost:8080/contratos?page=1&size&sort=id,asc
		
//			Pageable paginacao = PageRequest.of(pag, qtd);
		
			if(status == null) {
				Page<Contracts> s = contractsRepository.findAll(paginacao);
				return ContractsDto.converter(s);
			}else {
				Page<Contracts> s = contractsRepository.findByStatus_Id(status,paginacao);
				return ContractsDto.converter(s);
			} 
	}
	
	@GetMapping("/c")
	public List<ContractsDto> listaSemPage() {			
			List<Contracts> s = contractsRepository.findAll();
			return ContractsDto.converterList(s);		
	}

	@GetMapping("/sexo")
	public List<ContractsCustomDto> divisaoPorSexo() {
		List<ContractsCustom> s = contractsCustomRepository.divisaoPorSexo();
		return ContractsCustomDto.converter(s);
	}
	
	@GetMapping("/totalContratados")
	public List<ContractsQuantidadeDto> totalContratados() {
		List<ContractsCustom> s = contractsCustomRepository.totalContratados();
		return ContractsQuantidadeDto.converter(s);
	}
	
	@GetMapping("/total")
	public List<ContractsTotalContratosDto> total() {
		List<ContractsTotalContratosDto> allEmployees = contractsCustomRepository.getJoin();
		return allEmployees;
	}
	
//	@GetMapping("/vinculo")
//	public List<VinculoCustomDto> qtdPorVinculo() {
//		List<VinculoCustom> s = vinculoCustomRepository.qtdPorVinculo();
//		return VinculoCustomDto.converter(s);
//	}
	
	@GetMapping("/turnover")
	public String turnover() {
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(1);
		return format.format(contractsCustomRepository.turnover());
	}
	
	@GetMapping("/porUrgencia")
	public List<ContractsPorUrgenciaDto> contratosPorUrgencia() {
		List<ContractsPorUrgencia> s = contractsPorUrgenciaRepository.contratosPorUrgencia();
//		List arrayColor[] = null;	
//		 for (ContractsPorUrgencia c1 : s) {
//			 String color = "";
//			 if(c1.getFaltam() > 45) {
//				 color = "sucess";
//				 arrayColor.push();
//			 }
//			 if(c1.getFaltam() < 45 && c1.getFaltam() > 0){
//				 color = "warning";
//				 c1.setColor(color);
//			 }
//			 if(c1.getFaltam() < 0 ) {
//				 color = "danger";
//				 c1.setColor(color);
//			 }	
//			 System.out.println(c1.getColor());
//		 }
		return ContractsPorUrgenciaDto.converter(s);
//		return null;
	}

	@PostMapping
	public ResponseEntity<ContractsDto> cadastrar(
			@RequestBody @Valid ContractsForm form, 
			UriComponentsBuilder uriBuilder) {		
		Contracts s = form.converter(statusRepository,
									 vinculoRepository,
									 escolaridadeRepository,
									 modalidadeRepository,
									 instituicaoRepository,
									 cargoRepository,
									 atuacaoRepository
									 );
		
		contractsRepository.save(s);	

		URI uri = uriBuilder.path("/contratos/{id}").buildAndExpand(s.getId()).toUri();
			
//		ProcessadorService p = new ProcessadorService();
//		p.processarAtividade(s.getId());
		
		return ResponseEntity.created(uri).body(new ContractsDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContractsDto> alterar(@PathVariable Long id, @RequestBody @Valid AlterContractsForm form) {		
		Optional<Contracts> op = contractsRepository.findById(id);
		if(op.isPresent()) {
			Contracts s = form.atualizar(id, 
					contractsRepository,
					statusRepository,
					vinculoRepository,
					escolaridadeRepository,
					modalidadeRepository,
					instituicaoRepository,
					cargoRepository,
					atuacaoRepository
					);
			return ResponseEntity.ok(new ContractsDto(s));
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
