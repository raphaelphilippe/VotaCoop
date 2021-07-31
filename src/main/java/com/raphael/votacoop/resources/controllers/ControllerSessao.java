package com.raphael.votacoop.resources.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.dtos.SessaoVotacaoDTO;
import com.raphael.votacoop.resources.services.sessao.ServiceCreateSessaoVotacao;
import com.raphael.votacoop.resources.services.sessao.ServiceDeleteSessaoVotacao;
import com.raphael.votacoop.resources.services.sessao.ServiceFindSessaoVotacao;

@RestController
@RequestMapping(value="/sessao")
public class ControllerSessao {

	@Autowired
	private ServiceFindSessaoVotacao serviceFindSessaoVotacao;
	
	@Autowired
	private ServiceCreateSessaoVotacao serviceCreateSessaoVotacao;
	
	@Autowired
	private ServiceDeleteSessaoVotacao serviceDeleteSessaoVotacao;
		
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SessaoVotacaoDTO>> findAll(){
		List<SessaoVotacaoDTO> listSessaoVotacaoDTO = serviceFindSessaoVotacao.findAllDTO();
		return ResponseEntity.ok().body(listSessaoVotacaoDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SessaoVotacaoDTO> findById(@PathVariable Integer id){
		SessaoVotacaoDTO sessaoVotacaoDTO = serviceFindSessaoVotacao.findByDTO(id);
		return ResponseEntity.ok().body(sessaoVotacaoDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestParam(required = true) Integer idPauta, String prazoSessao){
		SessaoVotacao sessaoVotacao = serviceCreateSessaoVotacao.create(idPauta, prazoSessao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sessaoVotacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		serviceDeleteSessaoVotacao.delete(id);
		return ResponseEntity.noContent().build();
	}
}
