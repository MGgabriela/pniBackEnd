package br.com.pni.repository.custom;

import br.com.pni.controller.dto.custom.GraficoVinculo;
import br.com.pni.model.custom.VinculoCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VinculoCustomRepository extends JpaRepository<VinculoCustom, Long> {
	@Query(value = "call pr_qtd_por_vinculo; ", nativeQuery = true)
	List<VinculoCustom> qtdPorVinculo();

	@Query(" SELECT NEW br.com.pni.controller.dto.custom.GraficoVinculo (i.nome AS instituicao, v.nome AS vinculo, COUNT(c.id) AS qtd ) FROM Contracts c JOIN c.instituicao i JOIN c.vinculo v WHERE c.ativo = 1 GROUP BY v.id, i.id ORDER BY i.nome ")
	List<GraficoVinculo> getJoin();
}
