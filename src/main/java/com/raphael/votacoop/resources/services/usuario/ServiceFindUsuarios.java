package com.raphael.votacoop.resources.services.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.resources.exceptions.ObjectNotFoundException;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;

@Service
public class ServiceFindUsuarios {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getSimpleName()));
	}
	
	public Usuario findByCpf(String cpf) {
		
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		
		if (usuario != null) {
			return usuario;
		}
		
		return null;
	}
	
	public Usuario findByEmail(String email) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if (usuario != null) {
			return usuario;
		}
		
		return null;
	}
	
}
