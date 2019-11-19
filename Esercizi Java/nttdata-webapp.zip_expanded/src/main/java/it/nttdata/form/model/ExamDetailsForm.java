package it.nttdata.form.model;

import java.io.Serializable;

public class ExamDetailsForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codCorsoLaurea = "";
	private String matricola = "";
	private String esameDesc = "";
	private String cfu = "";
	private String anno = "";
	private String semestre = "";

	public ExamDetailsForm() {

	}

	public ExamDetailsForm(	String codCorsoLaurea, 
							String matricola, 
							String esameDesc, 
							String cfu, 
							String anno,
							String semestre) {
		this.codCorsoLaurea = codCorsoLaurea;
		this.matricola = matricola;
		this.esameDesc = esameDesc;
		this.cfu = cfu;
		this.anno = anno;
		this.semestre = semestre;
	}

	public String getCodCorsoLaurea() {
		return codCorsoLaurea;
	}

	public void setCodCorsoLaurea(String codCorsoLaurea) {
		this.codCorsoLaurea = codCorsoLaurea;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEsameDesc() {
		return esameDesc;
	}

	public void setEsameDesc(String esameDesc) {
		this.esameDesc = esameDesc;
	}

	public String getCfu() {
		return cfu;
	}

	public void setCfu(String cfu) {
		this.cfu = cfu;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExamDetailsForm [codCorsoLaurea=");
		builder.append(codCorsoLaurea);
		builder.append(", matricola=");
		builder.append(matricola);
		builder.append(", esameDesc=");
		builder.append(esameDesc);
		builder.append(", cfu=");
		builder.append(cfu);
		builder.append(", anno=");
		builder.append(anno);
		builder.append(", semestre=");
		builder.append(semestre);
		builder.append("]");
		return builder.toString();
	}

}
