package br.com.pni.controller.form.alter;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Modalidade;
import br.com.pni.repository.ModalidadeRepository;

public class AlterModalidadeForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public AlterModalidadeForm() {
	}

	public Modalidade atualizar(Long id, ModalidadeRepository modalidadeRepository) {
		Modalidade s = modalidadeRepository.findById(id).get();
		s.setNome(this.nome);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return s;
	}

}
