package com.learn.api.basic.handlers;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.api.basic.models.ErrorMessage;

@ControllerAdvice
public class ApiExceptionHandler  {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handlePSQLException(DataIntegrityViolationException ex) {
		
		String message = ex.getCause().getCause().getMessage();
		ErrorMessage error = new ErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value(), message);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex) {
		
		String message = ex.getMessage();
		ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), message);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
