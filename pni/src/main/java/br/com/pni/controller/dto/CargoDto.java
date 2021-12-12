package br.com.pni.controller.dto;

/**
*
* @author gabriela
* *
* Data Transfer Object
* Dados que vão da API para o cliente
*
*/
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.Cargo;

public class CargoDto {

	private Long id;
	private String nome;
	private LocalDateTime dataCriacao;

	public CargoDto(Cargo s) {
		this.id = s.getId();
		this.nome = s.getNome();
		this.dataCriacao = s.getDataCriacao();
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public CargoDto() {
	}

	public static List<CargoDto> converter(List<Cargo> s) {
		return s.stream().map(CargoDto::new).collect(Collectors.toList());
	}

}
