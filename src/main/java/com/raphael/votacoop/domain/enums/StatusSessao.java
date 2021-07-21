package com.raphael.votacoop.domain.enums;

public enum StatusSessao {

	EM_VOTACAO(1, "Em Votação"),
	VOTADA(2, "Votada");
	
	private int cod;
	private String descricao;
	
	private StatusSessao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusSessao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(StatusSessao x : StatusSessao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
