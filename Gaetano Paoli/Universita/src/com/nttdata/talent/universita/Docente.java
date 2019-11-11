package com.nttdata.talent.universita;



public class Docente extends Persona {
	private RuoloDocente ruolo;
	

	public Docente(String codiceFiscale, String nome, String cognome, RuoloDocente ruolo) {
		super(codiceFiscale, nome, cognome);
		this.ruolo=ruolo;
	}
	

	@Override
	public String toString() {
		return " Docente " + getNome()+" "+ getCognome()+"  "+ruolo;
	}


	public RuoloDocente getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloDocente ruolo) {
		this.ruolo = ruolo;
	}
	
	

	
}
