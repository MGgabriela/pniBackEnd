package br.com.pni.controller.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.custom.LoginCustom;
import br.com.pni.model.custom.NivelAdd;
import br.com.pni.repository.custom.NivelAddRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginAddForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String email;

	@NotNull
	@NotEmpty
	@Length(min = 6, max = 8)
	private String senha;
	
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 100)
	private String nome;

	private Long idNivel;
	
	private Long nivelUserLog;
	
	public LoginCustom converter(NivelAddRepository sRepository) {
		NivelAdd nivel = sRepository.getById(idNivel);			
		return new LoginCustom(
				email.toLowerCase(), 
				nome.toUpperCase(), 
				senha, 
				nivel);
	}

}
