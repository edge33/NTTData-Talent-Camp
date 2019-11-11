package com.nttdata.talent.universita;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universita {
	private List<Studente> listaStudenti;


	public Universita() {
		this.listaStudenti=new LinkedList<Studente>();
	}

	

	public void addStudente(Studente studente) {
		if(!listaStudenti.contains(studente)){
			listaStudenti.add(studente);	
		}
		
	}	
//per ogni studente il numero di cfu maturati
	public Map<String,Integer> studentiCfuMaturati(){
		Map<String, Integer> studentiCrediti =new HashMap<String, Integer>(); 
		for (Studente studente : listaStudenti) {
			studentiCrediti.put(studente.getMatricola(), cfuAcquisiti(studente) );
		}
		return studentiCrediti;
	}
	
	private int cfuAcquisiti(Studente studente) {
		int numCfu=0;
		for (Esame esame : studente.getEsamiSostenuti()) {
			numCfu+=esame.getCorso().getCfu();
		}
		return numCfu;
	}
	
	
	
	//per ogni studente la sua media pesata dei voti
	public Map<String,Double> studentiMedia(){
		Map<String, Double> studentiMedia =new HashMap<String, Double>(); 
		for (Studente studente : listaStudenti) {
			studentiMedia.put(studente.getMatricola(), calcolaMediaStudente(studente) );
		}
		return studentiMedia;
	}
	
	
	private double calcolaMediaStudente(Studente studente) {
		double numeratoreMedia=0;
		for (Esame esame : studente.getEsamiSostenuti()) {
			
			numeratoreMedia+=esame.getVoto()*esame.getCorso().getCfu();
		}
		return numeratoreMedia/cfuAcquisiti(studente);
	}

 
//lista dei corsi più semplici
	public List<Corso> corsiSemplici (){
		double massimoMedia= calcolaMaxMediaCorso();
		List <Corso> corsiSemplici= new LinkedList<Corso>();
		for (Corso corso : getListaCorsi()) {
			if(calcolaMediaCorso(corso)== massimoMedia) {
				corsiSemplici.add(corso);
			}
		}
		return corsiSemplici;
	
	}

	
	
	public double calcolaMediaCorso(Corso corso) {
		 double mediaCorso=0;
		 int countEs=0;
		 for (Esame esame: getListaEsami()) {
			 if (esame.getCorso().equals(corso)) {
				 ++countEs;
				 mediaCorso+=esame.getVoto();
			 }
		 }
		 return mediaCorso/countEs;
	 }
	 private double calcolaMaxMediaCorso() {
		 double mediaMax=0;
		 for (Corso corso : getListaCorsi()) {
			 if(calcolaMediaCorso(corso)>mediaMax) {
				 mediaMax=calcolaMediaCorso(corso);
			 }
		 }
		 return mediaMax;
	 }
//per ogni corso gli studenti con i migliori voti
	public Map<Corso,List< Studente>> getStudentiMigliori(){
		Map<Corso, List<Studente>> studentiMigliori= new HashMap<>();
		Set<Corso> listaCorsi= getListaCorsi();
		for (Corso corso :listaCorsi) {
			List <Studente> studentiMiglioriCorso= new LinkedList<Studente>();
			int votoMax=votoMigliore(corso);
			for (Studente studente: listaStudenti) {
				if(votoCorsoStudente(studente, corso)==votoMax && votoMax!=0) {
					studentiMiglioriCorso.add(studente);
				}
			studentiMigliori.put(corso,studentiMiglioriCorso);
			
			}
		}
		return studentiMigliori;
	}
		
	//dato uno studente ed un corso calcolo il voto di esame e se non è sostenuto restituisco 0
	private int votoCorsoStudente (Studente studente, Corso corso) {
		for (Esame esameCurr : studente.getEsamiSostenuti()) {
			if (esameCurr.getCorso().equals(corso)) {
				
				return esameCurr.getVoto();
			}
			
		}
		
		return 0;
	
	}
		
	
	//dato un esame calcolo il voto migliore.Uso corso in modo da considerare anche i corsi che non hanno esami superati associati
	private int votoMigliore(Corso corso) {
		int maxCurrVoto=0;
		for (Studente studente : listaStudenti) {
			if(votoCorsoStudente(studente, corso)>maxCurrVoto) {
				maxCurrVoto=votoCorsoStudente(studente, corso);
			}
			
		}
		return maxCurrVoto;
	}
	
	
	
	//lista corsi dell'università
	private Set<Corso> getListaCorsi(){
		Set<Corso> listaCorsi=new HashSet<Corso>();
		for (Studente studente: listaStudenti) {
			for (Corso corso:studente.getPianoStudi()) {
				listaCorsi.add(corso);
			}
		}
		return listaCorsi;
	}

	//lista esami 
	private List<Esame> getListaEsami() {
		List<Esame> listaEsami=new LinkedList<Esame>();
		for (Studente studente: listaStudenti) {
			for(Esame esame: studente.getEsamiSostenuti()) {
				listaEsami.add(esame);
			}
		}
		return listaEsami;
	}
	
	public List<Corso> corsiEsamiMaiSostenuti(){
		List <Corso> corsiMaiSostenuti= new LinkedList<Corso>(); 
		for (Corso corso : getListaCorsi()) {
			boolean esisteEsame=false;
			for (Esame esame : getListaEsami()) {
				if(corso.equals(esame.getCorso())) {
					esisteEsame=true;
					break;
				}
			}
			if (!esisteEsame) {
				corsiMaiSostenuti.add(corso);
			}
			
		}
		return corsiMaiSostenuti;
	}
	
	//calcolo il totale dei cfu dato un piano di studi 
	private int totaleCfuPianoStudi(Studente studente) {
		int totCfu=0;
		for (Corso corso: studente.getPianoStudi()) {
			totCfu+=corso.getCfu();
		}
		return totCfu;
	}
	
	
	//elenco degli studenti che hanno sostenuto tutti gli esami
	public List<Studente> studentiTuttiEsamiSostenuti(){
		
		List<Studente>studentiEsamiFiniti= new LinkedList<Studente>(); 
		
		for (Studente studente : listaStudenti) {
			
			if(totaleCfuPianoStudi(studente)==cfuAcquisiti(studente)) {
				
				studentiEsamiFiniti.add(studente);
			}
		}
		return studentiEsamiFiniti;
	}
	
	//Lista docenti dell'università
	private Set<Docente> getListaDocenti (){
		Set<Docente> listaDocenti=new HashSet<Docente>();
		for (Studente studente : listaStudenti) {
			for (Corso corso:studente.getPianoStudi()) {
				listaDocenti.add(corso.getDocente());
			}
		}
		return listaDocenti;
	
	}
	
	
	
	
	
	//lista degli esami per ogni docente
	private List<Esame> esamiPerDocente(Docente docente){
		List <Esame> esamiDocente= new LinkedList<Esame>();
		for (Studente studente : listaStudenti) {
			for (Esame esame : studente.getEsamiSostenuti()) {
				if (esame.getDocente().equals(docente)) {
					esamiDocente.add(esame);
				}
			}
			
		}
		return esamiDocente;
	}
	//media dei voti per docente
	private double mediaVotiDocente(Docente docente) {
		double media=0;
		for(Esame esame : esamiPerDocente(docente)) {
			media+=esame.getVoto();
		}
		return media/esamiPerDocente(docente).size();
	}
	
	//per ogni ruolo il docente che eroga la media voti più alta
	public Map<RuoloDocente,List<Docente>> docentiMediaMigliore(){
		Map<RuoloDocente, List<Docente>> docentiMigliori= new HashMap<RuoloDocente, List<Docente>>();
		for (RuoloDocente ruolo : RuoloDocente.values()) {
			LinkedList<Docente> docentiPerCategoria=costruisciListaDocenti(getListaDocenti(),ruolo);
			docentiMigliori.put(ruolo,maxMediaVotiDocenti(docentiPerCategoria));
		}
		return docentiMigliori;
	}


//calcolo il massimo della media dei voti dati per una lista di docenti. Se ci sono docenti con la stessa media li restituisco entrambi
	private List<Docente> maxMediaVotiDocenti(LinkedList<Docente> docentiPerCategoria) {
		List <Docente> docentiMedMax=new LinkedList<Docente>();
		Docente docMaxCorrente= docentiPerCategoria.getFirst();
		for (Docente docente : docentiPerCategoria) {
			if(mediaVotiDocente(docente)>mediaVotiDocente(docMaxCorrente)) {
				docMaxCorrente=docente;
				docentiMedMax.clear();
				docentiMedMax.add(docente);
			}else if(mediaVotiDocente(docente)==mediaVotiDocente(docMaxCorrente)) {
				docentiMedMax.add(docente);
			}
		}
		return docentiMedMax;
		
	}

	//docenti per categoria 

	private LinkedList<Docente> costruisciListaDocenti(Set<Docente> listaDocenti, RuoloDocente ruolo) {
		LinkedList<Docente> listaDaRestituire= new LinkedList<Docente>();
		for (Docente docente :listaDocenti) {
			if (docente.getRuolo()==ruolo) {
				listaDaRestituire.add(docente);
			}
		}
		return listaDaRestituire;
		
	}
	public Map<String,Corso> studentiUnicoEsameMancante (){
		Map <String, Corso> studentiUnicoEsame= new HashMap<String, Corso>();
		for (Studente studente : listaStudenti) {
			if(mancaUno(studente)) {
				studentiUnicoEsame.put(studente.getMatricola(),corsoMancante(studente));
			}
		}
		return studentiUnicoEsame;
		
	}



	private Corso corsoMancante(Studente studente) {
		for (Corso corso: studente.getPianoStudi() ) {
			boolean trovato=false;
			for(Esame esame : studente.getEsamiSostenuti()) {
				if (esame.getCorso().equals(corso)) {
					trovato=true;
					break;
				}
			}
			if (!trovato) {
				return corso;
			}
		}
		return null;
	}



	private boolean mancaUno(Studente studente) {
		return (studente.getPianoStudi().size()==studente.getEsamiSostenuti().size()+1); 
	}
	
	
	
}
