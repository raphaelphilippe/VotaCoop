package com.raphael.votacoop.resources.services.pauta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.resources.exceptions.DataIntegrityException;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceDeletePauta {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private ServiceFindPautas serviceFindPautas;
	
	public void delete(Integer id) {
		serviceFindPautas.findById(id);
		try {
			pautaRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possível remover uma Pauta com uma Sessão Relacionada.");
		}
	}
}
