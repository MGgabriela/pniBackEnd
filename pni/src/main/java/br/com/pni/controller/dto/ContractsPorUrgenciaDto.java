package br.com.pni.controller.dto;

import java.time.LocalDate;
/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.util.List;
import java.util.stream.Collectors;

import br.com.pni.model.ContractsPorUrgencia;

/**
 *
 * @author gabriela
 * *
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
 */

public class ContractsPorUrgenciaDto {

	private Long id;

	private String nome;
	private String vinculo;
	private String statusC;
	private String instituicao;
	private LocalDate dataFim;
	private int progresso;
	private int faltam;
	private String color;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getVinculo() {
		return vinculo;
	}

	public String getStatusC() {
		return statusC;
	}
	
	public String getInstituicao() {
		return instituicao;
	}

	public int getProgresso() {
		return progresso;
	}

	public int getFaltam() {
		return faltam;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ContractsPorUrgenciaDto() {
	}

	public ContractsPorUrgenciaDto(ContractsPorUrgencia c) {
		this.id = c.getId();
		this.nome = c.getNome();
		this.vinculo = c.getVinculo();
		this.statusC = c.getStatusC();
		this.instituicao = c.getInst();
		this.dataFim = c.getFim();
		this.progresso = c.getProgresso();
		this.faltam = c.getFaltam();
//		this.color;
	}

	public static List<ContractsPorUrgenciaDto> converter(List<ContractsPorUrgencia> d) {
		return d.stream().map(ContractsPorUrgenciaDto::new).collect(Collectors.toList());
	}

}
