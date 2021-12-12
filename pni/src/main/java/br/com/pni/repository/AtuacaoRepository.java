package br.com.pni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.Atuacao;

public interface AtuacaoRepository extends JpaRepository<Atuacao, Long> {

}
