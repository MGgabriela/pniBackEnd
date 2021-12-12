package br.com.pni.service;

//import br.com.pni.java.controller.ValidaDadosFiotec;
import br.com.pni.model.upload.Contratos;
import br.com.pni.model.upload.Fiotec;
import br.com.pni.model.upload.RhTodos;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gabri
 */
public class MontaDadosOpas {
	        
    public List<Contratos> teste(List<RhTodos> rhTodos, List<Fiotec> contratosF) {         
      
    	if ( rhTodos.isEmpty() || contratosF.isEmpty()) { 
    		System.out.println("erro na montagem dos dados array rhTodos ou contratosF vazio");
    	}else {                
		    	ArrayList<Contratos> listaComum = new ArrayList<>();
		        for (RhTodos rh : rhTodos) {
		            for (Fiotec fi : contratosF) {
		                if (rh.getCpf().equals(fi.getCpf())) {
		                	
		                	LocalDate dataInicio = fi.getDataInicio().toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
		                	LocalDate dataFim = fi.getDataFim().toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
		                			                	
		                	listaComum.add(new Contratos(                             
		                            fi.getNome(),
		                            dataInicio,
		                            dataFim,
		                            fi.getContratoFaixaSalarial(),
		                            fi.getCpf(), 
		                            rh.getFormacao(),
		                            rh.getSexo(),
		                            fi.getStatus(),
		                            rh.getVinculo(),
		                            rh.getEscolaridade(),
		                            fi.getModalidade(),
		                            fi.getInstituicao(),
		                            rh.getCargo(),
		                            rh.getAtuacao(),
		                            rh.getDepartamento(),
		                            rh.getUnidade()			                            
		                    ));		                	
		                    break;
		                }
		            }
		        }      
		       	
//		        Contracts c = new Contracts();
//		        
//		        ContractsForm form = new ContractsForm();
		        
//		        for (Contratos p1 : listaComum) {
//		        	c.setNome(p1.getNome());
//		        	System.out.println("nome: "+c.getNome());
//		        	c.
////		        	c.setNome(p1.getNome());
////		        	cadastrar(listaComum);	
//		    		Contracts s = form.converter(
//		    				statusRepository,
//		    			    vinculoRepository,
//		    			    escolaridadeRepository,
//		    			    modalidadeRepository,
//		    			    instituicaoRepository,
//		    			    cargoRepository,
//		    			    atuacaoRepository
//		    			    );
//		    		
//		    		contractsRepository.save(s);		        	
//		        }	
		       
		   return listaComum;		
		  }
    	return null;
    } 
  
}
