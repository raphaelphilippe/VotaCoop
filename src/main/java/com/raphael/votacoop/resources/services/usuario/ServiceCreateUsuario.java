package com.raphael.votacoop.resources.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.dto.UsuarioDTO;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;

@Service
public class ServiceCreateUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario create(Usuario obj){
		obj.setId(null);
		return usuarioRepository.save(obj);
	}	
	
	
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(), objDTO.getEmail());
	}
}
