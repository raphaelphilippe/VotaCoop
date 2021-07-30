package com.raphael.votacoop.clients.responses;


import com.raphael.votacoop.domain.enums.CpfValidationOptions;

public class CpfResponse {

	private CpfValidationOptions status;
	private String cause;
	
	public CpfResponse() {
		
	}

	public CpfResponse(CpfValidationOptions status) {
		super();
		this.status = status;
	}
	
	public CpfResponse(String cause) {
		super();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PASSOU POR AQUI");
		this.cause = cause;
	}

	public CpfValidationOptions getStatus() {
		return status;
	}

	public void setStatus(CpfValidationOptions status) {
		this.status = status;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
}
