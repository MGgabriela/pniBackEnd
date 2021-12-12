 
package br.com.pni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.Vinculo;

public interface VinculoRepository extends JpaRepository<Vinculo, Long>{

	List<Vinculo> findByNome(String nome);

}
