package com.raphael.votacoop.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String voto;
	private LocalDateTime dataHoraVoto;
	
	@ManyToOne
	@JoinColumn(name="id_Sessao")
	private SessaoVotacao sessaoVotacao;
	
	@ManyToOne
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	
	public Voto() {
		
	}

	public Voto(Integer id, String voto, LocalDateTime dataHoraVoto, SessaoVotacao sessaoVotacao, Usuario usuario) {
		super();
		this.id = id;
		this.voto = voto;
		this.dataHoraVoto = dataHoraVoto;
		this.sessaoVotacao = sessaoVotacao;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public LocalDateTime getDataHoraVoto() {
		return dataHoraVoto;
	}

	public void setDataHoraVoto(LocalDateTime dataHoraVoto) {
		this.dataHoraVoto = dataHoraVoto;
	}

	public SessaoVotacao getSessaoVotacao() {
		return sessaoVotacao;
	}

	public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
		this.sessaoVotacao = sessaoVotacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Voto other = (Voto) obj;
		return Objects.equals(id, other.id);
	}
}
