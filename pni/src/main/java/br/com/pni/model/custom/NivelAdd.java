package br.com.pni.model.custom;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_nivel_acesso")
public class NivelAdd {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nivel_id")
	private Long id;
	
	@Column(name = "nome_nivel")
	private String nome;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();
	
	

}
