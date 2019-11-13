package com.nttdata.talent.Università;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona{
	
	private String matricola;

    private List <Esame> esami;
    private List <Corso> pianoDiStudi;
	
	public Studente(String matricola, String codiceFiscale, String nome, String cognome) {
		super(codiceFiscale, nome, cognome);
		this.matricola = matricola;
		this.esami = new LinkedList <>();
	}

	public Studente(String nome, String cognome, String codiceFiscale, char sesso, Date dataNascita, int telefono,
			String email, String matricola) {
		super(nome, cognome, codiceFiscale, sesso, dataNascita, telefono, email);
		this.matricola = matricola;
		this.esami = new LinkedList<>();
		this.pianoDiStudi = new LinkedList<>();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", esami=" + esami + ", pianoDiStudi=" + pianoDiStudi
				+ ", getNome()=" + getNome() + ", getCognome()=" + getCognome() + ", getCodiceFiscale()="
				+ getCodiceFiscale() + ", getSesso()=" + getSesso() + ", getDataNascita()=" + getDataNascita()
				+ ", getTelefono()=" + getTelefono() + ", getEmail()=" + getEmail() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}

	public int getSommaCfu() {
		int sommaCfu = 0;
		for(Esame esameCurr: esami) {
				sommaCfu += esameCurr.getCorso().getCfu();		
		}
		return sommaCfu;
	}

	public double getMediaPesata() {
		double numeratore = 0;
		for(Esame esameCurr: esami) {
			numeratore += esameCurr.getVoto() * esameCurr.getCorso().getCfu();
		}
		if(getSommaCfu()!=0) {
		    return numeratore /getSommaCfu();
		}else {
			return 0.0;
		}
		
	}

public void addEsame(Esame e) {
	esami.add(e);
}
	

public int prendiVoto() {
	int voto = 0;
	for(Esame esameCurr : esami) {
		voto = esameCurr.getVoto();
	}
	return voto;
}

	
	
	
	
	
	
	
 
}
