package com.raphael.votacoop.resources.exceptions;

public class FeignException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FeignException(String msg) {
		super(msg);
	}
	
	public FeignException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
