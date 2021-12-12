package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Instituicao;

public class InstituicaoDto {

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public InstituicaoDto(Instituicao s) {
		this.id = s.getId();
		this.nome = s.getNome();
	}

	public InstituicaoDto() {
	}

	public static List<InstituicaoDto> converter(List<Instituicao> s) {
		return s.stream().map(InstituicaoDto::new).collect(Collectors.toList());
	}

}
