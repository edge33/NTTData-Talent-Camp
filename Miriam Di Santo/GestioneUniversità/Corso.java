package com.nttdata.talentcamp.universitÓ;


public class Corso {

	private String denominazione;
	private String settore;
	//private int idCorso; // vale la denominazione come identificativo
	private Docente docente;
	private int cfu;

	
	public Corso(String denominazione, String settore, int cfu,Docente docente) {
		super();
		this.denominazione = denominazione;
		this.settore = settore;
		this.docente = docente;
		this.cfu = cfu;
		
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
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

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	@Override
	public String toString() {
		return "Corso [denominazione=" + denominazione + "]";
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
		} else if(!denominazione.equals(other.denominazione))
			return false;
		return true;
	}

	

	
	
	
	
}
