package nttdata.talentcamp.universita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universita {
	
	private List <Studente> elencoStudenti;
	

	public void addStudente(Studente s1) {
		if(!elencoStudenti.contains(s1)) {
			elencoStudenti.add(s1);
		}
	}
	

	public int sommaCfu (Studente s) {
		int somma=0;
		for(Esame esameCurr: s.getEsami()) {
			somma+=esameCurr.getCorso().getCfu();
		}
		return somma;
	}
	
	public Map<Studente, Integer> numCfu () {
		Map <Studente, Integer> mappaStudenti = new HashMap<Studente, Integer>();

		for(Studente studente : elencoStudenti) {
			mappaStudenti.put(studente, sommaCfu(studente));
			
		}
		
		return mappaStudenti;		
	}
	
	public double calcolaMedia (Studente s) {
		double  media= 1;
		double mediaTot=0;
		
		for(Esame esameCurr : s.getEsami()) {
			int voto= esameCurr.getVoto();
			int cfu= esameCurr.getCorso().getCfu();
			media= voto*cfu;
			mediaTot+=media;
		} return mediaTot/sommaCfu(s);
	}
	
	public Map<Studente, Double> mediaPonderataTotale(){
		Map <Studente, Double> mappaStudenti2 = new HashMap<Studente, Double>();
		for(Studente studente:elencoStudenti) {
			mappaStudenti2.put(studente,calcolaMedia(studente));
		} return mappaStudenti2;
		
		
	}
	
	public Set<Corso> listaCorsi (){ //il Set è una lista ma con valori non ripetuti
		Set<Corso> corsi = new HashSet<Corso>();
		for(Studente studente: elencoStudenti) {
//			for(Corso corso: studente.getPianoDiStudio()) invece di fare il for in questo caso, dato che mi servono tutti gli oggetti della collection, posso usare il metodo addAll
//			corsi.add(corso);
			corsi.addAll(studente.getPianoDiStudio());
		} return corsi;
	}
	
	
	public Map<Corso, List <Studente>>  studentiConVotiMigliori (){
		Set<Corso> corsi =listaCorsi();
		Map<Corso, List <Studente>> mappaStudentiMigliori= new HashMap<Corso, List<Studente>>();
		for(Corso corso:listaCorsi()) {
			mappaStudentiMigliori.put(corso, calcolaStudentiMigliori(corso));
			
		}return mappaStudentiMigliori;
		
	}
	
	
	private List<Studente> calcolaStudentiMigliori(Corso corso) {
		List <Studente> studenti = new LinkedList<Studente>();
		for(Studente studente: elencoStudenti) {
			for(Esame esame:studente.getEsami()) {
				if(esame.getCorso().equals(corso) && votoMax(corso) == esame.getVoto()) {
					studenti.add(studente);
				}
			}

		}
		return studenti;
	}


	private int votoMax(Corso corso) {
		int votoMigliore=0;
		for(Studente studente:elencoStudenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getCorso().equals(corso) && esame.getVoto()>votoMigliore) {
					votoMigliore=esame.getVoto();
				}
			}
		}

		return votoMigliore;
	}

	//Elenco degli studenti che hanno sostenuto tutti gli esami del loro piano di studi
	public List<Studente> studentiConEsamiCompletati(){
		List <Studente> studenti = new LinkedList<Studente>();
		for(Studente studente:elencoStudenti) {
			if(studente.getPianoDiStudio().size()==studente.getEsami().size()){
				studenti.add(studente);
			}
		}return studenti;
	}
	
	
	
	//Per ogni ruolo il docente che mediamente eroga voti più alti(all’uscita avrò una mappa, ruolo +  docente)
	public Map<RuoloDocente, List<Docente>> docenteConVotipiuAlti (){
		Map <RuoloDocente, List<Docente>>  mappaDocenti= new HashMap <RuoloDocente, List<Docente>> ();
		 for(RuoloDocente ruolo: RuoloDocente.values()) {
			 mappaDocenti.put(ruolo, docenteBuono(ruolo));
		 } return mappaDocenti;
		
	}

	private List<Docente> docenteBuono (Enum<RuoloDocente> ruolo) { //gli passo un ruolo e mi restituisce il docente con la media dei voti + alta per quel ruolo
		List<Docente> docentiOk = new LinkedList<Docente>();
		Set<Docente> docenti=getDocenti();
		double mediaMax=0;
		for(Docente docente:docenti) {
			if(docente.getRuolo()==ruolo && mediaVotiDocente(docente)>mediaMax) {
				mediaMax=mediaVotiDocente(docente);
				docentiOk.add(docente);
			}
		}return docentiOk;
	}
	
	
	//mi calcolo la media dei voti per gli esami erogati da un docente
	private double mediaVotiDocente(Docente docente) {
		double media=0;
		for(Esame esame: esamiPerDocente(docente)) {
			media+= esame.getVoto();
		} return media/esamiPerDocente(docente).size();	
		
	}
	
	//elenco degli esami per ogni docente 
	private List<Esame> esamiPerDocente (Docente doc){
		List <Esame> esami = new LinkedList<Esame>();
		for(Studente studente:elencoStudenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getDocente().equals(doc)) {
					esami.add(esame);
				}
			}
		}return esami;
	}
	
	

	private Set<Docente> getDocenti(){ //elenco dei docenti a partire dagli esami di ciascun studente
		Set<Docente> docenti = new HashSet<Docente>();
		for(Studente studente:elencoStudenti) {
			for(Esame esame:studente.getEsami()) {
				docenti.add(esame.getDocente());
			}
			
		}return docenti;
	}
	
	//La lista dei corsi per i quali nessuno studente ha sostenuto l’esame
	public List<Corso> corsiNonSostenuti (){
		List<Corso> corsi = new ArrayList<Corso>();
		for(Corso corso: listaCorsi()) {
			if(!corsoIsEsame(corso)) {
				corsi.add(corso);
			}
		} return corsi;
	}
	 //dato un corso restituisce true se questo è in esami 
	private boolean corsoIsEsame (Corso c) {
		for(Studente studente: elencoStudenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getCorso().equals(c)) {
				 return true;	
				}
			}
		}return false;
	}
	//Il corso più semplice, ovvero per i quali la media voto è la più alta
	public List <Corso> corsiSemplici (){
	List<Corso> corsi = new ArrayList<Corso>();
		for(Corso corso: listaCorsi()) {
			if(mediaPiuAltaPerCorso(corso)){
				corsi.add(corso);
			}
		}return corsi;
	}
	
	//dato un corso mi restituise true se ha la media dei voti + alta
	private boolean mediaPiuAltaPerCorso (Corso c) {
		double mediaCurr = mediaPerCorso(c);
		for(Corso corso:listaCorsi()) {
			if(mediaPerCorso(corso)>mediaCurr) {
				return false;
			}
		}return true;
	}
	
	

	public double mediaPerCorso (Corso c) {
		double media=0;
		for(Esame esame: esamiSostenutiPerCorso(c)) {
			media+=esame.getVoto();
		}return media/esamiSostenutiPerCorso(c).size();
		
		
	}
	
	//per un corso gli esami che sono stati sostenuti
	public List<Esame> esamiSostenutiPerCorso (Corso corso){
		List <Esame> esamiPerCorso = new LinkedList<Esame>();
		for(Studente studente: elencoStudenti) {
			for(Esame esame: studente.getEsami()) {
				if(esame.getCorso().equals(corso)) {
					esamiPerCorso.add(esame);
				}
			}
		}return esamiPerCorso;
	}

	
	
	public Universita() {
		elencoStudenti = new LinkedList<>();
	}


	public List<Studente> getElencoStudenti() {
		return elencoStudenti;
	}


	public void setElencoStudenti(List<Studente>elencoStudenti) {
		this.elencoStudenti = elencoStudenti;
	}

	@Override
	public String toString() {
		return "Universita [elencoStudenti=" + elencoStudenti + "]";
	}

	



	
	
	
	

}
