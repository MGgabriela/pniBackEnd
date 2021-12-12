package br.com.pni.controller.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Instituicao;

public class InstituicaoForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public InstituicaoForm() {
	}

	public Instituicao converter() {
		return new Instituicao(nome);
	}

}
