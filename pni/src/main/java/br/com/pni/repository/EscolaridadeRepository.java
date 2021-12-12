 
package br.com.pni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.Escolaridade;

public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long>{

	Escolaridade findById(Escolaridade escolaridade);

}
