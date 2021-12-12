package br.com.pni.model.custom;

import javax.persistence.*;

/**
 *
 * @author gabriela
 */
@Entity
public class EscolaridadeCustom {

	@Id
	private long id;

	private String nome;

	private long qtd;

	public EscolaridadeCustom() {
	}

	public EscolaridadeCustom(long qtd, String nome) {
		this.qtd = qtd;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
