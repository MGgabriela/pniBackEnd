package br.com.pni.repository.custom;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.custom.AtividadeAdd;

public interface AtividadeAddRepository extends JpaRepository<AtividadeAdd, Long> {

	void save(br.com.pni.controller.dto.custom.LoginAddDto a);

}