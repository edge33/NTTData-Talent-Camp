package nttdata.talentcamp.universita;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
		Universita unical = new Universita();
		
		//Studenti
		Studente s1 = new Studente("RSSMRO", "Mario", "Rossi", 1);
		Studente s2 = new Studente("VRDGSP", "Giuseppe", "Verdi", 2);
		Studente s3 = new Studente( "BNCCLR", "Carlo", "Bianchi", 3);
		Studente s4 = new Studente("SPSGNN", "Gennaro", "Esposito", 4);
		
		//Docenti
		Docente nigro = new Docente("NGRLBR", "Libero", "Nigro", RuoloDocente.TEMPO_INDETERMINATO);
		Docente maida = new Docente("MDAFRN", "Francesco", "Maida", RuoloDocente.CONTRATTO);
		Docente furfaro = new Docente("FRFFLP", "Filippo", "Furfaro", RuoloDocente.RICERCATORE);
		Docente celestino = new Docente("MRSCLS", "Celestino", "Amoroso", RuoloDocente.CONTRATTO);
		
		//Corsi
		Corso fondamenti = new Corso(nigro, "Fondamenti di Informatica", 5, "ING/INF" );
		Corso basiDiDati = new Corso(furfaro, "Basi di Dati", 7,  "ING/INF");
		Corso poo = new Corso(maida, "POO",10,  "ING/INF" );
		Corso so = new Corso(celestino, "Sistemi Operativi", 10,"ING/INF");
		
		List<Corso> corsi = new LinkedList<Corso>();
		corsi.add(fondamenti);
		corsi.add(basiDiDati);
		corsi.add(poo);
		corsi.add(so);
		
		//Add corsi to Studenti
		s1.setPianoDiStudio(corsi);
		s2.setPianoDiStudio(corsi);
		s3.setPianoDiStudio(corsi);
		s4.setPianoDiStudio(corsi);
		
		//Esami
		Esame s1Poo = new Esame(poo, maida, 28);
		s1.addEsame(s1Poo);
		Esame s1Fnd = new Esame(fondamenti, nigro, 25);
		s1.addEsame(s1Fnd);
		Esame s1Bd= new Esame(basiDiDati, nigro, 20);
		s1.addEsame(s1Bd);
		Esame s1So= new Esame(so, celestino, 18);
		s1.addEsame(s1So);
		
		
		Esame s2BD = new Esame(basiDiDati, furfaro, 18);
		s2.addEsame(s2BD);
		
		Esame s3Poo = new Esame(poo, maida, 18);
		s3.addEsame(s3Poo);
		
		Esame s4So = new Esame(so, celestino, 25);
		s4.addEsame(s4So);
		

		
		//Aggiunta studenti
		unical.addStudente(s1);
		unical.addStudente(s2);
		unical.addStudente(s3);
		unical.addStudente(s4);
		
		
		
		
		System.out.println("Il numero di crediti per ogni studente è: " + unical.numCfu());
		System.out.println("La media ponderata per ogni studente è : " + unical.mediaPonderataTotale());
		System.out.println(unical.studentiConVotiMigliori());
		System.out.println(unical.studentiConEsamiCompletati());
		System.out.println(unical.docenteConVotipiuAlti());
		System.out.println(unical.corsiNonSostenuti());
		System.out.println(unical.mediaPerCorso(so));
		System.out.println(unical.mediaPerCorso(poo));
		System.out.println(unical.mediaPerCorso(basiDiDati));
		System.out.println(unical.mediaPerCorso(fondamenti));
		System.out.println(unical.corsiSemplici());
		
	
		
	}
	
}
