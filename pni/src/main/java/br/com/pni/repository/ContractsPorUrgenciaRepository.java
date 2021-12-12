package br.com.pni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pni.model.ContractsPorUrgencia;

@Repository
public interface ContractsPorUrgenciaRepository extends JpaRepository<ContractsPorUrgencia, Long> {
	
	@Query(value = "call pr_urgencia; ", nativeQuery = true)
	List<ContractsPorUrgencia> contratosPorUrgencia();

}
