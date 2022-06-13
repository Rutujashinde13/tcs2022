package com.expection;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import feign.FeignException;


@RestControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request){
		LOGGER.error("handles by");
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionDetails> handleFeignStatusException(FeignException ex, HttpServletResponse response) {
		LOGGER.error("handles by handleFeignStatusException");
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(PensionerDetailException.class)
	public ResponseEntity<ExceptionDetails> handleSpecialistDetailNotFoundException(PensionerDetailException p){
		
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), p.getMessage());
		LOGGER.error(p.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AadharNumberNotFound.class)
	public ResponseEntity<ExceptionDetails> handleMissingRequestHeaderException(AadharNumberNotFound ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ExceptionDetails> handleMissingRequestHeaderException(MissingRequestHeaderException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}

}