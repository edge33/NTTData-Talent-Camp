package com.nttdata.talentcamp.gestioneuniversita;

import java.util.Date;


public class Esame {

	
	private Corso corso;
	private Docenti docente;
	private int voto;
	private Date data;
	
	
	
	public Esame(Corso corso, Docenti docente, int voto, Date data) {
		super();
		this.corso = corso;
		this.docente = docente;
		this.voto = voto;
		this.data = data;
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
	public Docenti getDocente() {
		return docente;
	}
	public void setDocente(Docenti docente) {
		this.docente = docente;
	}
	@Override
	public String toString() {
		return "Esame [corso=" + corso + ", docente=" + docente + ", voto=" + voto + ", data=" + data + "]";
	}

	
	
	
}
