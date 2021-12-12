package br.com.pni.model.custom;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtuacaoCustom {

	@Id
	private long id;
	private String nome;
//	private String descricao;
//	private LocalDateTime dataCriacao = LocalDateTime.now();
//	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();
	private BigDecimal valor;
	private long qtd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = this.nome.toUpperCase();
		this.nome = nome;
	}

//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}

//	public LocalDateTime getDataCriacao() {
//		return dataCriacao;
//	}
//
//	public void setDataCriacao(LocalDateTime dataCriacao) {
//		this.dataCriacao = dataCriacao;
//	}
//
//	public LocalDateTime getDataUltimaAlteracao() {
//		return dataUltimaAlteracao;
//	}
//
//	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
//		this.dataUltimaAlteracao = dataUltimaAlteracao;
//	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public AtuacaoCustom() {
	}

	public AtuacaoCustom(long qtd, String nome, BigDecimal valor) {
		this.qtd = qtd;
		this.nome = nome;
		this.valor = valor;
	}

}
