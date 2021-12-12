package br.com.pni.controller.dto;

import br.com.pni.model.Status;
import java.util.List;
import java.util.stream.Collectors;

public class StatusDto {
	private long id;

	private String nome;

	public StatusDto(Status s) {
		this.id = s.getId();
		this.nome = s.getNome();
	}

	public long getId() {
		return this.id;
	}

	public String getNome_status() {
		this.nome = this.nome.toUpperCase();
		return this.nome;
	}

	public StatusDto() {
	}

	public static List<br.com.pni.controller.dto.StatusDto> converter(List<Status> status) {
		return (List<br.com.pni.controller.dto.StatusDto>) status.stream().map(br.com.pni.controller.dto.StatusDto::new)
				.collect(Collectors.toList());
	}
}
