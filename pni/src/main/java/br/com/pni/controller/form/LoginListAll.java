package br.com.pni.controller.form;

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
public class LoginListAll {

	private Long idNivel;

	public LoginCustom converter(NivelAddRepository sRepository) {
		NivelAdd nivel = sRepository.getById(idNivel);			
		return new LoginCustom(nivel);
	}

}
