package com.raphael.votacoop.resources.services.sessao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.resources.repositories.SessaoVotacaoRepository;
import com.raphael.votacoop.resources.services.pauta.ServiceFindPautas;

@Service
public class ServiceCreateSessaoVotacao {
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private ServiceFindPautas serviceFindPautas;
	
	
	public SessaoVotacao create(Integer idPauta, String prazoSessao){
		
		SessaoVotacao sessaoVotacao = new SessaoVotacao(
				null, 
				LocalDateTime.now(), 
				prazoSessao, 
				serviceFindPautas.findById(idPauta)
		);
		
		return sessaoVotacaoRepository.save(sessaoVotacao);
	}	
}
