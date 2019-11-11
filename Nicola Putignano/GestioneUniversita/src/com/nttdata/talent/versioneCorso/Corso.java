package com.nttdata.talent.versioneCorso;

public class Corso {

	private String denominazione;
	private int cfu;
	private String settore;
	private Docente docente;
	
	public Corso(String denominazione, String settore, int cfu, Docente docente) {
		super();
		this.denominazione = denominazione;
		this.cfu = cfu;
		this.settore = settore;
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

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
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
		return "Corsi [denominazione=" + denominazione + ", cfu=" + cfu + ", settore=" + settore + ", docente="
				+ docente + "]";
	}

}
