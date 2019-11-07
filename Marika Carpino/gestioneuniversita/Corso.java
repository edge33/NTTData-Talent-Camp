package com.nttdata.talentcamp.gestioneuniversita;



public class Corso {

	
	private String denominazione;
	private String settore;
	private int cfu;
	private Docenti docente;
	
	
	
	
	public Corso(String denominazione, String settore, int cfu, Docenti docente) {

		this.denominazione = denominazione;
		this.settore = settore;
		this.cfu = cfu;
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
	public Docenti getDocente() {
		return docente;
	}
	public void setDocente(Docenti docente) {
		this.docente = docente;
	}



	@Override
	public String toString() {
		return "Corso [denominazione=" + denominazione + ", settore=" + settore + ", cfu=" + cfu + ", docente="
				+ docente + "]";
	}
	
	
	
	
	
}