package com.cts.authorization.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDetails {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private String message;
	
	
	


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timestamp = timeStamp;
	}

	

	public ExceptionDetails(LocalDateTime timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}



	public void setMessage(String message) {
		this.message = message;
		// TODO Auto-generated method stub
		
	}



	public Object getMessage() {
		// TODO Auto-generated method stub
		return getMessage();
	}



	public Object getTimestamp() {
		// TODO Auto-generated method stub
		return getTimestamp();
	}



	


	
}
