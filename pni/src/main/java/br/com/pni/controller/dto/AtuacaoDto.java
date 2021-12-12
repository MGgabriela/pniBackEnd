package br.com.pni.controller.dto;
/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Atuacao;

public class AtuacaoDto {

	private long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataUltimaAlteracao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public AtuacaoDto() {
	}
	
//	construtor  
	public AtuacaoDto(Atuacao a) {
		this.id = a.getId();
		this.nome = a.getNome();
		this.descricao = a.getDescricao();
		this.dataUltimaAlteracao = a.getDataUltimaAlteracao();
	}
	
	public static List<AtuacaoDto> converter(List<Atuacao> s) {
		return s.stream().map(AtuacaoDto::new).collect(Collectors.toList());
	}
	
	

}
