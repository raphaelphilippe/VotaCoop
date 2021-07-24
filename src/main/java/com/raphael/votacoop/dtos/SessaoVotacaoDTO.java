package com.raphael.votacoop.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.domain.enums.StatusSessao;

public class SessaoVotacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private LocalDateTime dataHoraInicioSessao;
	private String tempoPrazo;
	private Pauta pauta;
	
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

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

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

	@Override
	public String toString() {
		return "SessaoVotacaoDTO [id=" + id + ", pauta=" + pauta + ", dataHoraInicioSessao=" + dataHoraInicioSessao
				+ ", tempoPrazo=" + tempoPrazo + ", statusSessao=" + statusSessao + ", qtdSim=" + qtdSim + ", qtdNao="
				+ qtdNao + "]";
	}
	
	
}
