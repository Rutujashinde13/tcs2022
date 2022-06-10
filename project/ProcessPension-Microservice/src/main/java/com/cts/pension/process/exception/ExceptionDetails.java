package com.cts.pension.process.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class ExceptionDetails {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String message;
	
	public ExceptionDetails(LocalDateTime timeStamp, HttpStatus status, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}
}
