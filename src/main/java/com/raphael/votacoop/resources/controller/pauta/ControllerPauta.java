package com.raphael.votacoop.resources.controller.pauta;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.resources.services.pauta.ServiceCreatePauta;
import com.raphael.votacoop.resources.services.pauta.ServiceDeletePauta;
import com.raphael.votacoop.resources.services.pauta.ServiceFindAllPautas;
import com.raphael.votacoop.resources.services.pauta.ServiceFindByIdPauta;

@RestController
@RequestMapping(value="/pautas")
public class ControllerPauta {

	@Autowired
	private ServiceFindAllPautas serviceFindAllPautas;
	
	@Autowired
	private ServiceCreatePauta serviceCreatePauta;
	
	@Autowired
	private ServiceFindByIdPauta serviceFindByIdPauta;
	
	@Autowired
	private ServiceDeletePauta serviceDeletePauta;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pauta>> findAll(){
		List<Pauta> list = serviceFindAllPautas.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pauta> find(@PathVariable Integer id){
		Pauta obj = serviceFindByIdPauta.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Pauta obj){
		obj = serviceCreatePauta.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		serviceDeletePauta.delete(id);
		return ResponseEntity.noContent().build();
	}
}
