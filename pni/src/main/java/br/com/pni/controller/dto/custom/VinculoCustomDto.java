package br.com.pni.controller.dto.custom;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.custom.VinculoCustom;

/**
 *
 * @author gabriela
 */

public class VinculoCustomDto {

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

	public VinculoCustomDto() {
	}

	public VinculoCustomDto(VinculoCustom c) {
		this.qtd = c.getQtd();
		this.nome = c.getNome();
	}

	public VinculoCustomDto(String nome, long qtd) {
		this.nome = nome;
		this.qtd = qtd;
	}

	public static List<VinculoCustomDto> converter(List<VinculoCustom> s) {
		return s.stream().map(VinculoCustomDto::new).collect(Collectors.toList());
	}

}
