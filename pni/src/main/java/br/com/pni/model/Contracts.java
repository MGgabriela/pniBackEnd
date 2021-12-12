package br.com.pni.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author gabriela
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_contrato")
public class Contracts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contrato_id")
	private Long id;

	@NotNull
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 2, max = 255, message = "Nome não pode ultrapassar 255 caracteres")
	@Column(name = "nome_contrato")
	private String nome;

//	@DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
	@JsonFormat(pattern = "dd/MM/aaaa")
	@Column(name = "data_inicio", columnDefinition = "DATE")
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd/MM/aaaa")
//	@DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
	@Column(name = "data_fim", columnDefinition = "DATE")
	private LocalDate dataFim;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	private String cpf;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1) // @Size(min = 1, max = 1)
	private String sexo;

	@Column(name = "contrato_faixa_salarial")
	private Double contratoFaixaSalarial;

	private int ativo;

	@Column(name = "formacao_descricao")
	private String formacao;

	@ManyToOne
	@JoinColumn(name = "status_id") // (nullable = false, unique = false)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "vinculo_id")
	private Vinculo vinculo;

	@ManyToOne
	@JoinColumn(name = "escolaridade_id")
	private Escolaridade escolaridade;

	@ManyToOne
	@JoinColumn(name = "modalidade_id")
	private Modalidade modalidade;

	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	private Instituicao instituicao;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "atuacao_id")
	private Atuacao atuacao;

	// Contrutor de inserir
	public Contracts(String nome, LocalDate dataInicio, LocalDate dataFim, Double contratoFaixaSalarial, String cpf,
			String formacao, String sexo, Status statusFinal, Vinculo vinculoFinal, Escolaridade escolaridadeFinal,
			Modalidade modalidadeFinal, Instituicao instituicaoFinal, Cargo cargoFinal, Atuacao atuacaoFinal) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.contratoFaixaSalarial = contratoFaixaSalarial;
		this.cpf = cpf;
		this.formacao = formacao;
		this.sexo = sexo;
		this.status = statusFinal;
		this.vinculo = vinculoFinal;
		this.escolaridade = escolaridadeFinal;
		this.modalidade = modalidadeFinal;
		this.instituicao = instituicaoFinal;
		this.cargo = cargoFinal;
		this.atuacao = atuacaoFinal;
	}

	public Contracts(String nome) {
		this.nome = nome;
	}

}
