package br.com.pni.controller.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Escolaridade;

public class EscolaridadeForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public EscolaridadeForm() {
	}

	public Escolaridade converter() {
		return new Escolaridade(nome);
	}

}
