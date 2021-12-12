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

public class ContractsCustomDto {

	private String sexo;

	private long qtd;

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public ContractsCustomDto() {
	}

	public ContractsCustomDto(ContractsCustom c) {
		this.qtd = c.getQtd();
		this.sexo = c.getSexo();
	}

	public static List<ContractsCustomDto> converter(List<ContractsCustom> s) {
		return s.stream().map(ContractsCustomDto::new).collect(Collectors.toList());
	}
	

}
