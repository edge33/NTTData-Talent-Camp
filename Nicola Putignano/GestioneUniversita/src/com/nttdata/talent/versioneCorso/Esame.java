package com.nttdata.talent.versioneCorso;

import java.util.Date;

public class Esame {
	
	private int voto;
	private Date data;
	private Corso corso;
	private Docente docente;
	
	
	public Esame(Corso corso, Docente docente, int voto, Date data) {
		super();
		this.voto = voto;
		this.data = data;
		this.corso = corso;
		this.docente = docente;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
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

	public void setDataEsame(Date data) {
		this.data = data;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

}
