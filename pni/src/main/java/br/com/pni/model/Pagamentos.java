package br.com.pni.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "tbl_status")
public class Pagamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	private Long status_id;
	
	private String nome_status;
	private LocalDateTime data_criacao = LocalDateTime.now();
	private LocalDateTime data_ultima_alteracao = LocalDateTime.now();

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public String getNome_status() {
		this.nome_status = this.nome_status.toUpperCase();
		return nome_status;
	}

	public void setNome_status(String nome_status) {
		this.nome_status = nome_status;
	}

	public LocalDateTime getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDateTime data_criacao) {
		this.data_criacao = data_criacao;
	}

	public LocalDateTime getData_ultima_alteracao() {
		return data_ultima_alteracao;
	}

	public void setData_ultima_alteracao(LocalDateTime data_ultima_alteracao) {
		this.data_ultima_alteracao = data_ultima_alteracao;
	}

	public Pagamentos() {	}

//	construtor de inserir
	public Pagamentos(String nome_status) {
		this.nome_status = nome_status;
	}

}
