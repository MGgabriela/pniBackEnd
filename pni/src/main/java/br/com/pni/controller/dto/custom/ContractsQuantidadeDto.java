package br.com.pni.controller.dto.custom;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.custom.ContractsCustom;

/**
 *
 * @author gabriela
 */

public class ContractsQuantidadeDto {

	private long qtd;

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public ContractsQuantidadeDto() {
	}

	public ContractsQuantidadeDto(ContractsCustom c) {
		this.qtd = c.getQtd();
	}

	public static List<ContractsQuantidadeDto> converter(List<ContractsCustom> s) {
		return s.stream().map(ContractsQuantidadeDto::new).collect(Collectors.toList());
	}

}
