package com.raphael.votacoop.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.domain.enums.StatusSessao;

public class SessaoVotacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//private Pauta pauta;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraInicioSessao;
	
	private String tempoPrazo;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraFinalSessao;
	private StatusSessao statusSessao;
	
	private Integer qtdSim;
	private Integer qtdNao;
	
	public SessaoVotacaoDTO() {
		
	}
	
	public SessaoVotacaoDTO(SessaoVotacao sessaoVotacao) {
		
		this.id = sessaoVotacao.getId();
		this.dataHoraInicioSessao = sessaoVotacao.getDataHoraInicioSessao();
		this.tempoPrazo = sessaoVotacao.getTempoPrazo();
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraInicioSessao() {
		return dataHoraInicioSessao;
	}

	public void setDataHoraInicioSessao(LocalDateTime dataHoraInicioSessao) {
		this.dataHoraInicioSessao = dataHoraInicioSessao;
	}

	public String getTempoPrazo() {
		return tempoPrazo;
	}

	public void setTempoPrazo(String tempoPrazo) {
		this.tempoPrazo = tempoPrazo;
	}
	
	public LocalDateTime getDataHoraFinalSessao() {
		return dataHoraFinalSessao;
	}

	public void setDataHoraFinalSessao(LocalDateTime dataHoraFinalSessao) {
		this.dataHoraFinalSessao = dataHoraFinalSessao;
	}

	//public Pauta getPauta() {
	//	return pauta;
	//}

	//public void setPauta(Pauta pauta) {
	//	this.pauta = pauta;
	//}

	public StatusSessao getStatusSessao() {
		return statusSessao;
	}

	public void setStatusSessao(StatusSessao statusSessao) {
		this.statusSessao = statusSessao;
	}

	public Integer getQtdSim() {
		return qtdSim;
	}

	public void setQtdSim(Integer qtdSim) {
		this.qtdSim = qtdSim;
	}

	public Integer getQtdNao() {
		return qtdNao;
	}

	public void setQtdNao(Integer qtdNao) {
		this.qtdNao = qtdNao;
	}
}
