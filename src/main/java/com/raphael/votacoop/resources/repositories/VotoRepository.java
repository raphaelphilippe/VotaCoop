package com.raphael.votacoop.resources.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raphael.votacoop.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer>{

	List<Voto> findAllBySessaoVotacaoId(Integer id_sessao);
	List<Voto> findAllByUsuarioId(Integer id_usuario);
	Voto findBySessaoVotacaoIdAndUsuarioId(Integer id_sessao, Integer id_usuario);
	
}