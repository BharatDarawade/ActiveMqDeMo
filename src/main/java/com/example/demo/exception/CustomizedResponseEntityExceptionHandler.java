package com.example.demo.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	   @ExceptionHandler(value = ProductNotFound.class)
		ResponseEntity<ErrorDetails> productNotFound(ProductNotFound ex, WebRequest request){
			
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
			        request.getDescription(false));
			    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			
		}

		//BadRequestException
		
		
	   @ExceptionHandler(value = BadRequestException.class)
		ResponseEntity<ErrorDetails> badRequest(ProductNotFound ex, WebRequest request){
			
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
			        request.getDescription(false));
			    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
			
		}
		
		
	
}
