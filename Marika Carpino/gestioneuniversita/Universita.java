package com.nttdata.talentcamp.gestioneuniversita;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Universita {
	
	private static List<Studente> studenti;
	
	public Universita() {
		Universita.studenti=new LinkedList<Studente>();
	}
	
	
	public void addStudente(Studente studente) {
		studenti.add(studente);
	}
	

	public static List<Studente> getStudenti() {
		return studenti;
	}


	public static void setStudenti(List<Studente> studenti) {
		Universita.studenti = studenti;
	}


	
	

	//restituisce la lista dei corsi a partire dai piani di studio degli studenti
	public static Set<Corso> getListaCorsi(){
		
		Set<Corso> listaCorsi=new HashSet<Corso>();
		
		for(Studente studente: studenti) {
			for(Corso corso: studente.getPianoDiStudio()) {
				listaCorsi.add(corso);
			}
		}
		
		return listaCorsi;
	}

	
	
	
	
	
	
	
	//per ogni studente restituisce il numero di cfu maturati
	public static HashMap<String, Integer> getCfu () {
		HashMap<String, Integer> cfuStudenti =new HashMap<String, Integer>();
		for(Studente studente: studenti) {
			cfuStudenti.put(studente.getMatricola(), getCfuStudente(studente));
		}
		return cfuStudenti;
	}
	
	
	//restituisce cfu maturati da un singolo studente
	private static Integer getCfuStudente(Studente studente) {
		Integer cfu=0;
		for(Esame esame: studente.getEsami()) {
			cfu+=esame.getCorso().getCfu();
		}
		return cfu;
	}



	
	
	
	
	
	//per ogni studente, restituire la media pesata
	public static HashMap<String, Double> getMediaPesata () {
		HashMap<String, Double> mediaPesata =new HashMap<String, Double>();
		for(Studente studente: studenti) {
			mediaPesata.put(studente.getMatricola(), getMediaPesataStudente(studente));
		}
		return mediaPesata;
	}
	
	//per un singolo studente restituisce la media pesata
	private static Double getMediaPesataStudente(Studente studente) {
		int cfuTotaliAcquisiti=getCfuStudente(studente);
		int cfuXvoto=0;
		for(Esame esame: studente.getEsami()) {
			int cfuEsame=esame.getCorso().getCfu();
			int votoEsame=esame.getVoto();
			cfuXvoto+=votoEsame*cfuEsame;
		}
		return (double) cfuXvoto/cfuTotaliAcquisiti;
	}


	
	
	
	
	
	
	
	//per ogni corso gli studenti migliori
	public HashMap<Corso,List< String>> getStudentiMigliori(){
        HashMap<Corso, List<String>> studentiMigliori= new HashMap<Corso, List<String>>();
        
        for (Corso corso :getListaCorsi()) {
              List <String> studentiMiglioriCorso= new LinkedList<String>();
              int votoMax=votoMigliore(corso);
              for (Studente studente: studenti) {
                   if(votoCorsoStudente(studente, corso)==votoMax && votoMax!=0) {
                        studentiMiglioriCorso.add(studente.getMatricola());
                   }
              studentiMigliori.put(corso,studentiMiglioriCorso);
              
              }
        }
        return studentiMigliori;
	}
	
	
	//dato uno studente ed un corso calcolo il voto di esame e se non è sostenuto restituisco 0
    private int votoCorsoStudente (Studente studente, Corso corso) {
         for (Esame esameCurr : studente.getEsami()) {
               if (esameCurr.getCorso().equals(corso)) {
                    
                    return esameCurr.getVoto();
               } 
         }
         return 0;
    }
         
    
    //dato un esame calcolo il voto migliore.Uso corso in modo da considerare anche i corsi che non hanno esami superati associati
    private int votoMigliore(Corso corso) {
         int maxCurrVoto=0;
         for (Studente studente : studenti) {
               if(votoCorsoStudente(studente, corso)>maxCurrVoto) {
                    maxCurrVoto=votoCorsoStudente(studente, corso);
               }
               
         }
         return maxCurrVoto;
    }
	
	
	
	

	
	
	
	
	
	//restituisce gli studenti che hanno sostenuto tutti gli esami del loro piano di studi
	public static List<Studente> studentiEsamiFiniti(){
		List<Studente> studentiEsamiFiniti=new LinkedList<Studente>();
		for(Studente studente : studenti) {
			if(studente.getEsami().size()==studente.getPianoDiStudio().size()) {
				studentiEsamiFiniti.add(studente);
			}
		}
		return studentiEsamiFiniti;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//metodo che restituisce i docenti a partire dai corsi e esami di ciascuno studente
	public static Set<Docenti> getDocenti(){
		Set<Docenti> prof = new HashSet<Docenti>();
		for(Studente studente : studenti) {
			for(Esame esame: studente.getEsami()) {
				prof.add(esame.getDocente());
			}
		}
		for(Studente studente: studenti) {
			for(Corso corso : studente.getPianoDiStudio()) {
				prof.add(corso.getDocente());
			}
		}
		return prof;
	}

	

	//media dei voti dati dai prof 
	private static Double mediaVotiProf(Docenti docente) {
		int voti=0;
		int esamiFatti=0;
		for(Studente studente: studenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getDocente()==docente) {
					voti+=esame.getVoto();
					esamiFatti+=1;
				}
			}
		}
		return (double) voti/esamiFatti;
	}


	//per ogni ruolo, il docente che eroga i voti più alti
	public static HashMap<Ruolo, Docenti> docentiMiglioriPerRuolo(){
		HashMap<Ruolo,Docenti> docentiMigliori =new HashMap<Ruolo,Docenti>();
		Ruolo ruoli[]=Ruolo.values();
		
		for(int i=0; i<ruoli.length; i++) {
			docentiMigliori.put(ruoli[i], profBuono(ruoli[i]));
		}
			
		return docentiMigliori;
	}

	//fissato il ruolo, restituisce il prof più buono
	private static Docenti profBuono(Ruolo ruolo) {
		List<Docenti> docentiRuolo=new LinkedList<Docenti>();
		for(Docenti docente: getDocenti()) {
			if(ruolo==docente.getRuolo()) {
				docentiRuolo.add(docente);
			}
		}
		
		double mediaVoti=0;
		Docenti docenteBuonoCurr=docentiRuolo.get(0);
		for(Docenti docente: docentiRuolo) {
			if(mediaVoti < mediaVotiProf(docente)) {
				docenteBuonoCurr=docente;
			}
		}
		
		return docenteBuonoCurr;
	}		
	
	
	
	
	
	
	
	
	
	//lista corsi per cui nessuno studente ha sostenuto l'esame
	public List<String> esamiNonSostenutiDaNessuno(){
		List<String> esamiNonSostenuti=new LinkedList<String>();
		for(Corso corso: getListaCorsi()) {
			if(!esameSostenuto(corso)) {
				esamiNonSostenuti.add(corso.getDenominazione());
			}
		}
		return esamiNonSostenuti;
	}


	private boolean esameSostenuto(Corso corso) {
		for(Studente studente: studenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getCorso().equals(corso)) {
					return true;
				}
			}
		}
		return false;
	}
	

	
	
	//matricola degli studenti a cui manca esattamente un esame e l'esame mancante. 
	//(Nonostante sappia che mi deve restituire un solo esame, ho messo lista per poter utilizzare il metodo di seguito 
	//che ho creato per un contesto più generale.)
	public static HashMap<String, List<Corso>> studenteEsameMancante(){
		HashMap<String, List<Corso>> studentiMancaUnEsame=new HashMap<String, List<Corso>>();
		
		for(Studente studente: studenti) {
			if(studente.getEsami().size()==(studente.getPianoDiStudio().size()-1)) {
				studentiMancaUnEsame.put(studente.getMatricola(), esameMancante(studente));
			}
		}
		return studentiMancaUnEsame;
	}

	
	
	
	//esami che mancano ad un dato studente
	private static List<Corso> esameMancante(Studente studente) {
		List<Corso> esamiMancanti=new LinkedList<Corso>();
		
		for(Corso corso : studente.getPianoDiStudio()) {
			esamiMancanti.add(corso);
		}
		
		for(Esame esame: studente.getEsami()) {
			esamiMancanti.remove(esame.getCorso());
		}
		
		return esamiMancanti;
	}
	
	
	
	
	
	
	
	
	//la lista dei corsi più semplici, cioè per i quali la media voti è più alta	
	public static List<String> corsiSemplici(){
		List<String> corsiFacili=new LinkedList<String>();
		float maxMediaCorso=0;
		
		for(Corso corso: getListaCorsi()) {
			if(mediaPerCorso(corso)>maxMediaCorso) {
				maxMediaCorso=mediaPerCorso(corso);
			}
		}
		for(Corso corso: getListaCorsi()) {
			if(mediaPerCorso(corso)==maxMediaCorso) {
				corsiFacili.add(corso.getDenominazione());
			}
		}
		
		return corsiFacili;
	}

	
	//restituisce la media dei voti per un corso
	private static float mediaPerCorso(Corso corso) {
		float media=0;
		for(Esame esame: esamiPerCorso(corso)) {
			media+=esame.getVoto();
		}
		return media/esamiPerCorso(corso).size();
	}

	
	//dato un corso, restituisce tutti gli esami relativi a quel corso
	private static List<Esame> esamiPerCorso(Corso corso) {
		List<Esame> esamiCorso= new LinkedList<Esame>();
		
		for(Studente studente: studenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getCorso().equals(corso)) {
					esamiCorso.add(esame);
				}
			}
		}
		return esamiCorso;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
