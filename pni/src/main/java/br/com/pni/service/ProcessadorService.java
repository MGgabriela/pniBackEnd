package br.com.pni.service;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pni.controller.dto.ContractsDto;
import br.com.pni.controller.dto.StatusDto;
import br.com.pni.controller.form.ContractsForm;
import br.com.pni.model.Atividade;
import br.com.pni.model.Atuacao;
import br.com.pni.model.Cargo;
import br.com.pni.model.Contracts;
import br.com.pni.model.Escolaridade;
import br.com.pni.model.Instituicao;
import br.com.pni.model.Modalidade;
import br.com.pni.model.Status;
import br.com.pni.model.TedTc;
import br.com.pni.model.Vinculo;
import br.com.pni.model.upload.Contratos;
import br.com.pni.repository.AtividadeRepository;
import br.com.pni.repository.AtuacaoRepository;
import br.com.pni.repository.CargoRepository;
import br.com.pni.repository.ContractsRepository;
import br.com.pni.repository.EscolaridadeRepository;
import br.com.pni.repository.InstituicaoRepository;
import br.com.pni.repository.ModalidadeRepository;
import br.com.pni.repository.StatusRepository;
import br.com.pni.repository.TedTcRepository;
import br.com.pni.repository.VinculoRepository;

@Service
public class ProcessadorService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ContractsRepository contractsRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private VinculoRepository vinculoRepository;

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
	
	@Autowired
	private TedTcRepository tedTcRepository;
	
    @Transactional
    public void processar(ArrayList<Contratos> list) {

		  for (Contratos c1 : list) {	
			    ValidaDados v = new ValidaDados();
		    	Contracts contrato = new Contracts();
			    Long idStatus       = v.validaStatus(c1.getStatus());
			    Long idVinculo      = v.validaVinculo(c1.getVinculo());
			    Long idEscolaridade = v.validaEscolaridade(c1.getEscolaridade());
			    Long idModalidade   = v.validaModalidade(c1.getModalidade());
			    Long idInstituicao  = v.validaInstituicao(c1.getInstituicao());
			    Long idCargo        = v.validaCargo(c1.getCargo());
			    Long idAtuacao      = v.validaAtuacao(c1.getAtuacao());
			    String sexo         = v.validaSexo(c1.getSexo());
			    
			    Status       status       = statusRepository.getById(idStatus);
				Vinculo      vinculo      = vinculoRepository.getById(idVinculo);
				Escolaridade escolaridade = escolaridadeRepository.getById(idEscolaridade);
				Modalidade   modalidade   = modalidadeRepository.getById(idModalidade);
				Instituicao  instituicao  = instituicaoRepository.getById(idInstituicao);
				Cargo        cargo        = cargoRepository.getById(idCargo);
				Atuacao      atuacao      = atuacaoRepository.getById(idAtuacao);
			      
			    contrato.setNome(c1.getNome().toUpperCase());
				contrato.setDataInicio(c1.getDataInicio());
				contrato.setDataFim(c1.getDataFim());
				contrato.setContratoFaixaSalarial(c1.getContratoFaixaSalarial());
				contrato.setCpf(c1.getCpf());
				contrato.setFormacao(c1.getFormacao());
				contrato.setSexo(sexo);
				
				contrato.setStatus(status);
				contrato.setVinculo(vinculo);
				contrato.setEscolaridade(escolaridade);
				contrato.setModalidade(modalidade);
				contrato.setInstituicao(instituicao);
				contrato.setCargo(cargo);
				contrato.setAtuacao(atuacao);
				contrato.setAtivo(1);
				cadastrar(contrato);   	     			        	
	        	
	        }
    }
    
    @Transactional
    private ResponseEntity<ContractsDto> cadastrar(Contracts contrato) {
    		System.out.println("\n\n");
    	    List<Contracts> nome = contractsRepository.findByNome(contrato.getNome());
    	         
    	 	List<Contracts> data = contractsRepository
    	 			.findByEntreDatas(contrato.getDataInicio(), contrato.getCpf());
    	 	    	 	
    	 	if(nome.isEmpty() == true) {    	 		
    	 		contractsRepository.save(contrato);
    	 		processarAtividade(contrato.getId());
    	 		return ResponseEntity.status(HttpStatus.CREATED).build();
    	 	}else {
    	 		if(data.isEmpty() == true) {
    	 			contractsRepository.save(contrato);
    	 			processarAtividade(contrato.getId());
        	 		return ResponseEntity.status(HttpStatus.CREATED).build();
    	 		}else {
    	 			System.out.println("\n***Contrato de: "+contrato.getNome()+" já cadastrado.***\n");
    	 			return ResponseEntity.badRequest().build();
    	 		}
    	 	}     	
	}

    @Transactional
    public void processarAtividade(Long id) {
        Atividade a = new Atividade();        
        Contracts c  = contractsRepository.getById(id);
        TedTc t = tedTcRepository.getById((long) 1);       
    	a.setContrato(c);
     	a.setTedTc(t);
     	a.setEntrega(0);         				
     	atividadeRepository.save(a);   
    }
}
