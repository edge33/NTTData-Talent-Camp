package com.nttdata.talent.universita;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestUniversita {
	
public static void main(String[] args) {
		
		Universita unical = new Universita();
		
		//Studenti
		Studente s1 = new Studente("1", "RSSMRO", "Mario", "Rossi");
		Studente s2 = new Studente("2", "VRDGSP", "Giuseppe", "Verdi");
		Studente s3 = new Studente("3", "BNCCLR", "Carlo", "Bianchi");
		Studente s4 = new Studente("4", "SPSGNN", "Gennaro", "Esposito");
		
		//Docenti
		Docente nigro = new Docente("NGRLBR", "Libero", "Nigro", Ruolo.TEMPO_INDETERMINATO);
		Docente maida = new Docente("MDAFRN", "Francesco", "Maida", Ruolo.A_CONTRATTO);
		Docente furfaro = new Docente("FRFFLP", "Filippo", "Furfaro", Ruolo.RICERCATORE);
		Docente celestino = new Docente("MRSCLS", "Celestino", "Amoroso", Ruolo.A_CONTRATTO);
		Docente conforti= new Docente ("CNFDMN", "Conforti", "Domenico", Ruolo.TEMPO_INDETERMINATO);
		
		//Corsi
		Corso fondamenti = new Corso("Fondamenti di Informatica", 5, "ING/INF", nigro);
		Corso basiDiDati = new Corso("Basi di Dati", 7, "ING/INF", furfaro);
		Corso poo = new Corso("POO", 10, "ING/INF", maida);
		Corso so = new Corso("Sistemi Operativi", 10, "ING/INF", celestino);
		Corso dataMining = new Corso("Data Mining", 9, "ING/INF", conforti);
		
		List<Corso> corsi = new LinkedList<Corso>();
		
		corsi.add(fondamenti);
		corsi.add(basiDiDati);
		corsi.add(poo);
		corsi.add(so);
		corsi.add(dataMining);
		
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
		Esame s1Bd = new Esame(basiDiDati, furfaro, 29, new Date());
		s1.addEsame(s1Bd);
		Esame s1So=new Esame(so, celestino, 27, new Date());
		s1.addEsame(s1So);
		
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
	
		
		
	  
	   System.out.println(unical.studenteCfu(unical.getStudenti()));
	   System.out.println(unical.studTuttiEsami(unical.getStudenti()));
	   System.out.println(unical.maxMediaVotiDoc());
	   System.out.println(unical.corsoStudBetter());
	   System.out.println(unical.studCorso(fondamenti));
	   System.out.println(unical.nessunEsame());
	   System.out.println(unical.corsiSemplici());
	   //System.out.println(unical.mediaVotiStessoCorso(so));
	  // System.out.println(unical.esamiMancanti(s1));
	   System.out.println(unical.corsiEsamiFatti(s4));
		System.out.println(unical.corsiEsamiMancanti(s1));
		
		System.out.println(unical.onlyOne());
	}

}
