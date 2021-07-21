package com.raphael.votacoop.resources.services.pauta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceFindAllPautas {

	@Autowired
	private PautaRepository pautaRepository;
	
	public List<Pauta> findAll(){
		return pautaRepository.findAll();
	}
	
}
