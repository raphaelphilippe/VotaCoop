package com.raphael.votacoop.resources.services.sessao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.SessaoVotacaoRepository;
import com.raphael.votacoop.resources.services.pauta.ServiceFindPautas;

@Service
public class ServiceCreateSessaoVotacao {
	
	final String prazoPadraoSessao = "01:00";
	
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private ServiceFindPautas serviceFindPautas;
	
	
	public SessaoVotacao create(Integer idPauta, String prazoSessao){
		
		if(checkFormatPrazoSessao(prazoSessao)) {
			
			SessaoVotacao sessaoVotacao = new SessaoVotacao(
					null, 
					LocalDateTime.now(), 
					(prazoSessao == null ? prazoPadraoSessao : prazoSessao), 
					serviceFindPautas.findById(idPauta)
					);
			
			return sessaoVotacaoRepository.save(sessaoVotacao);
			
		} else {
			return null;
		}
		
	}
	
	private boolean checkFormatPrazoSessao(String prazoSessao) {
		
		if(prazoSessao.length() != 5) {
			throw new ValidationsException("O prazo da Sessão de Votação precisa conter 5 caracteres no seguinte formato: HH:mm.");
		}
		
		if(! prazoSessao.contains(":")) {
			throw new ValidationsException("O prazo da Sessão de Votação precisa conter o sinal de dois pontos entre as horas e os minutos no seguinte formato: HH:mm.");
		}
		
		String[] listPrazoSessao = prazoSessao.split(":");
		if(! listPrazoSessao[0].matches("[0-9]*")) {
			throw new ValidationsException("No prazo da Sessão de Votação as horas precisam conter um valor numérico entre 0 e 9 no seguinte formato: HH:mm.");
		}
		
		if( (! listPrazoSessao[1].matches("[0-9]*") ) | (Integer.parseInt(listPrazoSessao[1]) > 60 && Integer.parseInt(listPrazoSessao[1]) < 00)) {
			throw new ValidationsException("No prazo da Sessão de Votação minutos precisam conter até dois algarismos entre 0 e 9 e ser um número entre 00 e 59 no seguinte formato HH:mm.");
		}
		
		return true;
	}
}

