package br.com.pni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.Login;

public interface UsuarioRepository extends JpaRepository<Login, Long>{
	
	Optional<Login> findByEmail(String login );

}
