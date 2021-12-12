package br.com.pni.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.custom.LoginCustom2;

public interface LoginCustom2Repository extends JpaRepository<LoginCustom2, Long>{

	List<LoginCustom2> findByEmail(String login);

	List<LoginCustom2> findByNivelId(String email);

}
