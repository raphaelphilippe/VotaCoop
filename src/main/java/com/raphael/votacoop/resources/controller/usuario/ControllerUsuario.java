package com.raphael.votacoop.resources.controller.usuario;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.dto.UsuarioDTO;
import com.raphael.votacoop.resources.services.usuario.ServiceCreateUsuario;
import com.raphael.votacoop.resources.services.usuario.ServiceDeleteUsuario;
import com.raphael.votacoop.resources.services.usuario.ServiceFindAllUsuarios;
import com.raphael.votacoop.resources.services.usuario.ServiceFindByIdUsuario;
import com.raphael.votacoop.resources.services.usuario.ServiceUpdateUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class ControllerUsuario {
	
	@Autowired
	private ServiceFindAllUsuarios serviceFindAllUsuarios;
	
	@Autowired
	private ServiceCreateUsuario serviceCreateUsuario;
	
	@Autowired
	private ServiceFindByIdUsuario serviceFindByIdUsuario;
	
	@Autowired
	private ServiceDeleteUsuario serviceDeleteUsuario;
	
	@Autowired
	private ServiceUpdateUsuario serviceUpdateUsuario;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> list = serviceFindAllUsuarios.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id){
		Usuario obj = serviceFindByIdUsuario.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO objDTO){
		Usuario obj = serviceCreateUsuario.fromDTO(objDTO);
		obj = serviceCreateUsuario.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDTO, @PathVariable Integer id){
		Usuario obj = serviceCreateUsuario.fromDTO(objDTO);
		obj.setId(id);
		obj = serviceUpdateUsuario.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		serviceDeleteUsuario.delete(id);
		return ResponseEntity.noContent().build();
	}
}
