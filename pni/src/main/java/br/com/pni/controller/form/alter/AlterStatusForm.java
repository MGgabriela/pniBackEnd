package br.com.pni.controller.form.alter;

import br.com.pni.model.Status;
import br.com.pni.repository.StatusRepository;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AlterStatusForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status atualizar(long id, StatusRepository statusRepository) {
		Status s = statusRepository.findById(Long.valueOf(id)).get();
		this.nome = this.nome.toUpperCase();
		s.setNome(this.nome);
		return s;
	}
}
