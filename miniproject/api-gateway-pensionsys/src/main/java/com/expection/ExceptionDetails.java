package com.expection;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ExceptionDetails {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	private String message;
	
	
	public ExceptionDetails(LocalDateTime timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}
}
