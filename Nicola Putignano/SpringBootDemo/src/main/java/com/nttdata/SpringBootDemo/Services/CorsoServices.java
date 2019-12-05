package com.nttdata.SpringBootDemo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.SpringBootDemo.Repository.CorsoRepository;
import com.nttdata.SpringBootDemo.dto.CorsoDiLaureaDto;
import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;

@Service
public class CorsoServices {
	
	@Autowired
	private CorsoRepository corsoRepository;
	
	public List<CorsoDiLaureaDto> findAll(){
		List<CorsoDiLaureaEntity> listaEntity = (List<CorsoDiLaureaEntity>) corsoRepository.findAll();
		List<CorsoDiLaureaDto> listaDto = new ArrayList<>();
		for(CorsoDiLaureaEntity currEntity : listaEntity) {
			CorsoDiLaureaDto cDto = convertCourseToDto(currEntity);
			listaDto.add(cDto);
		}
		return listaDto;
	}
	
	public void save(CorsoDiLaureaDto cDto) {
		CorsoDiLaureaEntity cEntity = convertCourseToEntity(cDto);
		corsoRepository.save(cEntity);
	}
	
	public CorsoDiLaureaDto findById(Long id) {
		CorsoDiLaureaEntity cEntity= corsoRepository.findById(id).orElseThrow(()
				-> new IllegalArgumentException("Id non valido: "+id));
		CorsoDiLaureaDto cDto = convertCourseToDto(cEntity); 
		return cDto;
	}
	
	public void update(CorsoDiLaureaDto cDto ) {

		checkOk(cDto);
		CorsoDiLaureaEntity cEntity = convertCourseToEntity(cDto);
		corsoRepository.save(cEntity);
	}

	private void checkOk(CorsoDiLaureaDto cDto) {
		if(cDto.getDipartimento() < 1 || cDto.getDenominazione().length()<2)
			throw new IllegalArgumentException("Nome Troppo corto");
	}
	
	public void delete(Long id) {
		CorsoDiLaureaEntity corsoDiLaurea = corsoRepository.findById(id).orElseThrow(()
				-> new IllegalArgumentException("Matricola non valida: " + id));
		corsoRepository.delete(corsoDiLaurea);  
	}

	public static CorsoDiLaureaDto convertCourseToDto(CorsoDiLaureaEntity cEntity) {
		CorsoDiLaureaDto cDto = new CorsoDiLaureaDto();
		
		cDto.setId(cEntity.getId());
		cDto.setDipartimento(cEntity.getDipartimento());
		cDto.setDenominazione(cEntity.getDenominazione());
		
		return cDto;
	}
	
	public static CorsoDiLaureaEntity convertCourseToEntity(CorsoDiLaureaDto cDto) {
		CorsoDiLaureaEntity cEntity = new CorsoDiLaureaEntity();
		
		cEntity.setId(cDto.getId());
		cEntity.setDipartimento(cDto.getDipartimento());
		cEntity.setDenominazione(cDto.getDenominazione());
		
		return cEntity;
	}
}
