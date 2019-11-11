package com.nttdata.telent.gestioneuniversita;

public class Persona {

	private String nome;
	private String cognome;
	private String codiceFiscale;


	public Persona( String codiceFiscale, String nome, String cognome) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;

	}




	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + "]";
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


	
	
	
	
	
}