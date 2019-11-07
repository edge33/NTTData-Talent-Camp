package com.nttdata.talent.universita;

import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona{
	
	private String matricola;
	private List<Corso> pianoStudi;
	private List<Esame> esamiSostenuti;
	
	
	public Studente(String matricola,String codiceFiscale, String nome, String cognome) {
		super(codiceFiscale, nome, cognome);
		this.matricola=matricola;
		this.pianoStudi= new LinkedList<Corso>();
		this.esamiSostenuti= new LinkedList<Esame>();
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + "]";
	}

	public void addEsame (Esame esame) {
		if(!esamiSostenuti.contains(esame)) {
			this.esamiSostenuti.add(esame);
		}
		
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


	public List<Esame> getEsamiSostenuti() {
		return esamiSostenuti;
	}

	public void setEsamiSostenuti(List<Esame> esamiSostenuti) {
		this.esamiSostenuti = esamiSostenuti;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public List<Corso> getPianoStudi() {
		return pianoStudi;
	}

	public void setPianoStudi(List<Corso> pianoStudi) {
		this.pianoStudi = pianoStudi;
	}
	
	
	
	
}
