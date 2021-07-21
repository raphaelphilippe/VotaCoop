package com.raphael.votacoop.resources.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.resources.exceptions.DataIntegrityException;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;

@Service
public class ServiceDeleteUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ServiceFindByIdUsuario serviceFindByIdUsuario;
	
	public void delete(Integer id) {
		serviceFindByIdUsuario.find(id);
		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possível remover um usuário que contenha votos salvos.");
		}
	}

	
}
