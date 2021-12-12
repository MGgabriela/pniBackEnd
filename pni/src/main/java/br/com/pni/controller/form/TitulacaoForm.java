package br.com.pni.controller.form;

import javax.validation.constraints.*;

import br.com.pni.model.Titulacao;


public class TitulacaoForm {
	
	@NotNull
	@NotEmpty
	private String nome;

	private Double enquadramentoAtual;

	@NotNull	
	private Double valorMin;
	
	@NotNull	
	private Double valorMax;

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public void setEnquadramentoAtual(Double enquadramentoAtual) {
		this.enquadramentoAtual = enquadramentoAtual;
	}
	
	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

	public TitulacaoForm() {
	}

	public Titulacao converter() {	
		if(!(valorMin > valorMax)) {
			return new Titulacao(nome, enquadramentoAtual, valorMin, valorMax);
		}
		return null;
	}

}
