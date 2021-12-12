package br.com.pni.controller.dto.custom;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.custom.EscolaridadeCustom;

/**
 *
 * @author gabriela
 */

public class EscolaridadeCustomDto {

	private String nome;

	private long qtd;

	public String getNome() {
		return nome;
	}

	public void setSexo(String nome) {
		this.nome = nome;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public EscolaridadeCustomDto() {
	}

	public EscolaridadeCustomDto(EscolaridadeCustom c) {
		this.qtd = c.getQtd();
		this.nome = c.getNome();
	}

	public static List<EscolaridadeCustomDto> converter(List<EscolaridadeCustom> s) {
		return s.stream().map(EscolaridadeCustomDto::new).collect(Collectors.toList());
	}

}
