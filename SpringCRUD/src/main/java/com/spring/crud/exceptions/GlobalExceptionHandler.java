package com.spring.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ProductError> productNotFoundException(NotFoundException exp){
		ProductError productError = new ProductError();
		productError.setStatus((HttpStatus.NOT_FOUND.value()));
		productError.setMessage(exp.getMessage());
		
		return new ResponseEntity<>(productError,HttpStatus.NOT_FOUND);	
		}
	
	@ExceptionHandler
	public ResponseEntity<ProductError> generalException(Exception exp){
		ProductError productError = new ProductError();
		productError.setStatus((HttpStatus.BAD_REQUEST.value()));
		productError.setMessage(exp.getMessage());
		
		return new ResponseEntity<>(productError,HttpStatus.BAD_REQUEST);	
		}

}
