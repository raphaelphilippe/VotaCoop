package com.raphael.votacoop.resources.services.voto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.VotoRepository;

@Service
public class ServiceFindVotos {

	@Autowired
	private VotoRepository votoRepository;
	
	public List<Voto> findAllVotos(){
		return votoRepository.findAll();
	}
	
	public List<Voto> findAllVotosByIdSessaoVotacao(Integer idSessaoVotacao){
		return votoRepository.findAll();
	}
	
	public List<Voto> findAllVotosByIdUsuario(Integer isUsuario){
		return votoRepository.findAll();
	}
	
	//AINDA NÃO ESTÁ DEFINIDO SE ESSE MÉTODO SERÁ NECESSÁRIO
	public Voto findVotoById(Integer id) {
		Optional<Voto> obj = votoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Voto não encontrado! ID: " + id + ", Tipo: " + Voto.class.getSimpleName()));
		
	}
	
	public Voto findVotoByIdSessaoAndIdUsuario(Integer idSessaoVotacao, Integer idUsuario) {
		Optional<Voto> obj = votoRepository.findById(idSessaoVotacao);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Voto não encontrado! ID: " + idSessaoVotacao + ", Tipo: " + Voto.class.getSimpleName()));
		
	}
}
