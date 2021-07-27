package com.raphael.votacoop.resources.services.sessao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.domain.enums.OpcoesVotacao;
import com.raphael.votacoop.domain.enums.StatusSessao;
import com.raphael.votacoop.dtos.SessaoVotacaoDTO;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.SessaoVotacaoRepository;
import com.raphael.votacoop.resources.services.voto.ServiceFindVotos;

@Service
public class ServiceFindSessaoVotacao {
	
	SessaoVotacaoDTO sessaoVotacaoDTO;
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private ServiceFindVotos serviceFindVotos;
	
	
	public List<SessaoVotacaoDTO> findAllDTO(){
		
		List<SessaoVotacao> listSessaoVotacao = new ArrayList<>(); 
		listSessaoVotacao = sessaoVotacaoRepository.findAll();
		
		//List<SessaoVotacaoDTO> listSessaoVotacaoDTO = listSessaoVotacao.stream().map(sessaoVotacaoDTO -> new SessaoVotacaoDTO(sessaoVotacaoDTO)).collect(Collectors.toList());
		List<SessaoVotacaoDTO> listSessaoVotacaoDTO = new ArrayList<>();
		
		for(SessaoVotacao sessaoVotacao : listSessaoVotacao) {
			listSessaoVotacaoDTO.add(sessaoDTOfromEntity(sessaoVotacao));
		}
		
		return listSessaoVotacaoDTO;
	}
	
	public SessaoVotacao findById(Integer id) {
		
		Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoRepository.findById(id);
		return sessaoVotacao.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + SessaoVotacao.class.getSimpleName()));
			
	}
	
	public SessaoVotacaoDTO findByDTO(Integer id) {
		
		SessaoVotacao sessaoVotacao = findById(id);
		return sessaoDTOfromEntity(sessaoVotacao);
		
	}
	
	public SessaoVotacaoDTO sessaoDTOfromEntity(SessaoVotacao sessaoVotacao) {
		
		this.sessaoVotacaoDTO = new SessaoVotacaoDTO(sessaoVotacao);
		processaResultadoSessao();
		return sessaoVotacaoDTO;
	}
	
	private void processaResultadoSessao() {
		
		String[] listPrazoSessao = this.sessaoVotacaoDTO.getTempoPrazo().split(":");
		
		LocalDateTime dataHoraFinalSessao = this.sessaoVotacaoDTO.getDataHoraInicioSessao()
				.plusHours(Integer.parseInt(listPrazoSessao[0]))
				.plusMinutes(Integer.parseInt(listPrazoSessao[1]));
		
		this.sessaoVotacaoDTO.setDataHoraFinalSessao(dataHoraFinalSessao);
		
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		if(dataHoraAtual.isBefore(dataHoraFinalSessao)) {
			this.sessaoVotacaoDTO.setStatusSessao(StatusSessao.VOTACAO_ABERTA);
		} else {
			this.sessaoVotacaoDTO.setStatusSessao(StatusSessao.VOTACAO_FINALIZADA);
			setVotosSessaoDTO();
		}
	}
	
	private void setVotosSessaoDTO() {
		
		List<Voto> listVoto = serviceFindVotos.findAllBySessaoVotacaoId(this.sessaoVotacaoDTO.getId());
		
		this.sessaoVotacaoDTO.setQtdSim(listVoto.stream().filter(voto -> voto.getVoto() == OpcoesVotacao.SIM).count());
		this.sessaoVotacaoDTO.setQtdNao(listVoto.stream().filter(voto -> voto.getVoto() == OpcoesVotacao.NAO).count());
	}
	
}
