package br.com.pni.controller.form.alter;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pni.model.Titulacao;
import br.com.pni.repository.TitulacaoRepository;

public class AlterTitulacaoForm {

	@NotNull
	@NotEmpty
	private String nome;

	private Double enquadramentoAtual;

	@NotNull	
	private Double valorMin;
	
	@NotNull	
	private Double valorMax;

	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

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

	public Double getValorMax() {
		return valorMax;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public AlterTitulacaoForm() {
	}

	public Titulacao atualizar(Long id, TitulacaoRepository titulacaoRepository) {
		Titulacao t = titulacaoRepository.findById(id).get();
		t.setNome(this.nome);
		t.setEnquadramentoAtual(this.enquadramentoAtual);
		t.setValorMin(valorMin);
		t.setValorMax(this.valorMin);
		t.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return t;
	}

}
