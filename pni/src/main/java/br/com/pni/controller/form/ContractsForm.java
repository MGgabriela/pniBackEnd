package br.com.pni.controller.form;

import br.com.pni.model.Atuacao;
import br.com.pni.model.Cargo;
import br.com.pni.model.Contracts;
import br.com.pni.model.Escolaridade;
import br.com.pni.model.Instituicao;
import br.com.pni.model.Modalidade;
import br.com.pni.model.Status;
import br.com.pni.model.Vinculo;
import br.com.pni.repository.AtuacaoRepository;
import br.com.pni.repository.CargoRepository;
import br.com.pni.repository.EscolaridadeRepository;
import br.com.pni.repository.InstituicaoRepository;
import br.com.pni.repository.ModalidadeRepository;
import br.com.pni.repository.StatusRepository;
import br.com.pni.repository.VinculoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class ContractsForm {
	@NotNull
	@NotEmpty(message = "Nome npode ser vazio")
	@Size(min = 2, max = 255, message = "Nome npode ultrapassar 255 caracteres")
	@Column(name = "nome_contrato")
	private String nome;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_inicio", columnDefinition = "DATE")
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_fim", columnDefinition = "DATE")
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

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1)
	private String sexo;

	private Long idStatus;

	private Long idVinculo;

	private Long idEscolaridade;

	private Long idModalidade;

	private Long idInstituicao;

	private Long idCargo;

	private Long idAtuacao;

	public Contracts converter(StatusRepository sRepos, VinculoRepository vResp, EscolaridadeRepository eResp,
			ModalidadeRepository mResp, InstituicaoRepository iResp, CargoRepository cResp, AtuacaoRepository aResp) {
		Status s = (Status) sRepos.getById(this.idStatus);
		Vinculo v = (Vinculo) vResp.getById(this.idVinculo);
		Escolaridade e = (Escolaridade) eResp.getById(this.idEscolaridade);
		Modalidade m = (Modalidade) mResp.getById(this.idModalidade);
		Instituicao i = (Instituicao) iResp.getById(this.idInstituicao);
		Cargo c = (Cargo) cResp.getById(this.idCargo);
		Atuacao a = (Atuacao) aResp.getById(this.idAtuacao);
		return new Contracts(this.nome.toUpperCase(), this.dataInicio, this.dataFim, this.contratoFaixaSalarial,
				this.cpf, this.formacao, this.sexo

						.toUpperCase(),
				s, v, e, m, i, c, a);
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

	public LocalDateTime getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return this.dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
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

	public Long getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public Long getIdVinculo() {
		return this.idVinculo;
	}

	public void setIdVinculo(Long idVinculo) {
		this.idVinculo = idVinculo;
	}

	public Long getIdEscolaridade() {
		return this.idEscolaridade;
	}

	public void setIdEscolaridade(Long idEscolaridade) {
		this.idEscolaridade = idEscolaridade;
	}

	public Long getIdModalidade() {
		return this.idModalidade;
	}

	public void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}

	public Long getIdInstituicao() {
		return this.idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public Long getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public Long getIdAtuacao() {
		return this.idAtuacao;
	}

	public void setIdAtuacao(Long idAtuacao) {
		this.idAtuacao = idAtuacao;
	}
}
