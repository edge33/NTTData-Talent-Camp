package com.nttdata.talent.versioneCorso;

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
		Docente nigro = new Docente("NGRLBR", "Libero", "Nigro", RuoloDocente.ORDINARIO);
		Docente maida = new Docente("MDAFRN", "Francesco", "Maida", RuoloDocente.A_CONTRATTO);
		Docente furfaro = new Docente("FRFFLP", "Filippo", "Furfaro", RuoloDocente.AGGREGATO);
		Docente celestino = new Docente("MRSCLS", "Celestino", "Amoroso", RuoloDocente.A_CONTRATTO);
		
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
		Esame s1Fnd = new Esame(fondamenti, nigro, 25, new Date());
		s1.addEsame(s1Fnd);
		Esame s1BD = new Esame(basiDiDati, furfaro, 28, new Date());
		s1.addEsame(s1BD);
		Esame s1So = new Esame(so, celestino, 30, new Date());
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
		
		System.out.println(unical.getCourse().toString());
		System.out.println(unical.getProfessors());
		System.out.println(unical.getSumCfuAllStudent());
		System.out.println(unical.mediaPesataAllStudent());
		System.out.println(unical.simpleCourses());
		System.out.println(unical.studentsFinishedTheirStudies());
		System.out.println(unical.studentsWithOneExame());
		System.out.println(unical.studentsWithoutPassedExam());
		System.out.println(unical.topStudentsForCourse());
		System.out.println(unical.professorsHighestGradeForRole());
		
	}
	
}
