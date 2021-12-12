package br.com.pni.controller.form.alter;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

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
import br.com.pni.repository.ContractsRepository;
import br.com.pni.repository.EscolaridadeRepository;
import br.com.pni.repository.InstituicaoRepository;
import br.com.pni.repository.ModalidadeRepository;
import br.com.pni.repository.StatusRepository;
import br.com.pni.repository.VinculoRepository;
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
public class AlterContractsForm {

	@NotNull
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 2, max = 255, message = "Nome não pode ultrapassar 255 caracteres")
	@Column(name = "nome_contrato")
	private String nome;

//	@NotEmpty
//	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
//	@DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
	@Column(name = "data_inicio", columnDefinition = "DATE")
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
//	@DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
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

	public Contracts atualizar(Long id, ContractsRepository co, StatusRepository s, VinculoRepository v,
			EscolaridadeRepository e, ModalidadeRepository m, InstituicaoRepository i, CargoRepository c,
			AtuacaoRepository a) {

		Contracts contrato = co.findById(id).get();
		Status status = s.getById(idStatus);
		Vinculo vinculo = v.getById(idVinculo);
		Escolaridade escolaridade = e.getById(idEscolaridade);
		Modalidade modalidade = m.getById(idModalidade);
		Instituicao instituicao = i.getById(idInstituicao);
		Cargo cargo = c.getById(idCargo);
		Atuacao atuacao = a.getById(idAtuacao);

		contrato.setNome(this.nome.toUpperCase());
		contrato.setDataInicio(this.dataInicio);
		contrato.setDataFim(this.dataFim);
		contrato.setContratoFaixaSalarial(this.contratoFaixaSalarial);
		contrato.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		contrato.setCpf(this.cpf);
		contrato.setFormacao(this.formacao);
		contrato.setSexo(this.sexo.toUpperCase());

		contrato.setStatus(status);
		contrato.setVinculo(vinculo);
		contrato.setEscolaridade(escolaridade);
		contrato.setModalidade(modalidade);
		contrato.setInstituicao(instituicao);
		contrato.setCargo(cargo);
		contrato.setAtuacao(atuacao);
		contrato.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return contrato;
	}

}
