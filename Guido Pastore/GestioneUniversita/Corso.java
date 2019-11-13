package com.nttdata.talent.Università;

import java.util.LinkedList;
import java.util.List;

public class Corso {

	private Docente docente;
	private String denominazione;
	private int cfu;
	private String settore;
	private LinkedList <Studente> studenti;

	public Corso(String denominazione, String settore, int cfu, Docente docente) {
		super();
		
		this.docente = docente;
		this.denominazione = denominazione;
		this.cfu = cfu;
		this.studenti = new LinkedList <>();
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
	public String getSettore() {
		return settore;
	}
	public void setSettore(String settore) {
		this.settore = settore;
	}

	public LinkedList<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(LinkedList<Studente> studenti) {
		this.studenti = studenti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (denominazione == null) {
			if (other.denominazione != null)
				return false;
		} else if (!denominazione.equals(other.denominazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Corso [docente=" + docente + ", denominazione=" + denominazione + ", cfu=" + cfu + ", settore="
				+ settore + ", studenti=" + studenti + "]";
	}


	

	
	
	
	
}
