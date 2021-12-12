package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Departamento;

public class DepartamentoDto {

	private Long id;
	private String nome;
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public DepartamentoDto() {
	}

	public DepartamentoDto(Departamento d) {
		this.id = d.getId();
		this.nome = d.getNome();
		this.descricao = d.getDescricao();
	}

	public static List<DepartamentoDto> converter(List<Departamento> d) {
		return d.stream().map(DepartamentoDto::new)
				.collect(Collectors.toList());
	}

}
