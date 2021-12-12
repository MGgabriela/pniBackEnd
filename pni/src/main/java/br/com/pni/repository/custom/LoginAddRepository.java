package br.com.pni.repository.custom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.custom.LoginCustom;

public interface LoginAddRepository extends JpaRepository<LoginCustom, Long>{

	List<LoginCustom> findByNivelId(Long id);

	Optional<LoginCustom> findByEmail(String login);

}
