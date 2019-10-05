package com.example.demo.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 3539325036007078890L;
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
