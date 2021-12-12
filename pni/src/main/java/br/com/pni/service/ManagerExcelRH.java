package br.com.pni.service;

import br.com.pni.model.upload.RhTodos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagerExcelRH {

	List<RhTodos> rhTodos = new ArrayList<>();

	public List<RhTodos> criarRh(String nomeDoArquivo) throws IOException {

    	URL url = this.getClass().getClassLoader().getResource("\\excel\\"+nomeDoArquivo);
    	File f = null;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e) {
//			f = new File(url.getPath());
			System.out.println("erro");
		}
		
		// Recuperando o arquivo excel
		@Cleanup
		FileInputStream rhTodos1 = new FileInputStream(f);

		Workbook workRhTodos = new XSSFWorkbook(rhTodos1);

		// Setando a aba da tabela
		Sheet sheetRhTodos = workRhTodos.getSheetAt(0);

		// Setando as linhas da tabela
		List<Row> rowsRhTodos = (List<Row>) toList(sheetRhTodos.iterator());

		// System.out.println("tam1 = "+ rowsRhTodos.size());
		// Remover a primeira linha(cabeçalho) da tabela
		rowsRhTodos.remove(0);
		// rows.remove(rows.size()-1);
		// System.out.println("tam2 = "+ rowsRhTodos.size());

		rowsRhTodos.forEach(row -> {
			// me da todas as celulas da tabelas(Setando as celulas)
			List<Cell> celula = (List<Cell>) toList(row.cellIterator());

			RhTodos contrato = RhTodos.builder().cpf(configCpf(celula.get(0)))
					.nome(celula.get(2).getStringCellValue().trim()).sexo(celula.get(3).getStringCellValue().trim())
					.formacao(celula.get(4).getStringCellValue().trim())
					.escolaridade(celula.get(5).getStringCellValue().trim())
					.vinculo(celula.get(6).getStringCellValue().trim())
					.cargo(celula.get(9).getStringCellValue().trim())
					.departamento(celula.get(11).getStringCellValue().trim())
					.unidade(celula.get(12).getStringCellValue().trim())
					.atuacao(celula.get(13).getStringCellValue().trim())
					.build();
			//
			// ValidaDadosFiotec f = new ValidaDadosFiotec();
			// f.validaModalidade(contrato);

			rhTodos.add(contrato);
		});

		return rhTodos;
	}

	public String configValorTotalContrato(Object obj) {
		String valor = obj.toString();
		return valor;
	}

	public String configCpf(Object obj) {
		if(obj == null) {
			return null;
		}else {
			String cpf = obj.toString();
			cpf = cpf.replaceAll("[^0-9]", "").replace(" ", "").trim();
			cpf = cpf.substring(0, 11);
			return cpf;
		}
		
	}

	public List<?> toList(Iterator<?> iterator) {
		// Retorna lista da tabela
		return IteratorUtils.toList(iterator);
	}

}
