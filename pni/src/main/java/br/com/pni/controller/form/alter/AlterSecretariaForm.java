package br.com.pni.controller.form.alter;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Secretaria;
import br.com.pni.repository.SecretariaRepository;

public class AlterSecretariaForm {
	
	@NotNull @NotEmpty @Length(min = 2, max = 50)
	private String nome;

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public AlterSecretariaForm() {
	}
	
	public Secretaria atualizar(Long id, SecretariaRepository secretariaRepository) {		
		Secretaria s = secretariaRepository.findById(id).get();
		s.setNome(this.nome);		
		return s;
	}



}
