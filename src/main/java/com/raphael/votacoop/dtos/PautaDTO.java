package com.raphael.votacoop.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.raphael.votacoop.domain.Pauta;

public class PautaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Length(min=15, max=140, message="O campo Descrição deve ter entre 15 e 140 caracteres.")
	private String descricao;
	
	public PautaDTO() {
		
	}	
	
	public PautaDTO(Pauta obj) {
		this.descricao = obj.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
