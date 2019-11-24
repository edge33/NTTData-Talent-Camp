package com.nttdata.talent.GestioneUniversita;

public class Docente extends Persona{
	int idDocente;
	private Ruolo ruolo;

	public Docente(String codiceFiscale, String nome, String cognome, int idDocente, RuoloDocente aProgetto) {
		super(codiceFiscale, nome, cognome);
		this.idDocente = idDocente;
		this.ruolo=ruolo;
	}
	
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	@Override
	public String toString() {
		return super.toString() + "Docente [idDocente=" + idDocente + "ruolo="+ ruolo + "]";
	}
	
	
	

}
