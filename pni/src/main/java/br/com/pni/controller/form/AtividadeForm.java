package br.com.pni.controller.form;

import java.time.LocalDate;
import br.com.pni.model.Atividade;
import br.com.pni.model.Contracts;
import br.com.pni.model.TedTc;
import br.com.pni.repository.ContractsRepository;
import br.com.pni.repository.TedTcRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AtividadeForm {

	private int entrega;
	
	private LocalDate dataEntrega = LocalDate.now();
		
	private Long idContrato;
	
	private Long idTedTc;
	
	public Atividade converter(
			ContractsRepository cRepository,
			TedTcRepository tRepository) {
		Contracts c = cRepository.getById(idContrato);
		TedTc     t = tRepository.getById(idTedTc);
		return new Atividade(entrega,  c, t);
	}

}
