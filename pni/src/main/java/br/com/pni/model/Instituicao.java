package br.com.pni.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_instituicao")
public class Instituicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instituicao_id")
	private Long id;

	@NotEmpty
	@NotNull
	@Column(name = "nome_instituicao")
	private String nome;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public long getId() {
		return this.id.longValue();
	}

	public void setId(long id) {
		this.id = Long.valueOf(id);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return this.dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Instituicao() {
	}

	public Instituicao(String nome) {
		this.nome = nome;
	}
}
