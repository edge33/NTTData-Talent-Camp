package com.nttdata.telent.gestioneuniversita;


public class Docente extends Persona {
	
	private Ruolo RuoloDocente;

	
	public Docente(String codiceFiscale, String nome, String cognome,
			Ruolo ruoloDocente) {
		super(codiceFiscale, nome, cognome);
		RuoloDocente = ruoloDocente;
	}

	public Ruolo getRuoloDocente() {
		return RuoloDocente;
	}

	public void setRuoloDocente(Ruolo ruoloDocente) {
		RuoloDocente = ruoloDocente;
	}

	
	
	
}