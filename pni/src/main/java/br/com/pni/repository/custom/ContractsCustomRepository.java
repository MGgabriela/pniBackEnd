package br.com.pni.repository.custom;

import br.com.pni.controller.dto.custom.ContractsTotalContratosDto;
import br.com.pni.model.Contracts;
import br.com.pni.model.custom.ContractsCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsCustomRepository extends JpaRepository<ContractsCustom, Long> {
	List<Contracts> findByNomeContains(String paramString);

	List<Contracts> findByStatus_Id(Integer paramInteger);

	@Query("SELECT NEW br.com.pni.model.custom.ContractsCustom(COUNT(id) AS qtd) FROM ContractsCustom")
	List<ContractsCustom> totalContratados();

	@Query("SELECT NEW br.com.pni.model.custom.ContractsCustom(COUNT(id) AS qtd, sexo) FROM ContractsCustom GROUP BY sexo")
	List<ContractsCustom> divisaoPorSexo();

	@Query("SELECT NEW br.com.pni.controller.dto.custom.ContractsTotalContratosDto(SUM(TIMESTAMPDIFF(MONTH, c.dataInicio , c.dataFim ) * contratoFaixaSalarial) AS valorTodosContratos) FROM ContractsCustom c")
	List<ContractsTotalContratosDto> getJoin();

	@Query(value = "call taxa_turnover; ", nativeQuery = true)
	Float turnover();
}
