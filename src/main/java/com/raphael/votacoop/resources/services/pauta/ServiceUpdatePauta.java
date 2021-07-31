package com.raphael.votacoop.resources.services.pauta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.enums.StatusPauta;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceUpdatePauta {

	@Autowired
	private ServiceFindPautas serviceFindPautas;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	
	public Pauta update(Pauta pautaUpdated) {
		
		Pauta pautaSaved = serviceFindPautas.findById(pautaUpdated.getId());
		
		if(pautaSaved.getStatusPauta().equals(StatusPauta.ABERTA)) {
			
			updateAtributtes(pautaSaved, pautaUpdated);
			return pautaRepository.save(pautaSaved);
			
		} else {
		
			throw new ValidationsException("A Pauta ID: " + pautaSaved.getId() + "está concluída e não pode ser alterada.");
		}
	}
	
	
	private void updateAtributtes(Pauta pautaSaved, Pauta pautaUpdated) {
		pautaSaved.setDescricao(pautaUpdated.getDescricao());
	}

}
