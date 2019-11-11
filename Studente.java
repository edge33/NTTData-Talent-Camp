package com.talentcamp.universita;

import java.util.LinkedList;
import java.util.List;

// in studente è andata per la maggiore definire una variabile d'istanza "lista di corsi", il "piano di studi"
// nonché anche una lista di esami

public class Studente extends Persona {
	
	private String matricola;
	
	private List<Corso> pianoDiStudi;
	private List<Esame> esami;
	
	public Studente(String matricola, String codiceFiscale, String nome, String cognome) {
		super(nome, cognome, codiceFiscale);
		this.matricola = matricola;
		this.esami = new LinkedList<>();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public List<Corso> getPianoDiStudi() {
		return pianoDiStudi;
	}

	public void setPianoDiStudi(List<Corso> pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	
	

	public void addEsame(Esame esame) {	
		if (!(esami.contains(esame)))
		  esami.add(esame);		
	}
}
