package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Titulacao;

public class TitulacaoDto {

	private Long id;
	private String nome;
	private Double enquadramentoAtual;
	private Double valorMin;
	private Double valorMax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getEnquadramentoAtual() {
		return enquadramentoAtual;
	}

	public void setEnquadramentoAtual(Double enquadramentoAtual) {
		this.enquadramentoAtual = enquadramentoAtual;
	}

	public Double getValorMin() {
		return valorMin;
	}

	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
	}

	public Double getValorMax() {
		return valorMax;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

	public TitulacaoDto() {
	}

	public TitulacaoDto(Titulacao t) {
		this.id = t.getId();
		this.nome = t.getNome();
		this.enquadramentoAtual = t.getEnquadramentoAtual();
		this.valorMin = t.getValorMin();
		this.valorMax = t.getValorMax();
	}

	public static List<TitulacaoDto> converter(List<Titulacao> t) {
		return t.stream().map(TitulacaoDto::new).collect(Collectors.toList());
	}

}
