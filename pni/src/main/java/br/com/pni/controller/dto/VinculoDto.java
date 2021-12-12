package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Vinculo;

public class VinculoDto {

	private long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;

	public VinculoDto(Vinculo v) {
		this.id = v.getId();
		this.nome = v.getNome();
		this.descricao = v.getDescricao();
		this.dataCriacao = v.getDataCriacao();
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		this.nome = this.nome.toUpperCase();
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public VinculoDto() {
	}

	public static List<VinculoDto> converter(List<Vinculo> v) {
		return v.stream().map(VinculoDto::new).collect(Collectors.toList());
	}

}
