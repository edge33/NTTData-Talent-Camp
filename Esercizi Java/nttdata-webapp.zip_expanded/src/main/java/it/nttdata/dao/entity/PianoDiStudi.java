package it.nttdata.dao.entity;

import java.io.Serializable;

public class PianoDiStudi implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fkMatricola = "";
	private int fkIdCorso = 0;
	private int anno = 0;
	private int semestre = 0;

	public PianoDiStudi() {

	}

	public PianoDiStudi(String fkMatricola, int fkIdCorso, int anno, int semestre) {
		this.fkMatricola = fkMatricola;
		this.fkIdCorso = fkIdCorso;
		this.anno = anno;
		this.semestre = semestre;
	}

	public String getFkMatricola() {
		return fkMatricola;
	}

	public void setFkMatricola(String fkMatricola) {
		this.fkMatricola = fkMatricola;
	}

	public int getFkIdCorso() {
		return fkIdCorso;
	}

	public void setFkIdCorso(int fkIdCorso) {
		this.fkIdCorso = fkIdCorso;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PianoDiStudi [fkMatricola=");
		builder.append(fkMatricola);
		builder.append(", fkIdCorso=");
		builder.append(fkIdCorso);
		builder.append(", anno=");
		builder.append(anno);
		builder.append(", semestre=");
		builder.append(semestre);
		builder.append("]");
		return builder.toString();
	}
}
