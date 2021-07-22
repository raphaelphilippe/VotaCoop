package com.raphael.votacoop.resources.services.pauta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceFindPautas {

	@Autowired
	private PautaRepository pautaRepository;
	
	public List<Pauta> findAll(){
		return pautaRepository.findAll();
	}
	
	public Pauta findById(Integer id) {
		Optional<Pauta> obj = pautaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pauta não encontrada! ID: " + id + ", Tipo: " + Pauta.class.getSimpleName()));

	}
	
}
