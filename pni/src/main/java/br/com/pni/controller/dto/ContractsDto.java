package br.com.pni.controller.dto;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.pni.model.Contracts;

/**
 *
 * @author gabriela
 */

public class ContractsDto {

	private Long id;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String cpf;
	private String sexo;
	private Double contratoFaixaSalarial;

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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getContratoFaixaSalarial() {
		return contratoFaixaSalarial;
	}

	public void setContratoFaixaSalarial(Double contratoFaixaSalarial) {
		this.contratoFaixaSalarial = contratoFaixaSalarial;
	}

	public ContractsDto() {
	}

	public ContractsDto(Contracts s) {
		this.id = s.getId();
		this.nome = s.getNome();
		this.dataInicio = s.getDataInicio();
		this.dataFim = s.getDataFim();
		this.cpf = s.getCpf();
		this.sexo = s.getSexo();
		this.contratoFaixaSalarial = s.getContratoFaixaSalarial();
	}

	public static Page<ContractsDto> converter(Page<Contracts> s) {
		return s.map(ContractsDto::new);// s.stream().map(ContractsDto::new).collect(Collectors.toList());
	}

	public static List<ContractsDto> converterList(List<Contracts> d) {
		return d.stream().map(ContractsDto::new).collect(Collectors.toList());
	}

}
