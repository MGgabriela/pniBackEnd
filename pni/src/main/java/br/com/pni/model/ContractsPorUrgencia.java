package br.com.pni.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContractsPorUrgencia {
	@Id
	private Long id;

	private String nome;

	private String vinculo;

	private String statusC;

	private LocalDate fim;

	private String inst;

	private int progresso;

	private int faltam;

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getVinculo() {
		return this.vinculo;
	}

	public String getStatusC() {
		return this.statusC;
	}

	public int getProgresso() {
		return this.progresso;
	}

	public int getFaltam() {
		return this.faltam;
	}

	public LocalDate getFim() {
		return this.fim;
	}

	public String getInst() {
		return this.inst;
	}
}
