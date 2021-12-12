package br.com.pni.controller.dto.custom;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AtividadeCustomDto {
	
	private long id;
	private long entrega;
	private String nome;
	private LocalDate dataEntrega;	
	private String tedTc;
	private long idTedTc;
	private int trimestre;
	
}
