package com.raphael.votacoop.resources.services.sessao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.domain.enums.StatusSessao;
import com.raphael.votacoop.dtos.SessaoVotacaoDTO;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.SessaoVotacaoRepository;

@Service
public class ServiceFindSessaoVotacao {
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	
	public List<SessaoVotacao> findAll(){
		return sessaoVotacaoRepository.findAll();
	}
	
	public SessaoVotacao findById(Integer id) {
		
		Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoRepository.findById(id);
		return sessaoVotacao.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getSimpleName()));
			
	}
	
	public SessaoVotacaoDTO findByDTO(Integer id) {
		
		SessaoVotacao sessaoVotacao = findById(id);
		return sessaoDTOfromEntity(sessaoVotacao);
		
	}
	
	private SessaoVotacaoDTO sessaoDTOfromEntity(SessaoVotacao sessaoVotacao) {
		
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO(sessaoVotacao);
		processaResultadoSessao(sessaoVotacaoDTO);
		return sessaoVotacaoDTO;
	}
	
	private void processaResultadoSessao(SessaoVotacaoDTO sessaoVotacaoDTO) {
		setStatusSessaoDTO(sessaoVotacaoDTO);
		if(sessaoVotacaoDTO.getStatusSessao() == StatusSessao.VOTACAO_FINALIZADA) {
			setVotosSessaoDTO(sessaoVotacaoDTO);			
		}
	}
	
	private void setStatusSessaoDTO(SessaoVotacaoDTO sessaoVotacaoDTO) {
		String[] listPrazoSessao = sessaoVotacaoDTO.getTempoPrazo().split(":");
		
		LocalDateTime dataHoraFinalSessao = sessaoVotacaoDTO.getDataHoraInicioSessao()
				.plusHours(Integer.parseInt(listPrazoSessao[0]))
				.plusMinutes(Integer.parseInt(listPrazoSessao[1]));
		
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		if(dataHoraAtual.isBefore(dataHoraFinalSessao)) {
			sessaoVotacaoDTO.setStatusSessao(StatusSessao.VOTACAO_ABERTA);
		} else {
			sessaoVotacaoDTO.setStatusSessao(StatusSessao.VOTACAO_FINALIZADA);
		}
	}
	
	private void setVotosSessaoDTO(SessaoVotacaoDTO sessaoVotacaoDTO) {
		sessaoVotacaoDTO.setQtdSim(10);
		sessaoVotacaoDTO.setQtdNao(8);
	}
	
}
