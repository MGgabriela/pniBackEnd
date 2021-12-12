package br.com.pni.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pni.model.custom.AtuacaoCustom;

public interface AtuacaoCustomRepository extends JpaRepository<AtuacaoCustom, Long>{
	
	@Query(value = "call gastos_por_atuacao; ", nativeQuery = true)
	List<AtuacaoCustom> gastoPorAtuacao();
		
}
