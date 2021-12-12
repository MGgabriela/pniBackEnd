package br.com.pni.controller.form.alter;

import br.com.pni.model.Departamento;
import br.com.pni.model.Secretaria;
import br.com.pni.repository.DepartamentoRepository;
import br.com.pni.repository.SecretariaRepository;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AlterDepartamentoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	@Length(max = 100)
	private String descricao;

	private Long idSecretaria;

	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return this.dataUltimaAlteracao;
	}

	public Long getIdSecretaria() {
		return this.idSecretaria;
	}

	public void setIdSecretaria(Long idSecretaria) {
		this.idSecretaria = idSecretaria;
	}

	public Departamento converter(SecretariaRepository sRepository) {
		Secretaria secretaria = (Secretaria) sRepository.getById(this.idSecretaria);
		return new Departamento(this.nome, this.descricao, secretaria);
	}

	public Departamento atualizar(long id, DepartamentoRepository dRepository, SecretariaRepository sRepository) {
		Departamento s = dRepository.findById(Long.valueOf(id)).get();
		Secretaria secretaria = (Secretaria) sRepository.getById(this.idSecretaria);
		s.setNome(this.nome);
		s.setDescricao(this.descricao);
		s.setSecretaria(secretaria);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return s;
	}
}
