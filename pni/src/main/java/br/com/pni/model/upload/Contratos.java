package br.com.pni.model.upload;

import br.com.pni.model.Atuacao;
import br.com.pni.model.Cargo;
import br.com.pni.model.Escolaridade;
import br.com.pni.model.Instituicao;
import br.com.pni.model.Modalidade;
import br.com.pni.model.Status;
import br.com.pni.model.Vinculo;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_contrato")
public class Contratos {
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

	@Column(name = "contrato_faixa_salarial")
	private Double contratoFaixaSalarial;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	private String cpf;

	@Column(name = "formacao_descricao")
	private String formacao;

	private String sexo;

	private String status;

	private String vinculo;

	private String escolaridade;

	private String modalidade;

	private String instituicao;

	private String cargo;

	private String atuacao;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status idStatus;

	@ManyToOne
	@JoinColumn(name = "vinculo_id")
	private Vinculo vinculoFinal;

	@ManyToOne
	@JoinColumn(name = "escolaridade_id")
	private Escolaridade escolaridadeFinal;

	@ManyToOne
	@JoinColumn(name = "modalidade_id")
	private Modalidade modalidadeFinal;

	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	private Instituicao instituicaoFinal;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargoFinal;

	@ManyToOne
	@JoinColumn(name = "atuacao_id")
	private Atuacao atuacaoFinal;

	private String departamento;

	private String unidade;

	private String secretaria;

	private int ativo;

	public Contratos(String nome, LocalDate dataInicio, LocalDate dataFim, Double contratoFaixaSalarial, String cpf,
			String formacao, String sexo, String status, String vinculo, String escolaridade, String modalidade,
			String instituicao, String cargo, String atuacao, String departamento, String unidade) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.contratoFaixaSalarial = contratoFaixaSalarial;
		this.cpf = cpf;
		this.formacao = formacao;
		this.sexo = sexo;
		this.status = status;
		this.vinculo = vinculo;
		this.escolaridade = escolaridade;
		this.modalidade = modalidade;
		this.instituicao = instituicao;
		this.cargo = cargo;
		this.atuacao = atuacao;
		this.departamento = departamento;
		this.unidade = unidade;
	}

	public Contratos() {
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

	public Double getContratoFaixaSalarial() {
		return this.contratoFaixaSalarial;
	}

	public void setContratoFaixaSalarial(Double contratoFaixaSalarial) {
		this.contratoFaixaSalarial = contratoFaixaSalarial;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFormacao() {
		return this.formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVinculo() {
		return this.vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public String getEscolaridade() {
		return this.escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAtuacao() {
		return this.atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getSecretaria() {
		return this.secretaria;
	}

	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}

	public int getAtivo() {
		return this.ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
}
