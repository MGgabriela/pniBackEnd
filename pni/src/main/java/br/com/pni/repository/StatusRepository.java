 
package br.com.pni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{

	List<Status> findByNome(String nomeStatus);

	Status findById(Status status);
	
}
