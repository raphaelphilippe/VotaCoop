package com.raphael.votacoop.resources.services.voto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.resources.repositories.VotoRepository;

@Service
public class ServiceCreateVoto {

	@Autowired
	private VotoRepository votoRepository;
	
	public Voto create(Voto voto){
		//obj.setId(null);
		return votoRepository.save(voto);
	}
	
}
