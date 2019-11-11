package com.nttdata.telent.gestioneuniversita;

import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona {
	private String matricola;

	List <Corso> pianoDiStudi;
	List <Esame> esami;





	public Studente(String matricola, String codiceFiscale, String nome, String cognome) {
		super(codiceFiscale, nome, cognome);
		this.matricola = matricola;
		this.pianoDiStudi = new LinkedList();
		this.esami = new LinkedList();
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





	public List<Esame> getEsami() {
		return esami;
	}



	public void setPianoDiStudi(List<Corso> piano) {
		pianoDiStudi = piano;
	}



	public void setEsami(List<Esame> e) {
		esami = e;
	}

	public void addEsame(Esame esame) {
		esami.add(esame);
	}





	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + "]";
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





}
