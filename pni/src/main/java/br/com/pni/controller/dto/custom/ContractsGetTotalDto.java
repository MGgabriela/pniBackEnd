package br.com.pni.controller.dto.custom;
/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/

import br.com.pni.model.Contracts;

/**
 *
 * @author gabriela
 */

public class ContractsGetTotalDto {

	private long valorTodosContratos;

	public ContractsGetTotalDto(Contracts s) {
//		this.valorTodosContratos = s.getValorTodosContratos();
	}

	public ContractsGetTotalDto() {
	}

//	public Contracts converter() {		
//		return new Contracts(valorTodosContratos);
//	}

//	public static ContractsGetTotalDto converter(long s) {
//		this.valorTodosContratos = s;
//		return valorTodosContratos;
//	}

}
