package com.dealszone.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dealszone.exception.CategoryNotFoundException;
import com.dealszone.exception.*;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
	Logger logger= LoggerFactory.getLogger(ValidationHandler.class);
	
	//validation handler for handling error message when validation fails
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
			Map<String,String> errors= new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName = ((FieldError)error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
			
		});
			
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	//handles exception if product not found
	@ExceptionHandler(value=DealNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(DealNotFoundException dealNotFoundException) {
		logger.error("Product not found ");
		return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);
		
	}
	//handles exception if product already found
	@ExceptionHandler(value=DealAlreadyExistsException.class)
	public ResponseEntity<String> productAlreadyExistsException(DealAlreadyExistsException dealAlreadyExistsException) {
		
		logger.error("Product  Already found ");
		return new ResponseEntity<>("product Already Exists",HttpStatus.CONFLICT);
		
	}
	//handles exception if category not found
	
	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity<String> categoryNotFoundException(CategoryNotFoundException categoryNotFoundException) {
		
		logger.error("Category not found ");
		return new ResponseEntity<>("category not found",HttpStatus.NOT_FOUND);
		
	}
	//handles exception if product type not found
	@ExceptionHandler(value=DealTypeNotExistsException.class)
	public ResponseEntity<String> productTypeNotExistsException(CategoryNotFoundException categoryNotFoundException) {
		
		logger.error("Product type not found ");
		return new ResponseEntity<>("product type does not exists",HttpStatus.NOT_FOUND);
		
	}
}
