package com.raphael.votacoop.domain.enums;

public enum CpfValidationOptions {

	ABLE_TO_VOTE(1, "Habilitado para Votar"),
	UNABLE_TO_VOTE(0, "Não habilitado para votar");
	
	private int cod;
	private String descricao;
	
	private CpfValidationOptions(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static CpfValidationOptions toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(CpfValidationOptions x : CpfValidationOptions.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
