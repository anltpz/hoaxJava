package com.hoaxify.ws.error;

import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class ApiError {
	private int status;
	private String message;
	private String path;
	private long timestamp = new Date().getTime();
	
	private Map<String ,String > validationErros;

	public ApiError(int status, String message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
		
	}
	
	
	
}
