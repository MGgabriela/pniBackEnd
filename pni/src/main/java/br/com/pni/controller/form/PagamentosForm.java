package br.com.pni.controller.form;

import br.com.pni.model.Status;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class PagamentosForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome_status;

	public String getNome_status() {
		return this.nome_status;
	}

	public void setNome_status(String nome_status) {
		this.nome_status = nome_status;
	}

	public Status converter() {
		return new Status(this.nome_status);
	}
}
