package br.com.pni.repository;

import br.com.pni.controller.dto.custom.OrderRequest;
import br.com.pni.model.Contracts;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts, Long> {
	List<Contracts> findByNomeContains(String paramString);

	Page<Contracts> findByStatus_Id(String paramString, Pageable paramPageable);

	@Query("SELECT NEW br.com.pni.controller.dto.custom.OrderRequest( c.nome , c.dataInicio, c.dataFim, c.contratoFaixaSalarial, c.cpf,c.formacao,c.sexo, e.nome as escolaridade, i.nome as instituicao, m.nome as modalidade,  s.nome as status,      v.nome as vinculo    ) FROM Contracts      c  JOIN c.escolaridade e  JOIN c.instituicao  i  JOIN c.modalidade   m  JOIN c.status       s  JOIN c.vinculo      v  JOIN c.cargo        ca JOIN c.atuacao      a  ")
	List<OrderRequest> getJoin();

	List<Contracts> findByNome(String paramString);

	@Query("SELECT NEW br.com.pni.model.Contracts( c.nome ) FROM Contracts c WHERE c.cpf = :cpf AND :dataIn BETWEEN c.dataInicio AND c.dataFim ")
	List<Contracts> findByEntreDatas(@Param("dataIn") LocalDate paramLocalDate, @Param("cpf") String paramString);
}
