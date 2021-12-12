package br.com.pni.controller.dto.custom;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.custom.AtuacaoCustom;

public class AtuacaoCustomDto {

	private long id;
	private long qtd;
	private String nome;
	private BigDecimal valor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public AtuacaoCustomDto() {
	}

	public AtuacaoCustomDto(AtuacaoCustom a) {
		this.id = a.getId();
		this.qtd = a.getQtd();
		this.nome = a.getNome();
		this.valor = a.getValor();
	}

	public AtuacaoCustomDto(long id, long qtd, String nome, BigDecimal valor) {
		this.id = id;
		this.qtd = qtd;
		this.nome = nome;
		this.valor = valor;
	}

	public static List<AtuacaoCustomDto> converter(List<AtuacaoCustom> s) {
		
		return s.stream().map(AtuacaoCustomDto::new).collect(Collectors.toList());
	}

}
