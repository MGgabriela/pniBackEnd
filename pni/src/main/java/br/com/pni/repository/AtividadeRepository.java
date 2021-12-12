package br.com.pni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pni.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

	@Query(value = "SELECT a.* from tbl_atividade a where a.atividade_id = :id ", nativeQuery=true )
	Atividade getAtividade(@Param("id") Long id);

	@Query(value = "SELECT COUNT(a.entrega) "
			+ "from tbl_atividade a WHERE contrato_id = :id ", nativeQuery=true)
	Atividade getContratoEntrega(Long id);

}
