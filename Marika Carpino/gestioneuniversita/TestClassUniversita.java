package com.nttdata.talentcamp.gestioneuniversita;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;



public class TestClassUniversita {

	public static void main(String[] args) {
		
		Universita unical = new Universita();
		
		//Studenti
		Studente s1 = new Studente("RSSMRO", "Mario", "Rossi","1");
		Studente s2 = new Studente("VRDGSP", "Giuseppe", "Verdi", "2");
		Studente s3 = new Studente("BNCCLR", "Carlo", "Bianchi","3");
		Studente s4 = new Studente("SPSGNN", "Gennaro", "Esposito","4");
		Studente s5 = new Studente("GPPFRE", "Giuseppe", "Fera","5");
		
		//Docenti
		Docenti nigro = new Docenti("NGRLBR", "Libero", "Nigro", Ruolo.A_TEMPO_INDETERMINATO);
		Docenti maida = new Docenti("MDAFRN", "Francesco", "Maida", Ruolo.A_CONTRATTO);
		Docenti furfaro = new Docenti("FRFFLP", "Filippo", "Furfaro", Ruolo.RICERCATORE);
		Docenti celestino = new Docenti("MRSCLS", "Celestino", "Amoroso", Ruolo.A_CONTRATTO);
		Docenti carpino = new Docenti("CRPMRK", "Marika", "Carpino", Ruolo.A_TEMPO_INDETERMINATO);
		
		//Corsi
		Corso fondamenti = new Corso("Fondamenti di Informatica", "ING/INF", 5, nigro);
		Corso basiDiDati = new Corso("Basi di Dati", "ING/INF", 7, furfaro);
		Corso poo = new Corso("POO", "ING/INF", 10, maida);
		Corso so = new Corso("Sistemi Operativi", "ING/INF", 10, celestino);
		Corso alg= new Corso("Algebra", "ALG/GEO", 11, carpino);
		List<Corso> corsi = new LinkedList<Corso>();
		corsi.add(fondamenti);
		corsi.add(basiDiDati);
		corsi.add(poo);
		corsi.add(so);
		corsi.add(alg);
		
		
		//Add corsi to Studenti
		s1.setPianoDiStudio(corsi);
		s2.setPianoDiStudio(corsi);
		s3.setPianoDiStudio(corsi);
		s4.setPianoDiStudio(corsi);
		s5.setPianoDiStudio(corsi);
		
		//Esami
		Esame s1Poo = new Esame(poo, maida, 28, new Date());
		s1.addEsame(s1Poo);
		
		
		Esame s1Fnd = new Esame(fondamenti, nigro, 25, new Date());
		s1.addEsame(s1Fnd);
		
		
		Esame s2BD = new Esame(basiDiDati, furfaro, 18, new Date());
		s2.addEsame(s2BD);
		
		Esame s3Poo = new Esame(poo, maida, 18, new Date());
		s3.addEsame(s3Poo);
		
		Esame s4So = new Esame(so, celestino, 25, new Date());
		s4.addEsame(s4So);
		
		Esame s5Poo =new Esame(poo, maida, 28, new Date());
		Esame s5Fnd = new Esame(fondamenti, nigro, 25, new Date());
		Esame s5BD = new Esame(basiDiDati, furfaro, 27, new Date());
		Esame s5So = new Esame(so, celestino, 25, new Date());
		Esame s5Alg= new Esame(alg, carpino, 30, new Date());
		s5.addEsame(s5So);
		s5.addEsame(s5BD);
		s5.addEsame(s5Fnd);
		s5.addEsame(s5Alg);
		s5.addEsame(s5Poo);
		
		
		
		//Aggiunta studenti
		unical.addStudente(s1);
		unical.addStudente(s2);
		unical.addStudente(s3);
		unical.addStudente(s4);
		unical.addStudente(s5);
		
		//System.out.println(unical.docentiBuoni());
		//System.out.println(unical.miglioriStudenti());
		
		
		
		//System.out.println(stud.toString());
		
		
		//System.out.println( unical.getCfu());
		
		
		//System.out.println(unical.getMediaPesata());
		
		
		
		
		//System.out.println(unical.studentiEsamiFiniti());
		
		
		//System.out.println(unical.getDocenti());
		
		
		//System.out.println(unical.docentiMiglioriPerRuolo());
		
		//System.out.println(unical.getListaCorsi());
		//System.out.println(unical.esamiNonSostenutiDaNessuno());
		//System.out.println(unical.studenteEsameMancante());
		//System.out.println(unical.corsiSemplici());
		
		
		//System.out.println(unical.getStudentiMigliori());
	}
	
}

