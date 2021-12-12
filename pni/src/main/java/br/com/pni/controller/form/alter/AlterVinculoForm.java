package br.com.pni.controller.form.alter;

import br.com.pni.model.Vinculo;
import br.com.pni.repository.VinculoRepository;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AlterVinculoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	@Length(max = 50)
	private String descricao;

	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Vinculo atualizar(long id, VinculoRepository vRepository) {
		Vinculo s = vRepository.findById(Long.valueOf(id)).get();
		this.nome = this.nome.toUpperCase();
		s.setNome(this.nome);
		s.setDescricao(this.descricao);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return s;
	}
}
