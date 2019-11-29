package com.nttdata.SpringBootDemo.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;
import com.nttdata.SpringBootDemo.model.StudenteEntity;
import com.nttdata.SpringBootDemo.Repository.CorsoRepository;
import com.nttdata.SpringBootDemo.Repository.StudenteRepository;

@Service
public class StudenteServices {

	@Autowired
	private StudenteRepository studenteRepository;

	@Autowired
	private CorsoRepository corsoRepository;
	
	public List<StudenteEntity> findAll(){
		List<StudenteEntity> listaStudenti= (List<StudenteEntity>) studenteRepository.findAll();
		return listaStudenti;
	}

	public void save(StudenteEntity studente) {
		CorsoDiLaureaEntity corsoEntity = corsoRepository.findByDenominazione(studente.getCorsoDiLaurea().getDenominazione());
		if(corsoEntity == null) {
			new IllegalArgumentException("Corso di Laurea non presente: "+studente.getCorsoDiLaurea().getDenominazione());
		}
		studente.setCorsoDiLaurea(corsoEntity);
		studenteRepository.save(studente);
	}

	public StudenteEntity findById(String matricola) {
		StudenteEntity studente= studenteRepository.findById(matricola).orElseThrow(()
				-> new IllegalArgumentException("Matricola non valida: "+matricola));
		return studente;
	}

	public void update(StudenteEntity studente) {

		checkOk(studente);
		studenteRepository.save(studente);
	}

	private void checkOk(StudenteEntity studente) {
		if(studente.getNome().length()<2 || studente.getCognome().length()<2)
			throw new IllegalArgumentException("Nome Troppo corto");

		if(studente.getCodiceFiscale().length()!=16)
			throw new IllegalArgumentException("Codice Fiscale malformato");

	}

	public void delete(String matricola) {
		StudenteEntity studente = studenteRepository.findById(matricola).orElseThrow(()
				-> new IllegalArgumentException("Matricola non valida: " + matricola));
		studenteRepository.delete(studente);  
	}

}