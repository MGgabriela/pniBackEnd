package br.com.pni.controller;

import br.com.pni.controller.dto.custom.OrderRequest;
import br.com.pni.repository.ContractsRepository;
import br.com.pni.service.pdf.PDFGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PDFExportController {

	private final PDFGeneratorService pdfGeneratorService;
	
	@Autowired
	private ContractsRepository contractsRepository;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf")
    public void generatePDF(HttpServletResponse response,
    		@RequestParam(required = false) Integer nm,
    		@RequestParam(required = false) Integer vtc,
    		@RequestParam(required = false) Integer di,
    		@RequestParam(required = false) Integer df,
    		@RequestParam(required = false) Integer fs,
			@RequestParam(required = false) Integer cpf,
			@RequestParam(required = false) Integer fd,
			@RequestParam(required = false) Integer sx,
			@RequestParam(required = false) Integer st,
			@RequestParam(required = false) Integer vc,
			@RequestParam(required = false) Integer es,
			@RequestParam(required = false) Integer mod,
			@RequestParam(required = false) Integer ins,
			@RequestParam(required = false) Integer ca,
			@RequestParam(required = false) Integer at
    		) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        	                       
        List<OrderRequest> allEmployees = contractsRepository.getJoin();
         
        this.pdfGeneratorService.export(response,allEmployees, nm,vtc,di,df,fs,cpf,fd,sx,st,vc,es,mod,ins,ca,at);
    }
}
