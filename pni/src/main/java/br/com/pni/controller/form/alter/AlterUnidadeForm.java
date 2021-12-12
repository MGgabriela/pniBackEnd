package br.com.pni.controller.form.alter;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Departamento;
import br.com.pni.model.Unidade;
import br.com.pni.repository.DepartamentoRepository;
import br.com.pni.repository.UnidadeRepository;

public class AlterUnidadeForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	@Length(max = 100)
	private String descricao;

	private Long idDepartamento;

	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		descricao = descricao.toUpperCase();
		this.descricao = descricao;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public AlterUnidadeForm() {
	}

	public Unidade atualizar(Long id, UnidadeRepository unidadeRepository, 
									  DepartamentoRepository departamentoRepository) {
		Unidade u = unidadeRepository.findById(id).get();
		Departamento d = departamentoRepository.getById(idDepartamento);
		u.setNome(this.nome);
		u.setDescricao(this.descricao);
		u.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		u.setDepartamento(d);
		return u;
	}

}
