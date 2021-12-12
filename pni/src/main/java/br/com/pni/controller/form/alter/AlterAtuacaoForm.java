package br.com.pni.controller.form.alter;

import br.com.pni.model.Atuacao;
import br.com.pni.repository.AtuacaoRepository;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AlterAtuacaoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	@Length(max = 100)
	private String descricao;

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

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Atuacao atualizar(long id, AtuacaoRepository aRepository) {
		Atuacao s = aRepository.findById(Long.valueOf(id)).get();
		this.nome = this.nome.toUpperCase();
		s.setNome(this.nome);
		s.setDescricao(this.descricao);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return s;
	}
}
