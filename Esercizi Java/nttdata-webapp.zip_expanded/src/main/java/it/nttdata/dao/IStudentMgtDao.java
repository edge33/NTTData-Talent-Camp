package it.nttdata.dao;

import java.util.List;

import it.nttdata.dao.entity.Corsi;
import it.nttdata.dao.entity.PianoDiStudi;
import it.nttdata.dao.entity.Studente;


public interface IStudentMgtDao {
	
	public boolean addStudente(Studente studente);
	
	public boolean updStudente(Studente studente);
	
	public boolean delStudente(String matricola); 
	
	public Studente findStudenteByMatricola(String matricola);
	
	public List<Studente> findAllStudente();
	
	public List<Corsi> findAllCorsi();
	
	public boolean addPianoDiStudi(PianoDiStudi pianoDiStudi);	
	
	public boolean delPianoDiStudi(String matricola);	
	
	public List<Object[]> findAllExam(String matricola);
	
}
