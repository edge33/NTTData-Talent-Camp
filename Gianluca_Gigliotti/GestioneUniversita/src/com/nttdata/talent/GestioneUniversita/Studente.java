package com.nttdata.talent.GestioneUniversita;

public class Studente extends Persona {
	String matricola;
	//Corso corso;	
	int idCorso;
	
	public Studente(String matricola) {
		super();
		this.matricola = matricola;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public Studente(String matricola,String cf, String nome, String cognome, char sesso, String nascita) {
		super(cf, nome, cognome, sesso, nascita);
		this.matricola = matricola;
		//this.idCorso = corso; // ho un oggetto corso in studente
		//this.idCorso = c; // ho l'intero di un corso in studente
	}
	
//	public Studente(String cf, String nome, String cognome, char sesso, int giorno, int mese, int anno,String matricola,int corso, Corso c) {
////		super(cf, nome, cognome, sesso, nascita);
//		this.matricola = matricola;
//	}

//	public Studente(String cf, String nome, String cognome, char sesso, int giorno, int mese, int anno,String matricola,int c) {
////		super(cf, nome, cognome, sesso, nascita);
//		this.matricola = matricola;
//		//this.idCorso = corso; // ho un oggetto corso in studente
//		this.idCorso = c; // ho l'intero di un corso in studente
//	}
	
	/*public Studente(String cf, String nome, String cognome, char sesso, int giorno, int mese, int anno,String matricola,int corso, Corso c) {
		super(cf, nome, cognome, nascita);
		this.matricola = matricola;
		//this.idCorso = corso; // ho un oggetto corso in studente
		//this.corso = c; // ho l'intero di un corso in studente  ::: int c
		this.idCorso = c.getIdCorso();
	}*/
	

	@Override
	public String toString() {
		return "Studente [matricola = " + matricola + ", Codicefiscale = "+ codiceFiscale + ", nome=" + nome
				+ ", cognome=" + cognome + ", sesso=" + sesso + "]";
	}

//	public void addEsame(Esame efond) {
//		// TODO Auto-generated method stub
//		
//	}
//   }

	
	
	
	
	
	
	
	




