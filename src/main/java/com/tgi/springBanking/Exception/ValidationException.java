package com.tgi.springBanking.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ValidationException extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(value = { InvalidInputException.class })
	  public ResponseEntity handleInvalidImnputException(InvalidInputException ex) {
		  Map<String, Object> response = new HashMap<>();
		  response.put("messgee","user id is not exist");
		  response.put("ErrorCode",HttpStatus.BAD_REQUEST);
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		
		 ex.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		 });
		 return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	  public ResponseEntity<Object> ResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		  response.put("Message",  ex.getMessage());
		  response.put("ErrorCode",HttpStatus.NOT_FOUND);
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	
		 
	  
	    }



}
