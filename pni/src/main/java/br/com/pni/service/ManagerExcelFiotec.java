package br.com.pni.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
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

import br.com.pni.model.upload.Fiotec;

public class ManagerExcelFiotec {
    
    List<Fiotec> contratosF = new ArrayList<>();
   
    @SuppressWarnings("unchecked")
	public List<Fiotec> criar(String nomeDoArquivo) throws IOException{
            	
    	URL url = this.getClass().getClassLoader().getResource("\\excel\\"+nomeDoArquivo);
    	File f = null;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e) {
//			f = new File(url.getPath());
			System.out.println("erro");
		}
				
        //Recuperando o arquivo excel
        @Cleanup FileInputStream file = new FileInputStream( f );
              
		@SuppressWarnings("resource")
		Workbook work = new XSSFWorkbook(file);
        
        //Setando a aba da tabela
        Sheet sheet = work.getSheetAt(0);
        
        //Setando as linhas da tabela
        List<Row> rows = (List<Row>) toList(sheet.iterator());
        
//        System.out.println("tam1 = "+ rows.size());         
//        Remover a primeira linha(cabeçalho) da tabela
        rows.remove(0);
        rows.remove(0);
//        rows.remove(rows.size()-1);
//        System.out.println("tam2 = "+ rows.size());          
            
        rows.forEach(row ->{            
          
          //Setando as celulas e me da todas as celulas da tabelas 
          List<Cell> list = (List<Cell>) toList(row.cellIterator());
		  List<Cell> celula = list;
       
//       System.out.println("\nnome: "+celula.get(2).getStringCellValue().toUpperCase().trim());
//       System.out.println("moda: "+celula.get(3).getStringCellValue().toUpperCase().trim());
//       System.out.println("datI: "+celula.get(4).getDateCellValue());
//       System.out.println("datF: "+celula.get(5).getDateCellValue());
//       System.out.println("faix: "+celula.get(6).getNumericCellValue());
//       System.out.println("stat: "+celula.get(12).getStringCellValue().toUpperCase().trim());
       
          Fiotec contrato = Fiotec.builder()
                    .instituicao(celula.get(1).getStringCellValue().toUpperCase().trim())
                    .nome(celula.get(2).getStringCellValue().trim())
                    .modalidade(celula.get(3).getStringCellValue().toUpperCase().trim())
                    .dataInicio(celula.get(4).getDateCellValue())
                    .dataFim(celula.get(5).getDateCellValue())
                    .contratoFaixaSalarial(celula.get(6).getNumericCellValue())
                    .cpf( configCpf(celula.get(11))  )
                    .status(celula.get(12).getStringCellValue().toUpperCase().trim())                    
                  .build();          
          
          contratosF.add(contrato);
        });
      
        return contratosF;
    }
        
    public List<?> toList(Iterator<?> iterator){
        //Retorna lista da tabela
        return IteratorUtils.toList(iterator);
    }
      
    public String configCpf(Object obj){
    
    	String cpf = obj.toString();
    	if(cpf == null || cpf.length() <= 0) {
    		System.out.println("\n***C P F  VAZIO OU MENOR QUE 0***\n");
			return "00000000000";
		}else {
//        String cpfTipo = obj.getClass().getSimpleName();	
	       	cpf = cpf.replaceAll("[^0-9]", "").replace(" ", "").trim();
//	        System.out.println("cpf1: "+cpf);
//	        System.out.println("cpf1: "+cpf.length());
	        cpf = cpf.substring(0, 11);
//	        System.out.println("cpf2: "+cpf );
//	        System.out.println("cpf2: "+cpf.length());
//        BigDecimal cpf2 = new BigDecimal(cpf);                
	        return cpf;
		}
    }
   
//    public void imprimir(List<Contratos> contratos){
//        contratos.forEach(System.out::println);       
//    }    
    
  
}
