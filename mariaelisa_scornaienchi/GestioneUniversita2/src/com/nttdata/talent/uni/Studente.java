package com.nttdata.talent.uni;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona {
	
	private String matricola;
	private String provincia;
	private String localita;
	private Date dataNascita;
	private List<Corso> pianoDiStudi;
	private List<Esame> esami;
	
	public void addEsame(Esame e) {
		if (e!=null && !esami.contains(e))
			esami.add(e);
	}
	
	
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	public List<Corso> getPianoDiStudi() {
		return pianoDiStudi;
	}
	public void setPianoDiStudi(List<Corso> pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
	}
	@Override
	public String toString() {
		return super.toString()+" Studente [matricola=" + matricola + ", provincia=" + provincia + ", localita=" + localita
				+ ", dataNascita=" + dataNascita + "]";
	}
	public Studente(String nome, String cognome, String codiceFiscale, String matricola) {
		super(nome, cognome, codiceFiscale);
		this.matricola=matricola;
		esami=new LinkedList<Esame>();
		pianoDiStudi=new LinkedList<Corso>();
		// TODO Auto-generated constructor stub
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalita() {
		return localita;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}
	
	

}
