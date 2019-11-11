package com.nttdata.talent.universita;

import java.util.Date;


public class Esame {
	
	private int voto; 
	private Date data;
	private Corso corso;
	private Docente docente;
	
	public Esame(Corso corso,Docente docente, int voto, Date data) {
		super();
		this.voto = voto;
		this.data = data;
		this.corso = corso;
		this.docente = docente;
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

	@Override
	public String toString() {
		return "Esame [voto=" + voto + ", data=" + data + ", corso=" + corso + ", docente=" + docente + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	} 
	
	
	


}
