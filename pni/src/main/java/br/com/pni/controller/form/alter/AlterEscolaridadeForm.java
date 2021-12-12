package br.com.pni.controller.form.alter;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Escolaridade;
import br.com.pni.repository.EscolaridadeRepository;

public class AlterEscolaridadeForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;
	
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public AlterEscolaridadeForm() {
	}

	public Escolaridade atualizar(Long id, EscolaridadeRepository escolaridadeRepository) {
		Escolaridade e = escolaridadeRepository.findById(id).get();
		e.setNome(this.nome);
		e.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return e;
	}

}
