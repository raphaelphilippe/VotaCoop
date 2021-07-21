package com.raphael.votacoop.resources.services.pauta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceFindByIdPauta {

	@Autowired
	private PautaRepository pautaRepository;
	
	public Pauta find(Integer id) {
		Optional<Pauta> obj = pautaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pauta não encontrada! ID: " + id + ", Tipo: " + Pauta.class.getSimpleName()));

	}
	
}
