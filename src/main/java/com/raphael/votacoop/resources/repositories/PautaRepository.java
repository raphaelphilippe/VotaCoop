package com.raphael.votacoop.resources.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raphael.votacoop.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>{

	Pauta findPautaByDescricao(String descricao);
	
}
