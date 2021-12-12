package br.com.pni.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "tbl_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Column(name = "departamento_id")
	private Long id;

	@Column(name = "departamento_nome")
	private String nome;

	@Column(name = "departamento_descricao")
	private String descricao;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "secretaria_id") // (nullable = false, unique = false)
	private Secretaria secretaria;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public Departamento() {
	}

//	construtor de inserir
	public Departamento(String nome, String descricao, Secretaria secretaria) {
		this.nome = nome;
		this.descricao = descricao;
		this.secretaria = secretaria;
	}

}
