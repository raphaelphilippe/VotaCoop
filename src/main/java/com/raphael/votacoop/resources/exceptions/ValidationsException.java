package com.raphael.votacoop.resources.exceptions;

public class ValidationsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ValidationsException(String msg) {
		super(msg);
	}
	
	public ValidationsException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
