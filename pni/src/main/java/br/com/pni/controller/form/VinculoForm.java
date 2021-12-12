package br.com.pni.controller.form;

import br.com.pni.model.Vinculo;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class VinculoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	private String descricao;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Vinculo converter() {
		return new Vinculo(this.nome, this.descricao);
	}
}
