package com.nttdata.talent.universita;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona {
	
	private String matricola;
	private List <Corso> pianoDiStudi;
	private List <Esame> esami;
	
	
	public Studente(String matricola, String codiceFiscale,String nome, String cognome) {
		super(nome, cognome, codiceFiscale);
		this.matricola = matricola;
		this.pianoDiStudi = new LinkedList<Corso>();
		this.esami = new LinkedList<Esame>();
		
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", pianoDiStudi=" + pianoDiStudi + ", esami=" + esami
				+ ", getNome()=" + getNome() + ", getCognome()=" + getCognome() + ", getCodiceFiscale()="
				+ getCodiceFiscale() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}


	public void addEsame(Esame esame) {
     //esame = new Esame(esame.getCorso(),esame.getDocente(), esame.getVoto(), esame.getData());
     esami.add(esame);
	
	}
	


	} 
 
	

	
	
	
	


