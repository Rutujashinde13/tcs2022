package com.pension.disbursement.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import feign.FeignException;


@RestControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionDetails> handleAuthorizationException(AuthorizationException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.FORBIDDEN, ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ExceptionDetails> handleMissingRequestHeaderException(MissingRequestHeaderException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AadharNumberNotFound.class)
	public ResponseEntity<ExceptionDetails> handleMissingRequestHeaderException(AadharNumberNotFound ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionDetails> handleFeignStatusException(FeignException ex, HttpServletResponse response) {
		LOGGER.error("handles by handleFeignStatusException");
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, ex.getMessage());
		LOGGER.error(ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
    }
}
