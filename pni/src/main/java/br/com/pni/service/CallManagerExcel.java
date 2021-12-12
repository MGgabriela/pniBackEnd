package br.com.pni.service;

import java.io.IOException;
import java.util.List;

import br.com.pni.model.upload.Fiotec;
import br.com.pni.model.upload.RhTodos;

public class CallManagerExcel {
	
	List<RhTodos> rhTodos;
	List<Fiotec> contratosFiotec;
	boolean fiotec = false;
	boolean rh = false;
	boolean opas = false;
	
	public List<Fiotec> callFiotec(String nomeDoArquivo ) throws IOException {
		ManagerExcelFiotec gContratos = new ManagerExcelFiotec();		
		contratosFiotec = gContratos.criar(nomeDoArquivo);				
		return contratosFiotec;
		
	}
	
	public List<RhTodos> callRh(String nomeDoArquivo ) throws IOException {
		ManagerExcelRH gContratosRH = new ManagerExcelRH();		
		rhTodos = gContratosRH.criarRh(nomeDoArquivo);	
		rh = true;
		return rhTodos;
	}
	
	public void callOpas(String nomeDoArquivo ) throws IOException {
		ManagerExcelRH gContratosRH = new ManagerExcelRH();
		rhTodos = gContratosRH.criarRh(nomeDoArquivo);	
		opas = true;
	}

}
