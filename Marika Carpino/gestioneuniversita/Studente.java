package com.nttdata.talentcamp.gestioneuniversita;

import java.util.LinkedList;
import java.util.List;


public class Studente extends Persona {

	private String matricola;
	private List<Corso> pianoDiStudio;
	private List<Esame> esami;
	
	
	public Studente(String codiceFiscale, String nome, String cognome, String matricola) {
		super(codiceFiscale, nome, cognome);
		this.matricola=matricola;
		this.pianoDiStudio=new LinkedList<Corso>();
		this.esami=new LinkedList<Esame>();
		
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public List<Corso> getPianoDiStudio() {
		return pianoDiStudio;
	}

	public void setPianoDiStudio(List<Corso> pianoDiStudio) {
		this.pianoDiStudio = pianoDiStudio;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public void addEsame(Esame esame) {
		esami.add(esame);
		
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", pianoDiStudio=" + pianoDiStudio + ", esami=" + esami + "]";
	}
	
	
	

	
	
	
	
}
