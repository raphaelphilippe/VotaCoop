package com.raphael.votacoop.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.raphael.votacoop.domain.enums.StatusPauta;

@Entity
public class Pauta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	private Integer statusPauta;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacaoPauta; 
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "pauta")
	private SessaoVotacao sessaoVotacao;

	public Pauta() {
		
	}

	public Pauta(Integer id, String descricao, StatusPauta statusPauta, LocalDateTime dataCriacaoPauta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.statusPauta = statusPauta.getCod();
		this.dataCriacaoPauta = dataCriacaoPauta;
	}
	
	public Pauta(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public StatusPauta getStatusPauta() {
		return StatusPauta.toEnum(this.statusPauta);
	}

	public LocalDateTime getDataCriacaoPauta() {
		return dataCriacaoPauta;
	}

	public void setDataCriacaoPauta(LocalDateTime dataCriacaoPauta) {
		this.dataCriacaoPauta = dataCriacaoPauta;
	}

	public SessaoVotacao getSessaoVotacao() {
		return sessaoVotacao;
	}

	public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
		this.sessaoVotacao = sessaoVotacao;
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
		Pauta other = (Pauta) obj;
		return Objects.equals(id, other.id);
	}

//	@Override
//	public String toString() {
//		return "Pauta [id=" + id + ", descricao=" + descricao + ", statusPauta=" + statusPauta + ", dataCriacaoPauta="
//				+ dataCriacaoPauta + ", sessao=" + sessao + "]";
//	}
	
	

}


