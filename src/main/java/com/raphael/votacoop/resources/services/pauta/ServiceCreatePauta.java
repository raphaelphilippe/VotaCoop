package com.raphael.votacoop.resources.services.pauta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceCreatePauta {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	public Pauta create(Pauta obj){
		obj.setId(null);
		validaCriacaoPauta(obj);
		return pautaRepository.save(obj);
	}
	
	private void validaCriacaoPauta(Pauta obj) {
		if(obj.getDescricao() == null | obj.getDescricao().equals("")) {
			throw new ValidationsException("A descrição da Pauta precisa ser informada.");
		}
	}
	
}
