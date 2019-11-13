package com.talentcamp.universita;
	
	import java.util.Date;
	import java.util.LinkedList;
	import java.util.List;

	public class MainTestUniversita {
		
		        public static void main(String[] args) {
				
				Universita unical = new Universita();
				
				//Studenti
				Studente s1 = new Studente("150430", "LPRNGL", "Angela", "Lopresti");
				Studente s2 = new Studente("150439", "DNSVNC", "Vincenzo", "Denisi");
				Studente s3 = new Studente("150889", "PLLCHR", "Chiara", "Pellegrino");
				Studente s4 = new Studente("151960", "LCRLDA", "Leda", "Lacaria");
				Studente s5 = new Studente("151880", "TLRWTR", "Walter", "Talarico");
				Studente s6 = new Studente("151080", "PLSFRN", "Francesco", "Plastina");
				
				//Docenti
				Docente papa = new Docente("PPALSN", "Alessandro", "Papa", Ruolo.RICERCATORE);
                Docente tassi = new Docente("TSSNRC", "Enrico", "Tassi", Ruolo.A_CONTRATTO);
				Docente veltri = new Docente("VLTPRL", "Pierluigi", "Veltri", Ruolo.A_TEMPO_INDETERMINATO);
				Docente barberi = new Docente("BRBRCC", "Riccardo", "Barberi", Ruolo.A_CONTRATTO);
                Docente digregorio = new Docente("DGRSLV", "Salvatore", "Di Gregorio", Ruolo.A_TEMPO_INDETERMINATO);
                Docente umeton = new Docente("UMTCSR", "Cesare", "Umeton", Ruolo.RICERCATORE);
                Docente carbone = new Docente("CRBVNC", "Vincenzo", "Carbone", Ruolo.A_TEMPO_INDETERMINATO);
				
				//Corsi
				Corso qm = new Corso( "Meccanica Quantistica", "ING/INF",        10, papa);
			    Corso fta = new Corso("Teoria dei Campi A", "ING/INF",            6, papa);
				Corso ftb = new Corso("Teoria dei Campi B", "ING/INF",            6, papa);
                Corso np = new Corso( "Fisica Nucleare e Subnucleare", "ING/INF", 6, tassi);
				Corso gr = new Corso( "Relatività Generale", "ING/INF",           5, veltri);
				Corso sm = new Corso( "Meccanica Statistica", "ING/INF",          5, veltri);
				Corso cm = new Corso( "Meccanica Classica", "ING/INF",           13, barberi);
				Corso acs = new Corso("Informatica Avanzata","ING/INF",           6, digregorio);
                Corso cs = new Corso( "Sistemi Complessi","ING/INF",              6, carbone);
 //             Corso lc = new Corso( "Cristalli Liquidi","ING/INF",              5, umeton);
				
				List<Corso> corsi = new LinkedList<Corso>();
				
				corsi.add(qm);
				corsi.add(fta);
				corsi.add(ftb);
				corsi.add(np);
				corsi.add(gr);
				corsi.add(sm);
				corsi.add(cm);
                corsi.add(cs);
				corsi.add(acs);
				
				//Add corsi to Studenti
				s1.setPianoDiStudi(corsi);
				s2.setPianoDiStudi(corsi);
				s3.setPianoDiStudi(corsi);
				s4.setPianoDiStudi(corsi);
				s5.setPianoDiStudi(corsi);
				s6.setPianoDiStudi(corsi);
				
				//Esami
     			Esame s1Qm = new Esame(qm, papa, 30, new Date());
				s1.addEsame(s1Qm);
				Esame s1Fta = new Esame(fta, papa, 31, new Date());
				s1.addEsame(s1Fta);
				Esame s1Ftb = new Esame(ftb, papa, 31, new Date());
				s1.addEsame(s1Ftb);
				Esame s1Np = new Esame(np, tassi, 31, new Date());
				s1.addEsame(s1Np);
				Esame s1Sm = new Esame(sm, veltri, 30, new Date());
				s1.addEsame(s1Sm);
				Esame s1Gr = new Esame(gr, veltri, 31, new Date());
				s1.addEsame(s1Gr);
				Esame s1Cm = new Esame(cm, barberi, 28, new Date());
				s1.addEsame(s1Cm);
				Esame s1Acs = new Esame(acs, digregorio, 31, new Date());
				s1.addEsame(s1Acs);
				Esame s1Cs = new Esame(cs, carbone, 31, new Date());
				s1.addEsame(s1Cs);
				
				Esame s2Qm = new Esame(qm, papa, 24, new Date());
				s2.addEsame(s2Qm);
				Esame s2Fta = new Esame(fta, papa, 26, new Date());
				s2.addEsame(s2Fta);
				Esame s2Np = new Esame(np, tassi, 22, new Date());
				s2.addEsame(s2Np);
				Esame s2Cm = new Esame(gr, barberi, 25, new Date());
				s2.addEsame(s2Cm);
				Esame s2Acs = new Esame(gr, digregorio, 25, new Date());
				s2.addEsame(s2Acs);
				
				Esame s3Qm = new Esame(qm, papa, 25, new Date());
				s3.addEsame(s3Qm);
				Esame s3Np = new Esame(np, tassi, 30, new Date());
				s3.addEsame(s3Np);
				Esame s3Sm = new Esame(sm, veltri, 26, new Date());
				s3.addEsame(s3Sm);
				Esame s3Cm = new Esame(gr, barberi, 27, new Date());
				s3.addEsame(s3Cm);
				Esame s3Acs = new Esame(gr, digregorio, 21, new Date());
				s3.addEsame(s3Acs);
				
				Esame s4Qm = new Esame(qm, papa, 26, new Date());
				s4.addEsame(s4Qm);
				Esame s4Fta = new Esame(fta, papa, 24, new Date());
				s4.addEsame(s4Fta);
				Esame s4Ftb = new Esame(ftb, papa, 24, new Date());
				s4.addEsame(s4Ftb);
				Esame s4Np = new Esame(np, tassi, 30, new Date());
				s4.addEsame(s4Np);
                Esame s4Sm = new Esame(sm, veltri, 20, new Date());
				s4.addEsame(s4Sm);
				Esame s4Gr = new Esame(gr, veltri, 18, new Date());
				s4.addEsame(s4Gr);
				Esame s4Cm = new Esame(cm, barberi, 31, new Date());
				s4.addEsame(s4Cm);
				Esame s4Acs = new Esame(acs, digregorio, 31, new Date());
				s4.addEsame(s4Acs);
				
				Esame s5Qm = new Esame(qm, papa, 28, new Date());
				s5.addEsame(s5Qm);
				Esame s5Fta = new Esame(fta, papa, 31, new Date());
				s5.addEsame(s5Fta);
				Esame s5Ftb = new Esame(ftb, papa, 31, new Date());
				s5.addEsame(s5Ftb);
				Esame s5Np = new Esame(np, tassi, 30, new Date());
				s5.addEsame(s5Np);
                Esame s5Sm = new Esame(sm, veltri, 30, new Date());
				s5.addEsame(s5Sm);
				Esame s5Gr = new Esame(gr, veltri, 27, new Date());
				s5.addEsame(s5Gr);
				Esame s5Cm = new Esame(cm, barberi, 31, new Date());
				s5.addEsame(s5Cm);
				Esame s5Cs = new Esame(cs, carbone, 18, new Date());
				s5.addEsame(s5Cs);
				
				//Aggiunta studenti
				unical.addStudente(s1);
				unical.addStudente(s2);
				unical.addStudente(s3);
				unical.addStudente(s4);
				unical.addStudente(s5);
				unical.addStudente(s6);

				System.out.println("Cfu Maturati da ciascuno studente (matricola): ");
				System.out.println();
				System.out.println(unical.getNumCfuPerOgniStudente());
				System.out.println();
				
				System.out.println("Media pesata sui Cfu di ciascuno studente (matricola): ");
				System.out.println();
     			System.out.println(unical.getMediaPesataPerOgniStudente());
    			System.out.println();
    			
    			System.out.println("Gli studenti che hanno completato il proprio piano di studi: ");
				System.out.println();
    			System.out.println(unical.getStudentiCheHannoCompletatoPianoDiStudi());
				System.out.println();
				
				System.out.println("Gli studenti migliori per ogni corso: ");
				System.out.println();
				System.out.println(unical.getStudentiMiglioriPerOgniCorso());
				System.out.println();
				
				System.out.println("I corsi per i quali nessuo studente ha ancora superato l'esame: ");
				System.out.println();
				System.out.println(unical.getCorsiNessunEsame());
				System.out.println();
				
				System.out.println("I corsi per i quali gli studenti hanno portato a casa i voti piu' alti in media: ");
				System.out.println();
				System.out.println(unical.getCorsiFacili());
				System.out.println();
				
				System.out.println("Gli studenti a cui manca un solo esame per completare il proprio piano di studi: ");
				System.out.println();
				System.out.println(unical.getStudentiConUnSoloEsameMancante());
				System.out.println();
				
				System.out.println("I docenti che in media (pesata) hanno erogato i voti più alti classificati per ruolo: ");
				System.out.println();
				System.out.println(unical.getMappaProfBuoni());
				System.out.println();
				
			}

}
