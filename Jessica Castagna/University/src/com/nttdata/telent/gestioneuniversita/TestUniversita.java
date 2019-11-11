package com.nttdata.telent.gestioneuniversita;

import java.util.LinkedList;

import java.util.List;

import java.util.Date;



public class TestUniversita {

	public static void main(String[] args) {

		
				Universita unical = new Universita();
				
				//Studenti
				Studente s1 = new Studente("1", "RSSMRO", "Mario", "Rossi");
				Studente s2 = new Studente("2", "VRDGSP", "Giuseppe", "Verdi");
				Studente s3 = new Studente("3", "BNCCLR", "Carlo", "Bianchi");
				Studente s4 = new Studente("4", "SPSGNN", "Gennaro", "Esposito");
				
				//Docenti
				Docente nigro = new Docente("NGRLBR", "Libero", "Nigro", Ruolo.A_TEMPOINDETERMINATO);
				Docente maida = new Docente("MDAFRN", "Francesco", "Maida", Ruolo.A_CONTRATTO);
				Docente furfaro = new Docente("FRFFLP", "Filippo", "Furfaro", Ruolo.RICERCATORE);
				Docente celestino = new Docente("MRSCLS", "Celestino", "Amoroso", Ruolo.A_CONTRATTO);
				
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
				Esame s1so = new Esame(so, celestino, 25, new Date());
				s1.addEsame(s1so);
				Esame s1bd = new Esame(basiDiDati, furfaro, 27, new Date());
				s1.addEsame(s1bd);
				
				Esame s2BD = new Esame(basiDiDati, furfaro, 23, new Date());
				s2.addEsame(s2BD);
				Esame s2Poo = new Esame(poo, maida, 25, new Date());
				s2.addEsame(s1Poo);
				Esame s2Fnd = new Esame(fondamenti, nigro, 20, new Date());
				s2.addEsame(s2Fnd);
				Esame s2so = new Esame(so, celestino, 25, new Date());
				s2.addEsame(s2so);
				
				
				
				Esame s3Poo = new Esame(poo, maida, 18, new Date());
				s3.addEsame(s3Poo);
				
				Esame s4So = new Esame(so, celestino, 25, new Date());
				s4.addEsame(s4So);
				
				//Aggiunta studenti
				unical.addStudente(s1);
				unical.addStudente(s2);
				unical.addStudente(s3);
				unical.addStudente(s4);
				
				
				//ESERCIZIO 1
				System.out.println("Il numero di CFU maturati da ogni studente è: " +unical.getCfuPerOgniStudente());				
				//ESERCIZIO 2
				System.out.println("Le medie pesate di ciascun studente sono: " +unical.getMediaPesataPerOgniStudente());
				//ESERCIZIO 3
				System.out.println("Gli studenti che hanno superato tutti gli esami sono: " +unical.getStudentiTuttiEsami());
				//ESERCIZIO 4
				System.out.println("I migliori studenti per corso sono: " +unical.MiglioriStudenti());
				//ESERCIZIO 5
				System.out.println("Per ogni ruolo, i docenti che erogano i voti più alti sono: " +unical.docentiBuoni());
				//ESERCIZIO 6
				System.out.println("I corsi non sostenuti da alcun studente sono: " +unical.listaCorsiNoEsami());
				//ESERCIZIO 7
				System.out.println("I corsi più semplici sono: " +unical.listaCorsiSemplici());
				//ESERCIZIO 8
				System.out.println("Gli studenti a cui manca un solo esame sono:" +unical.studentiMenoUnEsame());
	}
			
	


	}