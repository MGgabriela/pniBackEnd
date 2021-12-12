package br.com.pni.controller.form;

import br.com.pni.model.Atuacao;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AtuacaoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	@Length(max = 100)
	private String descricao;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Atuacao converter() {
		return new Atuacao(this.nome, this.descricao);
	}
}
