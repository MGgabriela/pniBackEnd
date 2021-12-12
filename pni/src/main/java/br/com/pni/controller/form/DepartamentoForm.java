package br.com.pni.controller.form;

import br.com.pni.model.Departamento;
import br.com.pni.model.Secretaria;
import br.com.pni.repository.SecretariaRepository;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class DepartamentoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	@Length(max = 100)
	private String descricao;

	private Long idSecretaria;

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

	public Long getIdSecretaria() {
		return this.idSecretaria;
	}

	public void setIdSecretaria(Long idSecretaria) {
		this.idSecretaria = idSecretaria;
	}

	public Departamento converter(SecretariaRepository sRepository) {
		Secretaria secretaria = (Secretaria) sRepository.getById(this.idSecretaria);
		return new Departamento(this.nome, this.descricao, secretaria);
	}
}
