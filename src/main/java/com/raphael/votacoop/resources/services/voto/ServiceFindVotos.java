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
	
	public Voto findById(Integer id) {
		Optional<Voto> voto = votoRepository.findById(id);
		return voto.orElseThrow(() -> new ObjectNotFoundException("Pauta não encontrada! ID: " + id + ", Tipo: " + Voto.class.getSimpleName()));

	}
	
	public List<Voto> findAllBySessaoVotacaoId(Integer idSessaoVotacao) {
		return votoRepository.findAllBySessaoVotacaoId(idSessaoVotacao);
	}
	
	public Voto findBySessaoVotacaoIdAndUsuarioId(Integer id_sessao, Integer id_usuario) {
		return votoRepository.findBySessaoVotacaoIdAndUsuarioId(id_sessao, id_usuario);
	}
	
	public List<Voto> findAllByUsuarioId(Integer id_usuario) {
		return votoRepository.findAllByUsuarioId(id_usuario);
		
	}
	
	//AINDA NÃO ESTÁ DEFINIDO SE ESSE MÉTODO SERÁ NECESSÁRIO
	public Voto findVotoById(Integer id) {
		Optional<Voto> obj = votoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Voto não encontrado! ID: " + id + ", Tipo: " + Voto.class.getSimpleName()));
		
	}
}
