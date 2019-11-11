package com.nttdata.talent.versioneCorso;

import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona {

	private String matricola;
	private List<Corso> pianoDiStudi; 
	private List<Esame> esamiSostenuti;
	
	public Studente(String matricola, String codiceFiscale, String nome, String cognome) {
		super(codiceFiscale, nome, cognome);
		this.matricola = matricola;
		esamiSostenuti = new LinkedList<>();
		pianoDiStudi = new LinkedList<>();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public List<Esame> getEsamiSostenuti() {
		return esamiSostenuti;
	}

	public void setEsamiSostenuti(List<Esame> esami) {
		this.esamiSostenuti = esami;
	}
	
	public List<Corso> getPianoDiStudi() {
		return pianoDiStudi;
	}

	public void setPianoDiStudi(List<Corso> pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
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
		} else if (!matricola.equals(other.matricola)) {
			return false;
		}	
		return true;
	}

	@Override
	public String toString() {
	
		return "Lo studente: "+getNome()+" "+getCognome()+" con matricola: "+matricola;
	}

	public void addEsame(Esame e) {
		if(!esamiSostenuti.contains(e)) {
			esamiSostenuti.add(e);
		}	
	}
	
	public int getSumCfu() {
		int sumCfu=0;
		for(Esame currExam : esamiSostenuti) {
			sumCfu += currExam.getCorso().getCfu();
		}
		
		return sumCfu;
	}

	public double getMediaPesata() {
		double numeratore = 0.0;
		for(Esame currExam : esamiSostenuti) {
			numeratore += (currExam.getVoto()*currExam.getCorso().getCfu());
		}	
		if (getSumCfu() != 0) {
			return numeratore/getSumCfu();
		} else {
			return numeratore;
		}
	}
	
}
