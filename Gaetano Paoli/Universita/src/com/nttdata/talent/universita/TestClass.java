package com.nttdata.talent.universita;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
		Universita unical = new Universita();
		
		//Studenti
		Studente s1 = new Studente("1", "RSSMRO", "Mario", "Rossi");
		Studente s2 = new Studente("2", "VRDGSP", "Giuseppe", "Verdi");
		Studente s3 = new Studente("3", "BNCCLR", "Carlo", "Bianchi");
		Studente s4 = new Studente("4", "SPSGNN", "Gennaro", "Esposito");
		
		//Docenti
		Docente nigro = new Docente("NGRLBR", "Libero", "Nigro", RuoloDocente.A_TEMPO_INDETERMINATO);
		Docente maida = new Docente("MDAFRN", "Francesco", "Maida", RuoloDocente.A_CONTRATTO);
		Docente furfaro = new Docente("FRFFLP", "Filippo", "Furfaro", RuoloDocente.RICERCATORE);
		Docente celestino = new Docente("MRSCLS", "Celestino", "Amoroso", RuoloDocente.A_CONTRATTO);

		Corso fondamenti = new Corso("Fondamenti di Informatica", nigro,5);
		Corso basiDiDati = new Corso("Basi di Dati", furfaro , 7 );
		Corso poo = new Corso("POO", maida,10);
		Corso so = new Corso("Sistemi Operativi", celestino, 10 );
		Corso iot = new Corso("Internet of things", celestino, 10 );
		List<Corso> corsi = new LinkedList<Corso>();
		corsi.add(fondamenti);
		corsi.add(basiDiDati);
		corsi.add(poo);
		corsi.add(so);
		corsi.add(iot);
		
		//Add corsi to Studenti
		s1.setPianoStudi(corsi);
		s2.setPianoStudi(corsi);
		s3.setPianoStudi(corsi);
		s4.setPianoStudi(corsi);
		
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
		s4.addEsame(s1Poo);
		s1.addEsame(s2BD);
		s1.addEsame(s4So);
		//Aggiunta studenti
		unical.addStudente(s1);
		unical.addStudente(s2);
		unical.addStudente(s3);
		unical.addStudente(s4);
//		System.out.println(unical.studentiMedia());
//		System.out.println(unical.studentiCfuMaturati());
//		System.out.println(unical.studentiTuttiEsamiSostenuti());
//		System.out.println(unical.getStudentiMigliori());
//		System.out.println(unical.docentiMediaMigliore());
//		System.out.print(unical.corsiEsamiMaiSostenuti());
//		System.out.println(unical.corsiSemplici());
//		System.out.println(unical.calcolaMediaCorso(fondamenti));
		System.out.println(unical.studentiUnicoEsameMancante());
		//System.out.println(unical.docentiBuoni());
		//System.out.println(unical.miglioriStudenti());
		
	}
	
}
