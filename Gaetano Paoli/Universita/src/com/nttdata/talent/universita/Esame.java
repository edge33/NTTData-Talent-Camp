package com.nttdata.talent.universita;


import java.util.Date;


public class Esame {

	private int voto;
	private Date data;
	private Corso corso;
	private Docente docente;
	
	

    public Esame(Corso corso, Docente docente, int voto, Date data) {
		this.voto = voto;
		this.data = data;
		this.corso = corso;
		this.docente = docente;
	}

	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((docente == null) ? 0 : docente.hashCode());
		result = prime * result + voto;
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
		Esame other = (Esame) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (docente == null) {
			if (other.docente != null)
				return false;
		} else if (!docente.equals(other.docente))
			return false;
		if (voto != other.voto)
			return false;
		return true;
	}


	

	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Corso getCorso() {
		return corso;
	}


	public void setCorso(Corso corso) {
		this.corso = corso;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	
	
}
