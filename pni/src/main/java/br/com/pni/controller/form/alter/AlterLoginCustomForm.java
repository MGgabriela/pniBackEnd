package br.com.pni.controller.form.alter;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.custom.LoginCustom;
import br.com.pni.model.custom.NivelAdd;
import br.com.pni.repository.custom.LoginAddRepository;
import br.com.pni.repository.custom.NivelAddRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlterLoginCustomForm {

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

	@NotNull
	@NotEmpty
	private Long idNivel;
	
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public LoginCustom atualizar(Long id, 
			LoginAddRepository loginRepository, 
			NivelAddRepository nRepository) {
		
		LoginCustom s = loginRepository.findById(id).get();
		NivelAdd nivel = nRepository.getById(idNivel);
		s.setNome(this.nome.toUpperCase());
		s.setEmail(this.email.toLowerCase());
		s.setSenha(this.senha);
		s.setNivel(nivel);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		
		return s;
	}

}
