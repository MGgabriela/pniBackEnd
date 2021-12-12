package br.com.pni.controller.form.alter;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.custom.LoginCustom;
import br.com.pni.repository.custom.LoginAddRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlteraSenhaForm {

	@NotNull
	@NotEmpty
	@Length(min = 6, max = 8)
	private String senha;
	
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public LoginCustom atualizar(Long id, 
			LoginAddRepository loginRepository) {
		
		LoginCustom s = loginRepository.findById(id).get();
		s.setSenha(this.senha);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		
		return s;
	}

}
