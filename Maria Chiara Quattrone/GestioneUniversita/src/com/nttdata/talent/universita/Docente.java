package com.nttdata.talent.universita;

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

	@Override
	public String toString() {
		return "Docente [ruolo=" + ruolo + ", getNome()=" + getNome() + ", getCognome()=" + getCognome()
				+ ", getCodiceFiscale()=" + getCodiceFiscale() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
	

}
