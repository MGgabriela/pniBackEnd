package br.com.pni.model.custom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.pni.model.Escolaridade;
import br.com.pni.model.Status;
import br.com.pni.model.Vinculo;

/**
 *
 * @author gabriela
 */
@Entity
@Table(name = "tbl_contrato")
public class ContractsCustom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contrato_id")
	private long id;

	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 2, max = 255, message = "Nome não pode ultrapassar 255 caracteres")
	@Column(name = "nome_contrato")
	private String nome;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1) // @Size(min = 1, max = 1)
	private String sexo;

	private long qtd;

	@Column(name = "data_inicio")
	private LocalDateTime dataInicio;

	@Column(name = "data_fim")
	private LocalDateTime dataFim;

	private BigDecimal valorTodosContratos;

	@Column(name = "valor_total_contrato")
	private BigDecimal valorTotalContrato;

	@ManyToOne
	@JoinColumn(name = "status_id") // (nullable = false, unique = false)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "vinculo_id") // (nullable = false, unique = false)
	private Vinculo vinculo;
	
	@Column(name = "contrato_faixa_salarial")
	private Double contratoFaixaSalarial;

	@ManyToOne
	@JoinColumn(name = "escolaridade_id") // (nullable = false, unique = false)
	private Escolaridade escolaridade;

	public ContractsCustom() {
	}

	public ContractsCustom(long qtd, String sexo) {
		this.qtd = qtd;
		this.sexo = sexo;
	}

	public ContractsCustom(long qtd) {
		this.qtd = qtd;
	}

	public ContractsCustom(BigDecimal valorTodosContratos) {
		this.valorTodosContratos = valorTodosContratos;
	}

	public BigDecimal getValorTotalContrato() {
		return valorTotalContrato;
	}

	public void setValorTotalContrato(BigDecimal valorTotalContrato) {
		this.valorTotalContrato = valorTotalContrato;
	}

	public BigDecimal getValorTodosContratos() {
		return valorTodosContratos;
	}

	public void setValorTodosContratos(BigDecimal valorTodosContratos) {
		this.valorTodosContratos = valorTodosContratos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

}
