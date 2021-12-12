package br.com.pni.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_contrato")
public class UploadContratos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contrato_id")
	private Long id;

	@NotNull
	@NotEmpty(message = "Nome npode ser vazio")
	@Size(min = 2, max = 255, message = "Nome npode ultrapassar 255 caracteres")
	@Column(name = "nome_contrato")
	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_fim")
	private LocalDate dataFim;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	@Column(name = "valor_total_contrato")
	private BigDecimal valorTotalContrato;

	private String cpf;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1)
	private String sexo;

	@Column(name = "contrato_faixa_salarial")
	private BigDecimal contratoFaixaSalarial;

	private int ativo;

	@Column(name = "formacao_descricao")
	private String formacao;

	@ManyToOne
	@JoinColumn(name = "status_id")
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public BigDecimal getValorTotalContrato() {
		return this.valorTotalContrato;
	}

	public void setValorTotalContrato(BigDecimal valorTotalContrato) {
		this.valorTotalContrato = valorTotalContrato;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getContratoFaixaSalarial() {
		return this.contratoFaixaSalarial;
	}

	public void setContratoFaixaSalarial(BigDecimal contratoFaixaSalarial) {
		this.contratoFaixaSalarial = contratoFaixaSalarial;
	}

	public int getAtivo() {
		return this.ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public String getFormacao() {
		return this.formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public UploadContratos() {
	}

	public UploadContratos(
			@NotNull @NotEmpty(message = "Nome npode ser vazio") @Size(min = 2, max = 255, message = "Nome npode ultrapassar 255 caracteres") String nome,
			LocalDate dataInicio, LocalDate dataFim, BigDecimal valorTotalContrato, String cpf,
			@NotNull @NotEmpty @Length(min = 1, max = 1) String sexo, BigDecimal contratoFaixaSalarial, String formacao,
			Status status, Vinculo vinculo, Escolaridade escolaridade) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valorTotalContrato = valorTotalContrato;
		this.cpf = cpf;
		this.sexo = sexo;
		this.contratoFaixaSalarial = contratoFaixaSalarial;
		this.formacao = formacao;
		this.status = status;
		this.vinculo = vinculo;
		this.escolaridade = escolaridade;
	}
}
