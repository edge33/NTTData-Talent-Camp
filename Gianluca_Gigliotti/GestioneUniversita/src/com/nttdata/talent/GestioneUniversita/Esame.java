package com.nttdata.talent.GestioneUniversita;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Esame{
	int idCorso;
	int codiceDocente;
	int idEsame;
	int voto;
	Date dataEsame;
	long d;
	private Corso corso;
	private Docente docente;
	
	
	Date data = new Date();
	DateFormat formatoData= DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
	String s = formatoData.format(d);
	

//	public Esame(PianoDiStudio idCorso, Docente codiceDocente, int idEsame, int voto, String dataEsame) {
//		//super();
//		this.idCorso = c;
//		this.codiceDocente = codiceDocente;
//		this.idEsame = idEsame;
//		this.voto = voto;
//		this.dataEsame = dataEsame;
//	}

	public Esame(int idCorso, int codiceDocente, int idEsame, int voto, String dataEsame, Date data) {
		this.idCorso = idCorso;
		this.codiceDocente = codiceDocente;
		this.idEsame = idEsame;
		this.voto = voto;
		this.dataEsame = dataEsame;
	}

//	public void setData(Date data) {
//		this.data = data;
//	}
//
//
//	public DateFormat getFormatoData() {
//		return formatoData;
//	}
//
//
//	public void setFormatoData(DateFormat formatoData) {
//		this.formatoData = formatoData;
//	}




	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public int getCodiceDocente() {
		return codiceDocente;
	}

	public void setCodiceDocente(int codiceDocente) {
		this.codiceDocente = codiceDocente;
	}

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
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
	public String toString() {
		return "Esame [idCorso=" + idCorso + ", codiceDocente=" + codiceDocente + ", idEsame=" + idEsame + ", voto="
				+ voto + ", dataEsame=" + dataEsame + ", DATA= " + data +"]";
	}

	

}
