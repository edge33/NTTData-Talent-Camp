package com.nttdata.talentcamp.università;

import java.util.Date;
//import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;

public class TestClass {

	public static void main(String[] args) {
		
		Universita unical = new Universita();
		
		//Studenti
		Studente s1 = new Studente("1", "RSSMRO", "Mario", "Rossi", "M");
		Studente s2 = new Studente("2", "VRDGSP", "Giuseppe", "Verdi","M");
		Studente s3 = new Studente("3", "BNCCLR", "Carlo", "Bianchi","M");
		Studente s4 = new Studente("4", "SPSGNN", "Gennaro", "Esposito","M");
		
		//Docenti
		Docente nigro = new Docente("NGRLBR", "Libero", "Nigro", "M",RuoloDocenti.A_TEMPO_INDETERMINATO);
		Docente maida = new Docente("MDAFRN", "Francesco", "Maida","M", RuoloDocenti.A_CONTRATTO);
		Docente furfaro = new Docente("FRFFLP", "Filippo", "Furfaro","M", RuoloDocenti.RICERCATORE);
		Docente celestino = new Docente("MRSCLS", "Celestino", "Amoroso","M", RuoloDocenti.A_CONTRATTO);
		
		//Corsi
		Corso fondamenti = new Corso("Fondamenti di Informatica", "ING/INF", 5, nigro);
		Corso basiDiDati = new Corso("Basi di Dati", "ING/INF", 7, furfaro);
		Corso poo = new Corso("POO", "ING/INF", 10, maida);
		Corso so = new Corso("Sistemi Operativi", "ING/INF", 10, celestino);
		List<Corso> corsi = new LinkedList<Corso>();
		corsi.add(fondamenti);
		corsi.add(basiDiDati);
		corsi.add(poo);
		corsi.add(so);
		
		//Add corsi to Studenti
		s1.setPianoDiStudi(corsi);
		s2.setPianoDiStudi(corsi);
		s3.setPianoDiStudi(corsi);
		s4.setPianoDiStudi(corsi);
		
		//Esami
		
		 
		Esame s1Poo = new Esame(poo, maida, 28, new Date());
		s1.addEsame(s1Poo);
		
		//Esame s1Fnd = new Esame(fondamenti, nigro, 25, new Date());
		//s1.addEsame(s1Fnd);
		
		Esame s1BD = new Esame(basiDiDati, furfaro, 25, new Date());
		s1.addEsame(s1BD);
		
		Esame s1So = new Esame(so, celestino, 18, new Date());
		s1.addEsame(s1So);
		
		
		
		Esame s2BD = new Esame(basiDiDati, furfaro, 18, new Date());
		s2.addEsame(s2BD);
		
		Esame s3Poo = new Esame(poo, maida, 28, new Date());
		s3.addEsame(s3Poo);
		Esame s3BD = new Esame(basiDiDati,furfaro, 18, new Date());
		s3.addEsame(s3BD);
		
		Esame s4So = new Esame(so, celestino, 28, new Date());
		s4.addEsame(s4So);
		Esame s4BD = new Esame(basiDiDati, furfaro, 18, new Date());
		s3.addEsame(s4BD);
		
		//Aggiunta studenti
		unical.addStudente(s1);
		unical.addStudente(s2);
		unical.addStudente(s3);
		unical.addStudente(s4);
		
		
		System.out.println(unical.numeroDiCfuAcquisiti());
		System.out.println(unical.mediaStudente());
		System.out.println(unical.studentiConIMiglioriVoti());
		System.out.println(unical.StudentiChehannoFinitoGliesami());
		System.out.println(unical.DocenteBuono());
		System.out.println(unical.CorsiDifficili());
		System.out.println(unical.CorsiFacili());
		System.out.println(unical.UltimoEsame());
	}
	
}
