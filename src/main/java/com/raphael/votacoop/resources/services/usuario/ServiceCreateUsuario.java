package com.raphael.votacoop.resources.services.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.dtos.UsuarioDTO;
import com.raphael.votacoop.resources.exceptions.ValidationsException;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

@Service
public class ServiceCreateUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ServiceFindUsuarios serviceFindUsuarios;
	
	
	public Usuario create(Usuario usuario){
		return usuarioRepository.save(usuario);
	}	
	
	
	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		
		checkAttributesUsuario(usuarioDTO);
		
		Usuario usuario = new Usuario(
				usuarioDTO.getId(),
				usuarioDTO.getNome(),
				usuarioDTO.getCpf(),
				usuarioDTO.getEmail()
		);
		
		return usuario = create(usuario);
		
	}
	
	private void checkAttributesUsuario(UsuarioDTO usuarioDTO){
		
		if(usuarioDTO.getNome() == null | usuarioDTO.getNome().equals("")) {
			throw new ValidationsException("O nome do usuário precisa ser informado.");
		}
		
		if(usuarioDTO.getNome().split(" ").length <= 1) {
			throw new ValidationsException("O 'Nome' deve possuir mais de uma palavra.");
		}
		
		if(usuarioDTO.getEmail() == null | usuarioDTO.getEmail().equals("")) {
			throw new ValidationsException("O Email do usuário precisa ser informado.");
		}
		
		if(!usuarioDTO.getEmail().contains("@")) {
			throw new ValidationsException("Um Email válido precisa ser informado.");
		}
		
		Usuario savedUsuario = serviceFindUsuarios.findByEmail(usuarioDTO.getEmail());
		if(savedUsuario != null) {
			throw new ValidationsException("Ja existe um usuário cadastrado com este Email.");
		}
		
		checkIfValidCPF(usuarioDTO.getCpf());
	}
	
	private void checkIfValidCPF(String CPF){
		
		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(CPF);
		
		if(erros.size() > 0){
			throw new ValidationsException("Um CPF válido precisa ser informado.");
		}
		
		Usuario savedUsuario = serviceFindUsuarios.findByCpf(CPF);
		if(savedUsuario != null) {
			throw new ValidationsException("Ja existe um usuário cadastrado com este CPF.");
		}
	}
}
