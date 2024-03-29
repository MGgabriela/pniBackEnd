package br.com.pni.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidationHandler {
	
	@Autowired
	private MessageSource ms;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormDto> handle(MethodArgumentNotValidException ex) {
		List<ErroFormDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		fieldErrors.forEach(e ->{
			String msg = ms.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormDto erro = new ErroFormDto(e.getField(), msg);		
			dto.add(erro);
		});
		return dto;		
	}
	
//	@ControllerAdvice
//	public class RestResponseEntityExceptionHandler 
//	  extends ResponseEntityExceptionHandler {
//
//	    @ExceptionHandler({ AccessDeniedException.class })
//	    public ResponseEntity<Object> handleAccessDeniedException(
//	      Exception ex, WebRequest request) {
//	        return new ResponseEntity<Object>(
//	          "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
//	    }
//	    
//	    ...
//	}
	

}
