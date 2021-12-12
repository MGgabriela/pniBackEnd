package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Secretaria;

public class SecretariaDto {

	private Long id;
	private String nome;

	public SecretariaDto(Secretaria s) {
		this.id = s.getId();
		this.nome = s.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public SecretariaDto() {
	}

	public static List<SecretariaDto> converter(List<Secretaria> s) {
		return s.stream().map(SecretariaDto::new).collect(Collectors.toList());
	}

}
