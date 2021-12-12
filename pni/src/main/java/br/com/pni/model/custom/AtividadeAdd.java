package br.com.pni.model.custom;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_atividade")
public class AtividadeAdd {
	
	@Id
	@Column(name = "atividade_id")
	private Long id;
	private int entrega;
	
	@Column(name = "data_entrega")
	private LocalDate dataEntrega = LocalDate.now();
	
	@Column(name = "ted_tc_id")
	private int idTedTc;
	
	@Column(name = "contrato_id")
	private long idContrato;
	
}
