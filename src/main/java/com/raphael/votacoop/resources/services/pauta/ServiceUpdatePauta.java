package com.raphael.votacoop.resources.services.pauta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceUpdatePauta {

	@Autowired
	private ServiceFindPautas serviceFindPautas;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	
	public Pauta update(Pauta objUpdated) {
		Pauta objSavedDb = serviceFindPautas.findById(objUpdated.getId());
		updateAtributtes(objSavedDb, objUpdated);
		return pautaRepository.save(objSavedDb);
	}
	
	private void updateAtributtes(Pauta objSavedDb, Pauta objUpdated) {
		objSavedDb.setDescricao(objUpdated.getDescricao());
	}
	
}
