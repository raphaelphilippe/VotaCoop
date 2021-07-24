package com.raphael.votacoop.resources.services.voto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.resources.repositories.VotoRepository;

@Service
public class ServiceUpdateVoto {

	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private ServiceFindVotos serviceFindVotos;
	
	
	public Voto update(Voto newVoto) {
		Voto votoSaved = serviceFindVotos.findVotoByIdSessaoAndIdUsuario(newVoto.getSessaoVotacao().getId(), newVoto.getUsuario().getId());
		votoSaved.setVoto(newVoto.getVoto());
		votoSaved.setDataHoraVoto(newVoto.getDataHoraVoto());
		return votoRepository.save(votoSaved);
	}
}
