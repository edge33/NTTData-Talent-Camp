package com.nttdata.talent.GestioneUniversita;

import java.util.*;

public class PianoDiStudio extends Corso {
	String matricola;
	int idCorso;
	int anno;
	
	
	public PianoDiStudio(String matricola,  int anno, int idCorso, Corso c) {
		super();
		this.matricola = matricola;
		this.anno = anno;
		this.idCorso = c.getIdCorso();
	
	}

	

	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}



	@Override
	public String toString() {
		return "PianoDiStudio [matricola=" + matricola + ", idCorso=" + idCorso + ", anno=" + anno + "]";
	}

	

	//public int getIdCorso() {
//		return idCorso;
	//}
	//public void setIdCorso(int idCorso) {
//		this.idCorso = idCorso;
	//}
	
	
}


