package com.raphael.votacoop.resources.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.dtos.VotoDTO;
import com.raphael.votacoop.resources.services.voto.ServiceCreateVoto;
import com.raphael.votacoop.resources.services.voto.ServiceFindVotos;

@RestController
@RequestMapping(value="/votos")
public class ControllerVoto {

	@Autowired
	private ServiceFindVotos serviceFindVotos;
	
	@Autowired
	private ServiceCreateVoto serviceCreateVoto;

	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Voto>> findAll(){
		List<Voto> listVotos = serviceFindVotos.findAllVotos();
		return ResponseEntity.ok().body(listVotos);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Voto> findById(@PathVariable Integer id){
		Voto voto = serviceFindVotos.findById(id);
		return ResponseEntity.ok().body(voto);
	}
	
	@RequestMapping(value="/sessaousuario", method=RequestMethod.GET)
	public ResponseEntity<Voto> findAllBySessaoVotacaoIdAndUsuarioId(
			@RequestParam(required = true) Integer id_sessao, 
			@RequestParam(required = true) Integer id_usuario
	){
		Voto voto = serviceFindVotos.findBySessaoVotacaoIdAndUsuarioId(id_sessao, id_usuario);
		return ResponseEntity.ok().body(voto);
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.GET)
	public ResponseEntity<List<Voto>> findAllVotosByIdUsuario(
			@RequestParam(required = true) Integer id_usuario
	){
		List<Voto> listVotos = serviceFindVotos.findAllByUsuarioId(id_usuario);
		return ResponseEntity.ok().body(listVotos);
	}
	
	@RequestMapping(value="/sessao", method=RequestMethod.GET)
	public ResponseEntity<List<Voto>> findAllByIdSessao(
			@RequestParam(required = true) Integer id_sessao
	){
		List<Voto> listVotos = serviceFindVotos.findAllBySessaoVotacaoId(id_sessao);
		return ResponseEntity.ok().body(listVotos);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody VotoDTO votoDTO){
		serviceCreateVoto.create(votoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(votoDTO.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
