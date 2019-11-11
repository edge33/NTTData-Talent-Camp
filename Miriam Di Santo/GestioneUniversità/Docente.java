package com.nttdata.talentcamp.università;

public class Docente extends Persona{
	//private int idDocente;//non serve un ulteriore id xk c'è gia codice fiscale
	
	
	private RuoloDocenti ruolo;



	public Docente(String codiceFiscale,String nome, String cognome,  String sesso,  RuoloDocenti ruolo) {
		super(nome, cognome, codiceFiscale, sesso);
		
		this.ruolo = ruolo;
	}


	public RuoloDocenti getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloDocenti ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "Docente [ruolo=" + ruolo + ", getNome()=" + getNome() + ", getCognome()="
				+ getCognome() +"]";
	}
	
	

}
