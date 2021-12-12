package br.com.pni.controller.dto.custom;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;

	private Double contratoFaixaSalarial;

	private String formacao;

	private String cpf;
	private String sexo;

	private String instituicao;
	private String escolaridade;
	private String modalidade;
	private String status;
	private String vinculo;

}
