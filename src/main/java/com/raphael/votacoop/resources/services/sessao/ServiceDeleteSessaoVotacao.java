package com.raphael.votacoop.resources.services.sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.dtos.UsuarioDTO;
import com.raphael.votacoop.resources.exceptions.DataIntegrityException;
import com.raphael.votacoop.resources.repositories.SessaoVotacaoRepository;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;
import com.raphael.votacoop.resources.services.usuario.ServiceFindUsuarios;

@Service
public class ServiceDeleteSessaoVotacao {
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private ServiceFindSessaoVotacao serviceSessaoVotacao;
	
	public void delete(Integer id) {
		serviceSessaoVotacao.findById(id);
		try {
			sessaoVotacaoRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possível remover um usuário que contenha votos salvos.");
		}
	}
}
