package com.nttdata.talent.GestioneUniversita;

public class Corso {
	
	int idCorso;
	int idCorsoDiLaureaAppartenenza;
	int idDocente;
	int cfu;
	String nome;
	
	
	public Corso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Corso(int idCorso, int idDocente, int cfu, String nome) {
		super();
		this.idCorso = idCorso;
		//this.idCorsoDiLaureaAppartenenza = idCorsoDiLaureaAppartenenza;
		this.idDocente = idDocente;
		this.cfu = cfu;
		this.nome = nome;
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Corso [idCorso=" + idCorso + ", idDocente=" + idDocente + ", cfu=" + cfu + ", nome=" + nome + "]";
	}
	public static void addCorso(Corso c1) {
		// TODO Auto-generated method stub
		
	}
	public static void addCorso(Object setNome) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

