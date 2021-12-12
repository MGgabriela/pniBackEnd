package br.com.pni.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pni.controller.dto.StatusDto;
import br.com.pni.controller.form.StatusForm;
import br.com.pni.controller.form.alter.AlterStatusForm;
import br.com.pni.model.Status;
import br.com.pni.repository.StatusRepository;
import br.com.pni.service.pdf.ExportPdf;

@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusRepository statusRepository;

	@GetMapping
	public List<StatusDto> lista(String nomeStatus) {
		if(nomeStatus == null) {
			List<Status> x = statusRepository.findAll();
			return StatusDto.converter(x);
		}
		List<Status> x = statusRepository.findByNome(nomeStatus);
		return StatusDto.converter(x);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusDto> detalhar(@PathVariable long id) {
	 	Optional<Status> status = statusRepository.findById(id);
	 	if(status.isPresent()) {
	 		return ResponseEntity.ok(new StatusDto(status.get()));
	 	}
	 	return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<StatusDto> cadastrar(@RequestBody @Valid StatusForm form, UriComponentsBuilder uriBuilder) {		
		Status s = form.converter();
		statusRepository.save(s);	
		URI uri = uriBuilder.path("/status/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(uri).body(new StatusDto(s));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StatusDto> alteraStatus(@PathVariable long id, @RequestBody @Valid AlterStatusForm form) {		
		Optional<Status> op = statusRepository.findById(id);
		if(op.isPresent()) {
			Status s = form.atualizar(id, statusRepository);
			return ResponseEntity.ok(new StatusDto(s));
		}
		return ResponseEntity.notFound().build();	
		
	}
	
	
	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

		List<Status> allEmployees = statusRepository.findAll();

		ByteArrayInputStream bis = ExportPdf.employeesReport(allEmployees);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=employees.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
}
