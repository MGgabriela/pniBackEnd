package br.com.pni.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Unidade;

public class UnidadeDto {

	private Long id;
	private String nome;
	private String descricao;
//	private LocalDateTime dataUltimaAlteracao;

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

	public UnidadeDto() {
	}

	public UnidadeDto(Unidade u) {
		this.id = u.getId();
		this.nome = u.getNome();
		this.descricao = u.getDescricao();
	}

	public static List<UnidadeDto> converter(List<Unidade> u) {
		return u.stream().map(UnidadeDto::new).collect(Collectors.toList());
	}

}
