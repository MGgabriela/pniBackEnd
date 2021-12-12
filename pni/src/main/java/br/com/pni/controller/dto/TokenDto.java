package br.com.pni.controller.dto;

public class TokenDto {
	
	private String token;
	private String tipoAutorizacao;
	private String nome;
	private Long nivel;

	public TokenDto(String token, String tipoAutorizacao, String nome, Long nivel) {
		this.token = token;
		this.tipoAutorizacao = tipoAutorizacao;
		this.nome = nome;
		this.nivel = nivel;
	}
	
	public TokenDto(String token, String tipoAutorizacao) {
		this.token = token;
		this.tipoAutorizacao = tipoAutorizacao;
	}

	public String getToken() {
		return token;
	}

	public String getTipoAutorizacao() {
		return tipoAutorizacao;
	}

	public String getNome() {
		return nome;
	}

	public Long getNivel() {
		return nivel;
	}
	
	

}
