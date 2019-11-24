package com.nttdata.talent.GestioneUniversita;
import java.util.*;

import com.nttdata.talent.GestioneUniversita.Studente;

public class mainProgram {

	public static void main(String[] args) {
//		String codiceFiscale, String nome, String cognome, int idDocente
		Docente verdi = new Docente("SHUAK", "Giovanni", "Verdi",1,   RuoloDocente.A_TEMPO_INDETERMINATO);
		Docente rossi = new Docente("HIHAD", "Luca", "Rossi", 2, RuoloDocente.A_CONTRATTO);
		Docente lilla = new Docente("IOACI", "Ernesto", "Lilla", 3, RuoloDocente.A_PROGETTO);
		Docente levi = new Docente("JIODW", "Carlo", "Levi", 4, RuoloDocente.A_TEMPO_INDETERMINATO);
		Docente sapa = new Docente("JAEIJ", "Armando", "Sapa", 5, RuoloDocente.RICERCATORE);
		System.out.println("\nDOCENTI: ");
		System.out.println(verdi);
		System.out.println(rossi);
		System.out.println(lilla);
		System.out.println(levi);
		System.out.println(sapa);

		
		
		Studente s1 = new Studente("#31", "GHTIKD34JSHE6", "Luca", "Carducci", 'M', "11-2-1997");
		Studente s2 = new Studente("#75", "DHGFYFE765JNU", "Mario", "Rossi" , 'M', "1-1-1987");
		Studente s3 = new Studente("#13", "HYAG674YDTEG8F", "Maria", "Loria", 'F', "23-2-1991");
		Studente s4 = new Studente("#98", "DHGFYFE765JNU", "Debora", "Juston" , 'F', "7-12-1992");
		Studente s5 = new Studente("#55", "L0S98HJFYEGUDHS", "Kevin", "Mitnik" , 'M', "22-8-1989");
		//s1.setPianoDiStudi(corsi)
		System.out.println("\nSTUDENTI: ");
		System.out.println(s1);		
		System.out.println(s2);	
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		
//		int idCorso, int idDocente, int cfu, String nome
		Corso fondamenti = new Corso(1, 1, 13, "Fondamenti Informatica");
		Corso poo2 = new Corso(5, 2, 12, "Analisi 1");
		Corso basiDiDati = new Corso(2, 2, 20, "Analisi 2");
		Corso poo = new Corso(3, 3, 25, "Ing. Informatica");
		Corso so = new Corso(4, 4, 11, "Matematica");
		
		System.out.println("\nCORSO: ");
		System.out.println(fondamenti);
		System.out.println(basiDiDati);
		System.out.println(poo);
		System.out.println(so);
		
		List<Corso> corsi = new LinkedList<Corso>();
		corsi.add(poo2);
		corsi.add(fondamenti);
		corsi.add(basiDiDati);
		corsi.add(poo);
		corsi.add(so);
		
		
		
		
		
		//PianoDiStudio idCorso, Docente codiceDocente, int idEsame, int voto, String dataEsame
		Esame efond = new Esame(fondamenti.getIdCorso(), verdi.getIdDocente(), 10, 30, "21/10/2003", new Date() );
		s1.addEsame(efond);
		Esame ebasiDati = new Esame(basiDiDati.getIdCorso(), rossi.getIdDocente(), 7, 30, "12/09/1999", new Date() );
		s2.addEsame(ebasiDati);
		Esame ePoo = new Esame(poo.getIdCorso(), lilla.getIdDocente(), 2, 30, "1/02/2001", new Date());
		s3.addEsame(ePoo);
		Esame eSo = new Esame(so.getIdCorso(), levi.getIdDocente(), 5, 30, "7/12/2007", new Date());
		s4.addEsame(eSo);
		
		System.out.println("\nESAMI: ");
		System.out.println(efond);
		System.out.println(ebasiDati);
		System.out.println(ePoo);
		System.out.println(eSo);
		
		
		
		 //String matricola,  int anno, int idCorso, Corso c
		PianoDiStudio ps1 = new PianoDiStudio("#31", 2001, fondamenti.getIdCorso(), fondamenti);
		PianoDiStudio ps2 = new PianoDiStudio("#13", 1999, so.getIdCorso(), so);
		PianoDiStudio ps3 = new PianoDiStudio("#98", 1997, basiDiDati.getIdCorso(), basiDiDati);
		PianoDiStudio ps4 = new PianoDiStudio("#55", 9999, poo.getIdCorso(), poo);
		System.out.println("\nPIANO DI STUDI: ");
		System.out.println(ps1);
		System.out.println(ps2);
		System.out.println(ps3);
		System.out.println(ps4);
		

		
		
	}

}
