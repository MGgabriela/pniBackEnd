package br.com.pni.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atividade_id")
	private Long id;
	
	private int entrega;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_entrega")
	private LocalDate dataEntrega  = LocalDate.now();
		
	@ManyToOne
	@JoinColumn(name = "contrato_id")
	private Contracts contrato;
	
	@ManyToOne
	@JoinColumn(name = "ted_tc_id")
	private TedTc tedTc;
	
	//Construtor de Inserir
	public Atividade(int entrega,Contracts contrato, TedTc tedTc ) {
		this.entrega = entrega;
		this.contrato = contrato;
		this.tedTc = tedTc;
		
	}

}
