package com.nttdata.talent.Università;

import java.util.Date;

public class Docente extends Persona {
	
	private Ruolo ruolo;

	public Docente(String nome, String cognome, String codiceFiscale, char sesso, Date dataNascita, int telefono,
			String email, Ruolo ruolo) {
		super(nome, cognome, codiceFiscale, sesso, dataNascita, telefono, email);
		this.ruolo = ruolo;
	}

	public Docente(String codiceFiscale, String nome, String cognome, Ruolo ruolo) {
		super(codiceFiscale, nome, cognome);
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
				+ ", getCodiceFiscale()=" + getCodiceFiscale() + ", getSesso()=" + getSesso() + ", getDataNascita()="
				+ getDataNascita() + ", getTelefono()=" + getTelefono() + ", getEmail()=" + getEmail() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	

	



	
	

}
