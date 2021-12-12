package br.com.pni.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GraficoEscolaridade {

	private String intituicao;
	private String escolaridade;
	private Long qtd;

}
