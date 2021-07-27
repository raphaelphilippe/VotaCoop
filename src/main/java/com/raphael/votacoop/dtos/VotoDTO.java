package com.raphael.votacoop.dtos;

import java.io.Serializable;

import com.raphael.votacoop.domain.enums.OpcoesVotacao;

public class VotoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private OpcoesVotacao voto;
	private Integer idSessaoVotacao;
	private Integer idUsuario;
	
	public VotoDTO() {
		
	}

	public VotoDTO(OpcoesVotacao voto, Integer idSessaoVotacao, Integer idUsuario) {
		super();
		this.voto = voto;
		this.idSessaoVotacao = idSessaoVotacao;
		this.idUsuario = idUsuario;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public OpcoesVotacao getVoto() {
		return voto;
	}

	public void setVoto(OpcoesVotacao voto) {
		this.voto = voto;
	}

	public Integer getIdSessaoVotacao() {
		return idSessaoVotacao;
	}

	public void setIdSessaoVotacao(Integer idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
	
	
}
