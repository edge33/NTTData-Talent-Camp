package com.nttdata.talent.universita;



public class Corso {
	private String denominazione;
	private int cfu;
	private Docente docente;
	public Corso(String denominazione, Docente docente, int cfu) {
		super();
		this.denominazione = denominazione;
		this.cfu = cfu;
		this.docente=docente;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cfu;
		result = prime * result + ((denominazione == null) ? 0 : denominazione.hashCode());
		result = prime * result + ((docente == null) ? 0 : docente.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "Corso [denominazione=" + denominazione + ", cfu=" + cfu + ", docente=" + docente + "]";
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
		if (cfu != other.cfu)
			return false;
		if (denominazione == null) {
			if (other.denominazione != null)
				return false;
		} else if (!denominazione.equals(other.denominazione))
			return false;
		if (docente == null) {
			if (other.docente != null)
				return false;
		} else if (!docente.equals(other.docente))
			return false;
		return true;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}


	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	
}
