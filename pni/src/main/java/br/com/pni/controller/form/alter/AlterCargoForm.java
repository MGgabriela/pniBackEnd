package br.com.pni.controller.form.alter;

import br.com.pni.model.Cargo;
import br.com.pni.repository.CargoRepository;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AlterCargoForm {
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50)
	private String nome;

	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		nome = nome.toUpperCase();
		this.nome = nome;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return this.dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Cargo atualizar(Long id, CargoRepository cargoRepository) {
		Cargo s = cargoRepository.findById(id).get();
		s.setNome(this.nome);
		s.setDataUltimaAlteracao(this.dataUltimaAlteracao);
		return s;
	}
}
