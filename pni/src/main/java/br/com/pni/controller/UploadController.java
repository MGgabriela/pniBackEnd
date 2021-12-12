package br.com.pni.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.pni.model.Status;
import br.com.pni.model.upload.Contratos;
import br.com.pni.model.upload.Fiotec;
import br.com.pni.model.upload.RhTodos;
import br.com.pni.service.CallManagerExcel;
import br.com.pni.service.MontaDados;
import br.com.pni.service.ProcessadorService;

@RestController
public class UploadController {

	List<Fiotec> listFiotec ;
	List<RhTodos> listRh ;
//	List<Opas> listOpas;
	ArrayList<Contratos> listFinal ;
	List<Status> listF ;
	
	@Autowired
	private ProcessadorService processadorService;
	
	 MultipartFile fileFiotec = null;
	 MultipartFile fileRh = null;
	 MultipartFile fileOpas = null;
		int i =0;
	@PostMapping("/upload")
	public ResponseEntity<Object> uploadFiotec(
			@RequestParam("File") MultipartFile[] files
			) throws IOException {

		URL url = this.getClass().getClassLoader().getResource("\\excel\\");
		
		File f = null;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e) {
			f = new File(url.getPath());
			System.out.println("\n**erro URL upload**\n");
		}
			
	      Arrays.asList(files).stream().forEach(file -> {
	        
			if(file.getOriginalFilename().toLowerCase().contains("fiotec".toLowerCase())){
				fileFiotec = file;				
			}else {
				if(file.getOriginalFilename().toLowerCase().contains("fiotec".toLowerCase())) {
					fileFiotec = file;					
				}else {
					if(file.getOriginalFilename().toLowerCase().contains("fiotec".toLowerCase())) {
						fileFiotec = file;						
					}else {
						if(file.getOriginalFilename().toLowerCase().contains("rh".toLowerCase())){
							fileRh = file;					
						}else {
							if(file.getOriginalFilename().toLowerCase().contains("rh".toLowerCase())) {
								fileRh = file;
							}else {
								if(file.getOriginalFilename().toLowerCase().contains("rh".toLowerCase())) {
									fileRh = file;
								}
							}
						}
					}
				}
			}
					
			if(file.getOriginalFilename()
					.toLowerCase()
					.contains("opas".toLowerCase())){
				fileOpas = file;
			}else {
				if(file.getOriginalFilename()
						.toLowerCase()
						.contains("opas".toLowerCase())) {
					fileOpas = file;
				}else {
					if(file.getOriginalFilename()
							.toLowerCase()
							.contains("opas".toLowerCase())) {
						fileOpas = file;
					}
				}
			}       
	        
	      });
	      
		File myFileFiotec = new File(f +"\\"+ fileFiotec.getOriginalFilename());		
		File myFileRh = new File(f +"\\"+ fileRh.getOriginalFilename());		
		File myFileOpas = new File(f +"\\"+ fileOpas.getOriginalFilename());		
		myFileFiotec.createNewFile();		
		myFileRh.createNewFile();		
		myFileOpas.createNewFile();		
		FileOutputStream fosF = new FileOutputStream(myFileFiotec);		
		FileOutputStream fosR = new FileOutputStream(myFileRh);		
		FileOutputStream fosO = new FileOutputStream(myFileOpas);		
		fosF.write(fileFiotec.getBytes());
		fosR.write(fileRh.getBytes());
		fosO.write(fileOpas.getBytes());
		fosF.close();
		fosR.close();
		fosO.close();
		
		CallManagerExcel call = new CallManagerExcel();

		listFiotec = call.callFiotec(fileFiotec.getOriginalFilename());
		listRh     = call.callRh(fileRh.getOriginalFilename());
//		listOpas   = call.callFiotec(fileOpas.getOriginalFilename());

		MontaDados monta = new MontaDados();
		listFinal = (ArrayList<Contratos>) monta.teste(listRh, listFiotec);
		
		processadorService.processar(listFinal);
		
		return new ResponseEntity<Object>(listFinal, HttpStatus.OK);
	}

}