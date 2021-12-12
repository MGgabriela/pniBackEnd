package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Modalidade;

public class ModalidadeDto {

	private Long id;
	private String nome;

	public ModalidadeDto(Modalidade s) {
		this.id = s.getId();
		this.nome = s.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ModalidadeDto() {
	}

	public static List<ModalidadeDto> converter(List<Modalidade> s) {
		return s.stream().map(ModalidadeDto::new).collect(Collectors.toList());
	}

}
