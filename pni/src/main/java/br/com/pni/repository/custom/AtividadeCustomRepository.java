package br.com.pni.repository.custom;

import br.com.pni.controller.dto.custom.AtividadeCustomDto;
import br.com.pni.model.Atividade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AtividadeCustomRepository extends JpaRepository<Atividade, Long> {
  @Query(" SELECT NEW br.com.pni.controller.dto.custom.AtividadeCustomDto "
  		+ "(c.id as id, COUNT(a.entrega) AS entrega, c.nome, a.dataEntrega, "
  		+ "t.tedTcNumero, t.id as idTedTc, (TIMESTAMPDIFF(MONTH, c.dataInicio , "
  		+ "c.dataFim) / 3) as trimestre ) "
  		+ "FROM Atividade  a  "
  		+ "JOIN a.contrato c  "
  		+ "JOIN a.tedTc    t  "
  		+ "GROUP BY c.id ")
  List<AtividadeCustomDto> getJoin();
}
