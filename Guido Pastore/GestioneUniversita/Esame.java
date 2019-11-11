package com.nttdata.talent.Università;

import java.util.Date;

public class Esame {
	
private Corso corso;
private Docente docente;
private int voto;
private Date dataEsame;


public Esame(Corso corso, Docente docente, int voto, Date dataEsame) {
	super();
	this.corso = corso;
	this.docente = docente;
	this.voto = voto;
	this.dataEsame = dataEsame;
}


public Docente getDocente() {
	return docente;
}


public void setIDocente(Docente docente) {
	this.docente = docente;
}


public Corso getCorso() {
	return corso;
}


public void setCorso(Corso corso) {
	this.corso = corso;
}

public int getVoto() {
	return voto;
}


public void setVoto(int voto) {
	this.voto = voto;
}


public Date getDataEsame() {
	return dataEsame;
}


public void setDataEsame(Date dataEsame) {
	this.dataEsame = dataEsame;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((docente == null) ? 0 : docente.hashCode());
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
	if (docente == null) {
		if (other.docente != null)
			return false;
	} else if (!docente.equals(other.docente))
		return false;
	return true;
}


@Override
public String toString() {
	return "Esame [docente=" + docente + ", corso=" + corso + ", voto=" + voto + ", dataEsame=" + dataEsame + "]";
}


}
