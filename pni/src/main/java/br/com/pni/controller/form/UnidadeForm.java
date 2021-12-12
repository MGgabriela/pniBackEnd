package br.com.pni.controller.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Departamento;
import br.com.pni.model.Unidade;
import br.com.pni.repository.DepartamentoRepository;

public class UnidadeForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	private String descricao;
	
	private long idDepartamento;

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		descricao = descricao.toUpperCase();
		this.descricao = descricao;
	}

	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public UnidadeForm() {
	}

	public Unidade converter(DepartamentoRepository dRepository) {
		Departamento departamento = dRepository.getById(idDepartamento);		
		return new Unidade(nome, descricao, departamento);
	}

}
