package com.raphael.votacoop.resources.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;

@Service
public class ServiceUpdateUsuario {

	@Autowired
	private ServiceFindByIdUsuario serviceUsuarioById;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario update(Usuario obj) {
		serviceUsuarioById.find(obj.getId());
		return usuarioRepository.save(obj);
	}
	
}
