package br.com.pni.controller.dto.custom;

/*
 * Data Transfer Object
 * Dados que vão da API para o cliente
 *
*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author gabriela
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractsTotalContratosDto {

	private Double valorTodosContratos;

}
