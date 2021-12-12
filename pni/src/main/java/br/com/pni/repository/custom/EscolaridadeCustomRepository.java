package br.com.pni.repository.custom;

import br.com.pni.controller.dto.GraficoEscolaridade;
import br.com.pni.model.custom.EscolaridadeCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaridadeCustomRepository extends JpaRepository<EscolaridadeCustom, Long> {
	@Query(value = "SELECT ROW_NUMBER() OVER (Order by e.escolaridade_id) AS id,COUNT(c.contrato_id) AS qtd, e.escolaridade_descricao AS nome FROM tbl_contrato c INNER JOIN tbl_escolaridade e ON c.escolaridade_id = e.escolaridade_id GROUP BY e.escolaridade_id", nativeQuery = true)
	List<EscolaridadeCustom> escolaridadeGeral();

	@Query("SELECT NEW br.com.pni.controller.dto.GraficoEscolaridade(i.nome AS instituicao, e.nome AS escolaridade, COUNT(c.id) AS qtd ) FROM Contracts c JOIN c.escolaridade e JOIN c.instituicao i WHERE c.ativo = 1 GROUP BY e.id, i.id ORDER BY i.nome ")
	List<GraficoEscolaridade> getJoin();
}
