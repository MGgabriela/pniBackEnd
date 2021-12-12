package br.com.pni.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_unidade")
public class Unidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unidade_id")
	private Long id;

	@NotNull
	@NotEmpty(message = "Unidade npode ser vazio")
	@Size(min = 2, max = 50, message = "Unidade npode ultrapassar 50 caracteres")
	@Column(name = "unidade_nome")
	private String nome;

	@Size(max = 100, message = "Unidade npode ultrapassar 100 caracteres")
	@Column(name = "unidade_descricao")
	private String descricao;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Unidade() {
	}

	public Unidade(String nome, String descricao, Departamento departamento) {
		this.nome = nome;
		this.descricao = descricao;
		this.departamento = departamento;
	}
}
