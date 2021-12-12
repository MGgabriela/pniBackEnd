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
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cargo_id")
	private Long id;

	@Column(name = "cargo_nome")
	@NotNull
	@NotEmpty(message = "Cargo npode ser vazio")
	@Size(min = 2, max = 50, message = "Cargo npode ultrapassar 50 caracteres")
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

	public Cargo() {
	}

	public Cargo(String nome) {
		this.nome = nome;
	}
}
