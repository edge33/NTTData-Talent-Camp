package com.nttdata.talent.uni;

public class Docente extends Persona{
	
	private TipologiaRuolo ruolo;

	public Docente(String nome, String cognome, String codiceFiscale, TipologiaRuolo ruolo) {
		super(nome, cognome, codiceFiscale);
		this.ruolo=ruolo;
	}

	public TipologiaRuolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(TipologiaRuolo ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return super.toString()+" Docente [tipologia=" + ruolo + "]";
	}
	
	
	

}
