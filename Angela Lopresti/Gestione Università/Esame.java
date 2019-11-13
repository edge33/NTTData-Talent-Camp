package com.talentcamp.universita;

import java.util.Date;

//meglio non fare che esame estende corso!

public class Esame {

//	private String denominazione;
	private Docente docente;
	private int voto;
	private Date data;
//	private Studente studente;
	private Corso corso;
	
	public Esame() {
	super();
    }

	public Esame(Corso corso, Docente docente, int voto, Date data) {
		super();
		this.corso = corso;
		this.docente = docente;
		this.voto = voto;
		this.data = data;
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

	public void setData(Date data) {
		this.data = data;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

}
