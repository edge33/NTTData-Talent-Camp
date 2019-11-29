package com.nttdata.SpringBootDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;

public interface CorsoRepository extends CrudRepository<CorsoDiLaureaEntity, Long> {
	
	CorsoDiLaureaEntity findByDenominazione (String denominazione);

}
