package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Escolaridade;

public class EscolaridadeDto {

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public EscolaridadeDto() {
	}

	public EscolaridadeDto(Escolaridade e) {
		super();
		this.id = e.getId();
		this.nome = e.getNome();
	}

	public static List<EscolaridadeDto> converter(List<Escolaridade> e) {
		return e.stream().map(EscolaridadeDto::new).collect(Collectors.toList());
	}

}
