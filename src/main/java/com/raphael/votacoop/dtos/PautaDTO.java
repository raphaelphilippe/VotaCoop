package com.raphael.votacoop.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.enums.ResultadoVotacao;
import com.raphael.votacoop.domain.enums.StatusPauta;

public class PautaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty
	@Length(min=15, max=140, message="O campo Descrição deve ter entre 15 e 140 caracteres.")
	private String descricao;
	
	private StatusPauta statusPauta;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacaoPauta; 
	
	@JsonProperty("sessaoVotacao")
	private SessaoVotacaoDTO sessaoVotacaoDTO;
	
	private ResultadoVotacao resultadoVotacao;
	
	
	public PautaDTO() {
		
	}	
	
	public PautaDTO(Pauta pauta) {
		this.id = pauta.getId();
		this.descricao = pauta.getDescricao();
		this.statusPauta = pauta.getStatusPauta();
		this.dataCriacaoPauta = pauta.getDataCriacaoPauta();
	}
	
	public PautaDTO(String descricao) {
		this.descricao = descricao;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPauta getStatusPauta() {
		return statusPauta;
	}

	public void setStatusPauta(StatusPauta statusPauta) {
		this.statusPauta = statusPauta;
	}

	public LocalDateTime getDataCriacaoPauta() {
		return dataCriacaoPauta;
	}

	public void setDataCriacaoPauta(LocalDateTime dataCriacaoPauta) {
		this.dataCriacaoPauta = dataCriacaoPauta;
	}

	public SessaoVotacaoDTO getSessaoVotacaoDTO() {
		return sessaoVotacaoDTO;
	}

	public void setSessaoVotacaoDTO(SessaoVotacaoDTO sessaoVotacao) {
		this.sessaoVotacaoDTO = sessaoVotacao;
	}

	public ResultadoVotacao getResultadoVotacao() {
		return resultadoVotacao;
	}

	public void setResultadoVotacao(ResultadoVotacao resultadoVotacao) {
		this.resultadoVotacao = resultadoVotacao;
	}
}
