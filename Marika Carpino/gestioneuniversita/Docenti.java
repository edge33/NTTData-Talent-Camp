package com.nttdata.talentcamp.gestioneuniversita;

public class Docenti extends Persona {

	private Ruolo ruolo;
	
	
	public Docenti(String codiceFiscale, String nome, String cognome, Ruolo ruolo) {
		super(codiceFiscale, nome, cognome);
		this.ruolo=ruolo;
	}
	
	
	
	
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	@Override
	public String toString() {
		return super.toString()+"Docenti [ruolo=" + ruolo + "]";
	}
	
	
	
	
}
