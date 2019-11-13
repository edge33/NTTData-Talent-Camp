package com.nttdata.talent.uni;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestClass {
	
public static void main(String[] args) {
		
		Universita unical = new Universita();
		
		//Studenti
		Studente s1 = new Studente("Mario", "Rossi", "RSSMRO", "1");
		Studente s2 = new Studente("Giuseppe", "Verdi", "VRDGSP", "2");
		Studente s3 = new Studente("Carlo", "Bianchi", "BNCCLR", "3");
		Studente s4 = new Studente("Gennaro", "Esposito", "SPSGNN", "4");
		
		//Docenti
		Docente nigro = new Docente("Libero", "Nigro", "NGRLBR", TipologiaRuolo.A_TEMPO_INDETERMINATO);
		Docente maida = new Docente("Francesco", "Maida", "MDAFRN", TipologiaRuolo.A_CONTRATTO);
		Docente furfaro = new Docente("Filippo", "Furfaro", "FRFFLP", TipologiaRuolo.RICERCATORE);
		Docente celestino = new Docente("Celestino", "Amoroso", "MRSCLS", TipologiaRuolo.A_CONTRATTO);
		
		//Corsi
		Corso fondamenti = new Corso("Fondamenti di Informatica", nigro, 5);
		Corso basiDiDati = new Corso("Basi di Dati", furfaro, 7);
		Corso poo = new Corso("POO", maida, 10);
		Corso so = new Corso("Sistemi Operativi", celestino, 10);
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
		Esame s1Fnd = new Esame(fondamenti, nigro, 25, new Date());
		s1.addEsame(s1Fnd);
		
		Esame s2BD = new Esame(basiDiDati, furfaro, 18, new Date());
		s2.addEsame(s2BD);
		
		Esame s3Poo = new Esame(poo, maida, 18, new Date());
		s3.addEsame(s3Poo);
		
		Esame s4So = new Esame(so, celestino, 25, new Date());
		s4.addEsame(s4So);
		
		//Aggiunta studenti
		unical.addStudente(s1);
		unical.addStudente(s2);
		unical.addStudente(s3);
		unical.addStudente(s4);
		
		//System.out.println(unical.studentiMigliori());
		//System.out.println(unical.studentiBravi());
		//System.out.println(unical.docentiBuoni());  
		//System.out.println(unical.mediaPesataPerStudente());
		//System.out.println(unical.cfuPerStudente());
		//System.out.println(unical.getDocenti());
		System.out.println(unical.corsiConStudentiCattivi());
		//System.out.println(unical.corsiPiuSemplici());
		//System.out.println(unical.studentiACuiMancaUnEsame());
	}

}
