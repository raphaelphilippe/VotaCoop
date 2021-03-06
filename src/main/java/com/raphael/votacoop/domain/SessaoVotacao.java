package com.raphael.votacoop.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.raphael.votacoop.domain.enums.StatusSessao;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SessaoVotacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraInicioSessao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private String tempoPrazo;
		
	//private Integer statusSessao;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pauta_id")
	@MapsId
	private Pauta pauta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sessaoVotacao")
	private List<Voto> votos = new ArrayList<>();

	public SessaoVotacao() {
		
	}

	public SessaoVotacao(Integer id, LocalDateTime dataHoraInicioSessao, String tempoPrazo, Pauta pauta) {
		super();
		this.id = id;
		this.dataHoraInicioSessao = dataHoraInicioSessao;
		this.tempoPrazo = tempoPrazo;
		//this.statusSessao = statusSessao.getCod();
		this.pauta = pauta;
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

	//public StatusSessao getStatusSessao() {
	//	return StatusSessao.toEnum(statusSessao);
	//}

	//public void setStatusSessao(Integer statusSessao) {
	//	this.statusSessao = statusSessao;
	//}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessaoVotacao other = (SessaoVotacao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "SessaoVotacao [id=" + id + ", dataHoraInicioSessao=" + dataHoraInicioSessao + ", tempoPrazo="
				+ tempoPrazo + ", pauta=" + pauta + ", votos=" + votos + "]";
	}
	
	
}
