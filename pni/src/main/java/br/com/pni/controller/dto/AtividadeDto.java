package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.time.LocalDate;

import br.com.pni.model.Atividade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AtividadeDto {

	private Long id;
	private long entrega;
	private LocalDate dataEntrega;

	public AtividadeDto(Atividade a) {
		this.id = a.getId();
		this.entrega = a.getEntrega();
		this.dataEntrega = a.getDataEntrega();
	}

}
