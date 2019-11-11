package com.nttdata.talent.universita;


public class Corso {
	
	private String nome; 
	private int cfu; 
	private String settore;
	private Docente docente;
	
	
	public Corso(String nome, int cfu, String settore, Docente docente) {
		super();
		this.nome = nome;
		this.cfu = cfu;
		this.settore = settore;
		this.docente = docente;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCfu() {
		return cfu;
	}


	public void setCfu(int cfu) {
		this.cfu = cfu;
	}


	public String getSettore() {
		return settore;
	}


	public void setSettore(String settore) {
		this.settore = settore;
	}


	public Docente getDocente() {
		return docente;
	}
	
	public void setDocente(Docente docente) {
			this.docente = docente;
	}

	@Override
	public String toString() {
		return "Corso [nome=" + nome + ", cfu=" + cfu + ", settore=" + settore + ", docente=" + docente
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cfu;
		result = prime * result + ((docente == null) ? 0 : docente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((settore == null) ? 0 : settore.hashCode());
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
		Corso other = (Corso) obj;
		if (cfu != other.cfu)
			return false;
		if (docente == null) {
			if (other.docente != null)
				return false;
		} else if (!docente.equals(other.docente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (settore == null) {
			if (other.settore != null)
				return false;
		} else if (!settore.equals(other.settore))
			return false;
		return true;
	}


	 
	
	
	
	
	

}
