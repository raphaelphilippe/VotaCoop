package com.raphael.votacoop.resources.services.voto;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.clients.CpfClient;
import com.raphael.votacoop.clients.responses.CpfResponse;
import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.domain.enums.CpfValidationOptions;
import com.raphael.votacoop.domain.enums.StatusSessao;
import com.raphael.votacoop.dtos.SessaoVotacaoDTO;
import com.raphael.votacoop.dtos.VotoDTO;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.VotoRepository;
import com.raphael.votacoop.resources.services.sessao.ServiceFindSessaoVotacao;
import com.raphael.votacoop.resources.services.usuario.ServiceFindUsuarios;


@Service
public class ServiceCreateVoto {

	private VotoDTO votoDTO;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private ServiceFindVotos serviceFindVotos;
	
	@Autowired
	private ServiceFindSessaoVotacao serviceFindSessaVotacao;
	
	@Autowired
	private ServiceFindUsuarios serviceFindUsuarios;
	
	@Autowired
	private CpfClient cpfClient;
	
	
	public Voto create(VotoDTO votoDTO){
		
		this.votoDTO = votoDTO;
		
		if(checkCanVote()) {
			return votoRepository.save(votoFromVotoDTO());
		} else {
			return null;
		}
	}
	
	private Voto votoFromVotoDTO() {
		
		Voto voto = new Voto(
				null, 
				votoDTO.getVoto(), 
				LocalDateTime.now(), 
				serviceFindSessaVotacao.findById(votoDTO.getIdSessaoVotacao()), 
				serviceFindUsuarios.findById(votoDTO.getIdUsuario())
		);
		
		return voto;
		
	}
	
	
	private boolean checkCanVote() {
		
		checkValidCPF();
		checkAlreadyVoted();
		checkSessionIsOpen();
		
		return true;
	}
	
	
	private boolean checkValidCPF(){
		
		Usuario usuario = serviceFindUsuarios.findById(this.votoDTO.getIdUsuario());
		
		CpfResponse cpfResponse = cpfClient.getCpf(usuario.getCpf());
		
		if(cpfResponse.getStatus().equals(CpfValidationOptions.ABLE_TO_VOTE)) {
			return true;
		} else {
			throw new ValidationsException("Voto não Enviado! O CPF do usuário não está habilitado à votar.");
		}
	}
	
	
	private boolean checkAlreadyVoted() {
		
		Optional<Voto> computedVote = Optional.ofNullable(
				serviceFindVotos.findBySessaoVotacaoIdAndUsuarioId(this.votoDTO.getIdSessaoVotacao(), this.votoDTO.getIdUsuario())
		);
		
		if(computedVote.isPresent()) {
			throw new ValidationsException(
					"Voto não Enviado! Já existe um voto computado do usuário ID: " + this.votoDTO.getIdUsuario() + " para a Sessão ID: " + this.votoDTO.getIdSessaoVotacao());
		} else {
			return true;
		}
	}
	
	
	private boolean checkSessionIsOpen() {
		
		SessaoVotacaoDTO sessaoVotacaoDTO = serviceFindSessaVotacao.findByDTO(this.votoDTO.getIdSessaoVotacao());
		
		if(sessaoVotacaoDTO.getStatusSessao().equals(StatusSessao.VOTACAO_ABERTA)) {
			return true;
		} else {
			throw new ValidationsException("Voto não Enviado! A Sessão de Votação ID: " + this.votoDTO.getIdSessaoVotacao() + " está encerrada.");
		}
	}
}
