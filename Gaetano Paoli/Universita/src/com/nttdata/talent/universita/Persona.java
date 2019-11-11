package com.nttdata.talent.universita;

//import java.util.Date;

public class Persona {
	private String codiceFiscale;
	private String nome;
	private String cognome;
	
	private char sesso;

	public Persona() {
		// default 
	}
	
	//costruttore
	public Persona(String codiceFiscale, String nome, String cognome) {
	
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
															  
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Persona [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", sesso="
				+ sesso +  "]";
	}
	
	//getter and setters
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	

}
