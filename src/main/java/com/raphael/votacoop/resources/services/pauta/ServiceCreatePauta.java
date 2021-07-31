package com.raphael.votacoop.resources.services.pauta;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.enums.StatusPauta;
import com.raphael.votacoop.dtos.PautaDTO;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.PautaRepository;

@Service
public class ServiceCreatePauta {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	public Pauta create(Pauta pauta){
		
		if(checkIfPautaAlreadyExists(pauta)) {
			return pautaRepository.save(pauta);
		}
		
		return null;
		
	}
	
	
	public Pauta fromDTOCreate(PautaDTO objDTO) {
		
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		return new Pauta(
				null,
				objDTO.getDescricao(),
				StatusPauta.ABERTA, 
				dataHoraAtual
		);
	}
	
	
	private boolean checkIfPautaAlreadyExists(Pauta pauta){
		
		Pauta pautaSaved = pautaRepository.findPautaByDescricao(pauta.getDescricao());
		
		if(pautaSaved != null) {
			throw new ValidationsException("Já existe uma Pauta com a mesma descrição. ID da Pauta: " + pautaSaved.getId());
		}
		
		return true;
		
	}
}
