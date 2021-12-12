package br.com.pni.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "tbl_titulacao")
public class Titulacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Column(name = "titulacao_id")
	private Long id;

	@Column(name = "descricao_titulacao")
	private String nome;

	@Column(name = "enquadramento_atual")
	private Double enquadramentoAtual;

	@Column(name = "valor_min")
	private Double valorMin;

	@Column(name = "valor_max")
	private Double valorMax;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Titulacao() {
	}

	// construtor de inserir
	public Titulacao(String nome, Double enquadramentoAtual, Double valorMin, Double valorMax) {
		this.nome = nome;
		this.enquadramentoAtual = enquadramentoAtual;
		this.valorMin = valorMin;
		this.valorMax = valorMax;
	}

}
