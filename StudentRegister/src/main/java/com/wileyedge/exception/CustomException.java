package com.wileyedge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException extends Exception{

	String message;
	int code;
	public CustomException(String message,int code) {
		this.message=message;
		this.code=code;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code=code;
	}
	
}
