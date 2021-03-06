package com.nttdata.talent.uni;

import java.util.List;

public class Corso {
	
	private String denominazione;
	private Docente docente;
	private int cfu;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((docente == null) ? 0 : docente.hashCode());
		result = prime * result + ((denominazione == null) ? 0 : denominazione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (docente == null) {
			if (other.docente != null)
				return false;
		} else if (!docente.equals(other.docente))
			return false;
		if (denominazione == null) {
			if (other.denominazione != null)
				return false;
		} else if (!denominazione.equals(other.denominazione))
			return false;
		return true;
	}

	

	public Corso(String nome, Docente docente, int cfu) {
		super();
		this.denominazione = nome;
		this.docente = docente;
		this.cfu = cfu;
	}
	
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String nome) {
		this.denominazione = nome;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	@Override
	public String toString() {
		return "Corso [nome=" + denominazione + ", docente=" + docente + ", cfu=" + cfu + "]";
	}
	

}
