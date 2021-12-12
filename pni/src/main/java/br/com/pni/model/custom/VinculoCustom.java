package br.com.pni.model.custom;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_vinculo")
public class VinculoCustom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vinculo_id")
	private long id;

	@NotEmpty(message = "Nome npode ser vazio")
	@Size(min = 2, max = 255, message = "Nome npode ultrapassar 255 caracteres")
	@Column(name = "tipo_vinculo")
	private String nome;

	private long qtd;

	@Column(name = "data_inicio")
	private LocalDateTime dataInicio;

	@Column(name = "data_fim")
	private LocalDateTime dataFim;

	public VinculoCustom() {
	}

	public VinculoCustom(long qtd, String nome) {
		this.qtd = qtd;
		this.nome = nome;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public long getQtd() {
		return this.qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
