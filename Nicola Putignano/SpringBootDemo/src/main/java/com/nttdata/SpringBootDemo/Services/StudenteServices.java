package com.nttdata.SpringBootDemo.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;
import com.nttdata.SpringBootDemo.model.StudenteEntity;
import com.nttdata.SpringBootDemo.Repository.CorsoRepository;
import com.nttdata.SpringBootDemo.Repository.StudenteRepository;
import com.nttdata.SpringBootDemo.dto.StudenteDto;

@Service
public class StudenteServices {

	@Autowired
	private StudenteRepository studenteRepository;

	@Autowired
	private CorsoRepository corsoRepository;
	
	public List<StudenteDto> findAll(){
		List<StudenteEntity> listaEntity = (List<StudenteEntity>) studenteRepository.findAll();
		List<StudenteDto> listaDto = new ArrayList<>(); 
		for(StudenteEntity currStudentEntity : listaEntity) {
			StudenteDto sDto = convertStudentToDto(currStudentEntity);
			listaDto.add(sDto);
		}
		return listaDto;
	}

	public void save(StudenteDto sDto) {
		
		CorsoDiLaureaEntity corsoEntity = corsoRepository.findByDenominazione(sDto.getCorsoDiLaurea().getDenominazione());
		if(corsoEntity == null) {
			new IllegalArgumentException("Corso di Laurea non presente: "+sDto.getCorsoDiLaurea().getDenominazione());
		}
		StudenteEntity sEntity = convertStudentToEntity(sDto);
		sEntity.setCorsoDiLaurea(corsoEntity);
		studenteRepository.save(sEntity);
	}

	public StudenteDto findById(String matricola) {
		StudenteEntity sEntity= studenteRepository.findById(matricola).orElseThrow(()
				-> new IllegalArgumentException("Matricola non valida: "+matricola));
		StudenteDto sDto = convertStudentToDto(sEntity);		
		return sDto;
	}

	public void update(StudenteDto sDto) {

		checkOk(sDto);
		StudenteEntity sEntity = convertStudentToEntity(sDto);
		studenteRepository.save(sEntity);
	}

	private void checkOk(StudenteDto sDto) {
		if(sDto.getNome().length()<2 || sDto.getCognome().length()<2)
			throw new IllegalArgumentException("Nome Troppo corto");

		if(sDto.getCodiceFiscale().length()!=16)
			throw new IllegalArgumentException("Codice Fiscale malformato");

	}

	public void delete(String matricola) {
		StudenteEntity studente = studenteRepository.findById(matricola).orElseThrow(()
				-> new IllegalArgumentException("Matricola non valida: " + matricola));
		studenteRepository.delete(studente);  
	}
	
	private StudenteDto convertStudentToDto(StudenteEntity sEntity) {
		StudenteDto sDto = new StudenteDto();
		sDto.setMatricola(sEntity.getMatricola());
		sDto.setNome(sEntity.getNome());
		sDto.setCognome(sEntity.getCognome());
		sDto.setCorsoDiLaurea(CorsoServices.convertCourseToDto(sEntity.getCorsoDiLaurea()));
		sDto.setCodiceFiscale(sEntity.getCodiceFiscale());
		sDto.setSesso(sEntity.getSesso());
		sDto.setLocalita(sEntity.getLocalita());
		sDto.setProvincia(sEntity.getProvincia());
		sDto.setEmail(sEntity.getEmail());
		sDto.setDataNascita(sEntity.getDataNascita());
		sDto.setDataImmatricolazione(sEntity.getDataImmatricolazione());

		return sDto;
	}
	
	private StudenteEntity convertStudentToEntity(StudenteDto sDto) {
		StudenteEntity sEntity = new StudenteEntity();
		sEntity.setMatricola(sDto.getMatricola());
		sEntity.setNome(sDto.getNome());
		sEntity.setCognome(sDto.getCognome());
		sEntity.setCorsoDiLaurea(CorsoServices.convertCourseToEntity(sDto.getCorsoDiLaurea()));
		sEntity.setCodiceFiscale(sDto.getCodiceFiscale());
		sEntity.setSesso(sDto.getSesso());
		sEntity.setLocalita(sDto.getLocalita());
		sEntity.setProvincia(sDto.getProvincia());
		sEntity.setEmail(sDto.getEmail());
		sEntity.setDataNascita(sDto.getDataNascita());
		sEntity.setDataImmatricolazione(sDto.getDataImmatricolazione());

		return sEntity;
	}	
	
}