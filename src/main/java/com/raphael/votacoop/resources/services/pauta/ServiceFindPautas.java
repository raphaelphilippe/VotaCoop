package com.raphael.votacoop.resources.services.pauta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.enums.ResultadoVotacao;
import com.raphael.votacoop.domain.enums.StatusPauta;
import com.raphael.votacoop.domain.enums.StatusSessao;
import com.raphael.votacoop.dtos.PautaDTO;
import com.raphael.votacoop.dtos.SessaoVotacaoDTO;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.PautaRepository;
import com.raphael.votacoop.resources.services.sessao.ServiceFindSessaoVotacao;

@Service
public class ServiceFindPautas {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private ServiceFindSessaoVotacao serveFindSessaoVotacao;
	
	public List<Pauta> findAll(){
		return pautaRepository.findAll();
	}
	
	public Pauta findById(Integer id) {
		Optional<Pauta> obj = pautaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pauta não encontrada! ID: " + id + ", Tipo: " + Pauta.class.getSimpleName()));

	}
	
	public PautaDTO findByIdDTO(Integer id) {
		PautaDTO pautaDTO = new PautaDTO(findById(id));
		
		try {
			pautaDTO.setSessaoVotacaoDTO(serveFindSessaoVotacao.findByDTO(id));
			processaStatusPauta(pautaDTO);
			
		} catch (ObjectNotFoundException e) {
			pautaDTO.setSessaoVotacaoDTO(null);
		}
		
		return pautaDTO;
	}
	
	private void processaStatusPauta(PautaDTO pautaDTO) {
		
		if(pautaDTO.getSessaoVotacaoDTO().getStatusSessao().equals(StatusSessao.VOTACAO_ABERTA)) {
			pautaDTO.setStatusPauta(StatusPauta.ABERTA);
		} else {
			pautaDTO.setStatusPauta(StatusPauta.CONCLUÍDA);
			pautaDTO.setResultadoVotacao(processaResultadoVotacao(pautaDTO.getSessaoVotacaoDTO()));
		}
	}
	
	private ResultadoVotacao processaResultadoVotacao(SessaoVotacaoDTO sessaoVotacaoDTO) {
		
		if(sessaoVotacaoDTO.getQtdSim() == sessaoVotacaoDTO.getQtdNao()) {
			return ResultadoVotacao.EMPATE;
		} else if (sessaoVotacaoDTO.getQtdSim() > sessaoVotacaoDTO.getQtdNao()){
			return ResultadoVotacao.SIM;
		} else {
			return ResultadoVotacao.NAO;
		}
	}
}
