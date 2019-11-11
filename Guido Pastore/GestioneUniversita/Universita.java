package com.nttdata.talent.Università;

import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universita {
	
	private List <Studente> studenti;
	private List <Corso> corsi;

	public Universita() {
		super();
		this.studenti = new LinkedList <>();
		this.corsi = new LinkedList <>();
	}

	public void addStudente(Studente s) {
		studenti.add(s);
	}

//Per ogni Studente il numero di CFU maturati
public Map<String, Integer> getCfuPerOgniStudente() {
	
	int cfuMaturati;
	String cognomeStudente;
	Map<String, Integer> cfuPerOgniStudente = new HashMap<String,Integer>();
	
	for(Studente studente: studenti) {
		cognomeStudente=studente.getCognome();
		cfuMaturati=studente.getSommaCfu();
		cfuPerOgniStudente.put(cognomeStudente, cfuMaturati);
	}
	
	return cfuPerOgniStudente;
}

//Per ogni Studente, la sua media pesata
public Map<String, Double> getMediaPesataPerOgniStudente() {
	
	double mediaPesata=0;
	String cognomeStudente;
	Map<String, Double> mediaPesataPerOgniStudente = new HashMap<String,Double>();

	for(Studente studente: studenti) {
		cognomeStudente=studente.getCognome();
		mediaPesata=studente.getMediaPesata();
		mediaPesataPerOgniStudente.put(cognomeStudente, mediaPesata);
	}
	return mediaPesataPerOgniStudente;
}

//Elenco degli studenti che hanno sostenuto tutti gli esami del loro piano di studi
public LinkedList<Studente> elencoStudentiEsamiSuperati(){
	LinkedList<Studente> elencoStudenti = new LinkedList<>();
	for(Studente studenteCurr : studenti) {
			if(studenteCurr.getEsami().size() == studenteCurr.getPianoDiStudi().size()) {
				elencoStudenti.add(studenteCurr);
			}	
	}
	return elencoStudenti;
}

////------------START Per ogni Corso gli studenti con i migliori voti-----------------
//VOTO PIU ALTO
public int votoPiùAlto(Corso c) {
	int maxVoto = 0;
		for(Studente studenteCurr : studenti) {
			for(Esame esameCurr : studenteCurr.getEsami()) {
				if(esameCurr.getCorso().equals(c) && esameCurr.getVoto()>maxVoto) {
					maxVoto = esameCurr.getVoto();
				}
			}
		}
	return maxVoto;
}

//RESTITUIRE LO STUDENTE MIGLIORE
public LinkedList<Studente> studenteMigliore(Corso c){
	LinkedList<Studente> studentiCorrenti = new LinkedList<>();
       for(Studente studenteCurr : studenti) {
	      for(Esame esameCurr : studenteCurr.getEsami()) {
		   if(esameCurr.getCorso().equals(corsi) && esameCurr.getVoto()==votoPiùAlto(c)) {
			   studentiCorrenti.add(studenteCurr);
		   }
	}
}
       return studentiCorrenti;
}    

public Set<Corso> calcolareCorsi(){
	Set<Corso> corsoCurr = new HashSet<Corso>();
	for(Studente studenteCurr : studenti) {
				corsoCurr.addAll(studenteCurr.getPianoDiStudi());				
		}
	return corsoCurr;
	}

public Map<Corso, LinkedList<Studente>> miglioriStudenti(){
	   Set<Corso> corsi = calcolareCorsi();
	   Map<Corso, LinkedList<Studente>> studentiMigliori = new HashMap<>();
	   for(Corso corso : corsi) {
	   studentiMigliori.put(corso, studenteMigliore(corso));
	   }
	   return studentiMigliori;
}
//------------END Per ogni Corso gli studenti con i migliori voti-----------------


////-------------START Per ogni Ruolo, il docente che mediamente eroga i voti più alti
public Set<Ruolo> definireRuolo(){
	Set<Ruolo> ruolo = new HashSet<Ruolo>();
	LinkedList<Docente> docenti = creaListaDocenti();
	for(Docente docente : docenti) {
		ruolo.add(docente.getRuolo());				
		}
	return ruolo;
	}


public LinkedList<Docente> creaListaDocenti(){
	LinkedList<Docente> docenti = new LinkedList<Docente>();
	for(Studente studente : studenti) {
	for(Esame esame : studente.getEsami()) {
		if(!docenti.contains(esame.getDocente()) && esame.getVoto()==votoMediamentePiùAlto(esame.getDocente())) {
			docenti.add(esame.getDocente());
		}
	}
	}
	return docenti;
}

public int votoMediamentePiùAlto(Docente d) {
	int voto = 0;
	int mediaVoto = 0;
	for(Studente studente : studenti) {	
	for(Esame esame : studente.getEsami()) {
		if(esame.getDocente().equals(d)) {
			voto += esame.getVoto();
		}
		mediaVoto=voto/studente.getEsami().size();
	}
	}
	return mediaVoto;
}

public Map<Ruolo, LinkedList<Docente>> docentiBuoni(){
	   Set<Ruolo> ruoli = definireRuolo();
	   Map<Ruolo, LinkedList<Docente>> buoniDocenti = new HashMap<>();
	   for(Ruolo ruolo : ruoli) {
		   buoniDocenti.put(ruolo, creaListaDocenti());
	   }
	   return buoniDocenti;
}
//-------------END Per ogni Ruolo, il docente che mediamente eroga i voti più alti

//La lista dei corsi per i quali nessuno studente ha sostenuto l’esame
public LinkedList<Corso> esamiNonSostenuti(Studente s){
	LinkedList<Corso> corsi = new LinkedList<>();
	for(Studente studente : studenti) {
		for(Esame esame : studente.getEsami()) {
			if(!s.getEsami().contains(esame)) {
				corsi.add(esame.getCorso());
			}
		}
	}
	return corsi;
}

//La lista dei corsi più semplici, ovvero per i quali la media voto è la più alta
public double mediaVotiCorso(List <Esame> esami) {
	int sommaVoti = 0;
	double media = 0;
	for(Esame esame : esami) {
		sommaVoti += esame.getVoto();
	}
	if(esami.size()!=0) {
		media = sommaVoti/esami.size();
	}
	return media;
}

public double calcoloMediaVotoCorso(Corso c) {
	List<Esame> esamiCorso = new LinkedList<Esame>();
	for(Studente studente : studenti) {
		for(Esame esame : studente.getEsami()) {
			if(esame.getCorso().equals(c)) {
				esamiCorso.add(esame);
			}
		}
	}
	double media = mediaVotiCorso(esamiCorso);
	return media;
}

public boolean maxMediaCorso (Corso c) {
	double mediaCurr = calcoloMediaVotoCorso(c);
	for(Studente studente : studenti) {
		for(Corso corso : studente.getPianoDiStudi()) {
			if(calcoloMediaVotoCorso(corso) > mediaCurr) {
				return false;
			}
		}
	}
	return true;
}

public List<Corso> corsiSemplici(){
	List<Corso> corsi = new LinkedList<Corso>();
	for(Studente studente : studenti) {
		for(Corso corso : studente.getPianoDiStudi()) {
			if(maxMediaCorso(corso)) {
				corsi.add(corso);
			}
		}
	}
	return corsi;
}


//Le matricole degli studenti a cui manca esattamente un esame, e l’esame mancante
public boolean esameSuperato(Corso c) {
	boolean check = true;
	for(Studente studente : studenti) {
		for(Esame esame : studente.getEsami()) {
			if(!esame.getCorso().equals(c)) {
				check = false;
			}if(check == true) {
				return false;
			}
			check = true;
		}
	}
	return false;
}

public LinkedList <Corso> ultimoEsame(Studente stud){
	LinkedList<Corso> corsoCurr = new LinkedList <Corso>();
	if(!elencoStudentiEsamiSuperati().contains(stud)) {
		for(Corso corso : stud.getPianoDiStudi()) {
			if(!esameSuperato(corso)) {
				corsoCurr.add(corso);
			}
		}
	}
	return corsoCurr;
}


public Map<String, Corso> matricoleConEsameMancante(){
	 Map<String, Corso> neoLaureandi = new HashMap<>();
	 for(Studente studente : studenti) {
		 if(!ultimoEsame(studente).isEmpty() && ultimoEsame(studente).size() == 1) {
			 neoLaureandi.put(studente.getMatricola(), ultimoEsame(studente).get(0));
		 }
	 }
	 return neoLaureandi;
}

}





