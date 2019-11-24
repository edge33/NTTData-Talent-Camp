package com.nttdata.talent.GestioneUniversita;
import java.util.*;

public class Persona {
	String codiceFiscale;
	String nome;
	String cognome;
	char sesso;
	String nascita;
	
	
	
	
	public Persona() {
		
	}
	
	public Persona(String cf, String nome, String cognome, char sesso, String nascita) {
		this.codiceFiscale = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.nascita=nascita;
		
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getNascita() {
		return nascita;
	}

	public void setNascita(String nascita) {
		this.nascita = nascita;
	}

	
}

	
	
	



