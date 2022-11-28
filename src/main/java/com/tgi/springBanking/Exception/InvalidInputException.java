package com.tgi.springBanking.Exception;

public class InvalidInputException extends RuntimeException {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidInputException(String message) {
		super();
	}
	
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

}
