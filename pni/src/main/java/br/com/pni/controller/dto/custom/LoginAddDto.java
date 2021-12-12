package br.com.pni.controller.dto.custom;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.custom.LoginCustom;
import br.com.pni.model.custom.NivelAdd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginAddDto {
			
	private Long id;
	private String email;	
	private String nome;
	private NivelAdd nivel;

	public LoginAddDto(LoginCustom login) {
		this.id    = login.getId();
		this.email = login.getEmail();
		this.nivel = login.getNivel();
		this.nome  = login.getNome();
	}
		
	public static List<LoginAddDto> converter(List<LoginCustom> login) {
		return login.stream().map(LoginAddDto::new)
				.collect(Collectors.toList());
	}	
	
}
