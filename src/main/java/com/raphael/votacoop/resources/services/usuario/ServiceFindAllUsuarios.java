package com.raphael.votacoop.resources.services.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;

@Service
public class ServiceFindAllUsuarios {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
}
