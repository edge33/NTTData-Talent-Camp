package com.talentcamp.universita;

public class Docente extends Persona {
	
	private Ruolo ruolo;

	public Docente(String codiceFiscale, String nome, String cognome, Ruolo ruolo) {
		super(nome, cognome, codiceFiscale);
		this.ruolo = ruolo;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	

}
