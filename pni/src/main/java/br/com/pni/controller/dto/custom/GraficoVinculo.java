package br.com.pni.controller.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GraficoVinculo {
	
	private String instituicao;
	private String vinculo;
	private Long qtd;
}
