package com.nttdata.SpringBootDemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.SpringBootDemo.Repository.CorsoRepository;
import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;

@Service
public class CorsoServices {
	
	@Autowired
	private CorsoRepository corsoRepository;
	
	public List<CorsoDiLaureaEntity> findAll(){
		List<CorsoDiLaureaEntity> listaCorsi = (List<CorsoDiLaureaEntity>) corsoRepository.findAll();
		return listaCorsi;
	}
	
	public void save(CorsoDiLaureaEntity corsoDiLaurea) {
		
		//Controlli
		corsoRepository.save(corsoDiLaurea);
	}
	
	public CorsoDiLaureaEntity findById(Long id) {
		CorsoDiLaureaEntity corsoDiLaurea= corsoRepository.findById(id).orElseThrow(()
				-> new IllegalArgumentException("Id non valido: "+id));
		return corsoDiLaurea;
	}
	
	public void update(CorsoDiLaureaEntity corsoDiLaurea ) {

		checkOk(corsoDiLaurea);
		corsoRepository.save(corsoDiLaurea);
	}

	private void checkOk(CorsoDiLaureaEntity corsoDiLaurea) {
		if(corsoDiLaurea.getDipartimento() < 1 || corsoDiLaurea.getDenominazione().length()<2)
			throw new IllegalArgumentException("Nome Troppo corto");
	}
	
	public void delete(Long id) {
		CorsoDiLaureaEntity corsoDiLaurea = corsoRepository.findById(id).orElseThrow(()
				-> new IllegalArgumentException("Matricola non valida: " + id));
		corsoRepository.delete(corsoDiLaurea);  
	}

}
