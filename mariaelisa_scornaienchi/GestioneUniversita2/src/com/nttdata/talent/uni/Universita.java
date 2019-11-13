package com.nttdata.talent.uni;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universita {
	
	private List<Studente> studenti;
	//private List<Esame> esami;
	
	public Universita() {
		super();
		studenti=new LinkedList<Studente>();
	}
	
	public Set<Docente> getDocenti(){
		
		//recupera i docenti a partire dai Corsi e Esami di ciascun studente
		Set<Docente> docenti= new HashSet<Docente>();
		for (Studente studente : studenti) {
			for (Corso c : studente.getPianoDiStudi()) {
				//in realta l if non serve perche è un set non una list
				if (!docenti.contains(c.getDocente())) {
				//if (!giaInserito(docenti, c.getDocente())) {
					docenti.add(c.getDocente());
				}
			}
			for (Esame e : studente.getEsami()) {
				if (!docenti.contains(e.getDocente())) {
				//if (!giaInserito(docenti, e.getDocente())) {
					docenti.add(e.getDocente());
				}
			}	
		}
		return docenti;
	}
	
	public Map<String, Integer> cfuPerStudente(){
		Map<String, Integer> cfuStudente= new HashMap<String, Integer>();
		for (Studente studente : studenti) {
				int somma=0;
				for (int i = 0; i < studente.getEsami().size(); i++) {
					int cfu= studente.getEsami().get(i).getCorso().getCfu();
					somma=somma+cfu;
				}
				cfuStudente.put(studente.getMatricola(), (Integer)somma);
		}
		return cfuStudente;
	}
	
	public Map<String, Double> mediaPesataPerStudente(){
		Map<String, Double> mediaPesata= new HashMap<String, Double>();
		for (Studente studente : studenti) {
				double somma=0;
				int totCfu=0;
				for (int i = 0; i < studente.getEsami().size(); i++) {
					int cfu= studente.getEsami().get(i).getCorso().getCfu();
					int voto=studente.getEsami().get(i).getVoto();
					totCfu=totCfu+cfu;
					somma=somma+(cfu*voto);	
				}
				double media=0;
				if (totCfu!=0) {
					media=somma/totCfu;
					mediaPesata.put(studente.getMatricola(), (Double)media);
				}
		}
		return mediaPesata;
	}
	
	//metodo inutile, è il contains
//	private static boolean giaInserito(Set<Docente> docenti, Docente docente) {
//		for (Docente d : docenti) {
//			if(docente.equals(d))
//				return false;
//		}
//		return true;
//	}
	
	 public void addStudente(Studente s) {
		 if (s!=null && !studenti.contains(s))
			 studenti.add(s);
	 }
	 
	 //studenti che hanno dato tutti gli esami
	 public List<String> studentiBravi(){
		 List<String> listaBravi=new LinkedList<String>();
		 for (Studente studente : studenti) {
			 if (cfuMaturati(studente)==cfuProgrammati(studente))
				 listaBravi.add(studente.getMatricola());	
		}
		return listaBravi;
	 }
	 
	 private int cfuMaturati(Studente s) {
		 int cfu=0;
		 for (Esame e : s.getEsami()) {
			cfu=cfu+e.getCorso().getCfu();
		}
		return cfu;
	 }
	 
	 private int cfuProgrammati(Studente s) {
		 int cfu=0;
		 for (Corso c : s.getPianoDiStudi()) {
			cfu=cfu+c.getCfu();
		}
		return cfu;
	 }

	 //studenti (per corso) con i voti migliori
	 public Map<String, List<String>> studentiMigliori(){
		 
		 Map<String, List<String>> listaMigliori=new HashMap<String, List<String>>();
		 for (Corso c : tuttiCorsi()) {
			 List<String> studentiBravi= new LinkedList<String>();
			 //boolean studenteTrovato=false;
			 for (Studente studente : studenti) {
				 for (Esame e : studente.getEsami()) {
					 if(c.equals(e.getCorso()) && e.getVoto()==votoMigliorePerCorso(c)) {
						 studentiBravi.add(studente.getMatricola());
						 //studenteTrovato=true;
					 }
				 }
			 }
			 listaMigliori.put(c.getDenominazione(), studentiBravi);
//			 if(!studenteTrovato)
//				 listaMigliori.put(c.getDenominazione(), null);
		 }
		 return listaMigliori;

	 }
	 
	 private Set<Corso> tuttiCorsi(){
		 Set<Corso> listaCorsi=new HashSet<Corso>();
		 for (Studente studente : studenti) {
			 for (int i = 0; i < studente.getPianoDiStudi().size(); i++) {
				 //if(!listaCorsi.contains(studente.getPianoDiStudi().get(i)))
					 listaCorsi.add(studente.getPianoDiStudi().get(i));
			 }
		 }
		 return listaCorsi;
	 }
	 
	 private int votoMigliorePerCorso(Corso c) {
		 //boolean corsoPresente=false;
		 int voto=-1;
		 for (Studente studente : studenti) {
			 for (Esame e : studente.getEsami()) {
				 if(c.equals(e.getCorso()) && e.getVoto()>voto) {
					 voto=e.getVoto();
					 //corsoPresente=true;
				 }
			 }
		 }
		 return voto;
	 }
	 
	 public Map<TipologiaRuolo, List<String>> docentiBuoni(){
		 Map<TipologiaRuolo, List<String>> listaDocenti=new HashMap<TipologiaRuolo, List<String>>();
		 for (TipologiaRuolo ruolo : TipologiaRuolo.values()) {
			 List<String> docentiBravi=new LinkedList<String>();
			 for (Docente docente : getDocenti()) {
				 if(mediaVotiPerDocente(docente)==mediaVotiPiuAlta(ruolo) && ruolo.equals(docente.getRuolo()))
					 docentiBravi.add(docente.getNome()+" "+docente.getCognome());
			 }
			 listaDocenti.put(ruolo, docentiBravi);
		 }
		 return listaDocenti;
	 }
	 
	 private double mediaVotiPiuAlta(TipologiaRuolo r) {
		 double mediaCurr=0; 
		 for (Docente docente : getDocenti()) {
			 if (r.equals(docente.getRuolo()) && mediaVotiPerDocente(docente)>mediaCurr) {
				 mediaCurr=mediaVotiPerDocente(docente);
			 }
		 }
		 return mediaCurr;
	 }
	 
	 private double mediaVotiPerDocente(Docente d) {
		 int cnt=0;
		 int voto=0;
		 for (Esame e : tuttiEsami()) {
			 if (d.equals(e.getDocente())) {
				 cnt++;
				 voto=voto+e.getVoto();
			 }
		 }
		 if(cnt!=0)
			 return voto/cnt;
		 return -1;
	 }
	 
	 private List<Esame> tuttiEsami(){
		 List<Esame> listaEsami=new LinkedList<Esame>();
		 for (Studente studente : studenti) {
			 for (int i = 0; i < studente.getEsami().size(); i++) {
				 //if(!listaEsami.contains(studente.getEsami().get(i)))
					 listaEsami.add(studente.getEsami().get(i));
			 }
		 }
		 return listaEsami;
	 }
	 
	 public Set<String> corsiConStudentiCattivi(){
		 Set<String> listaCorsi= new HashSet<String>();
		 for (Corso corso : tuttiCorsi()) {
			 if(!esameSostenutoDaAlmenoQualcuno(corso))
				 listaCorsi.add(corso.getDenominazione());

		 }
		 return listaCorsi;
	 }
	 
	 private boolean esameSostenutoDaAlmenoQualcuno(Corso c) {
		 for (Studente studente : studenti) {
			 for (Esame e : studente.getEsami()) {
				 if(c.equals(e.getCorso()))
					 return true;

			 }

		 }
		 return false;
	 }
	 
	 
	 public List<String> corsiPiuSemplici(){
		 List<String> listaCorsi=new LinkedList<String>();
		 for (Corso c : tuttiCorsi()) {
			 //for (Esame e : tuttiEsami()) {
				 //if(c.equals(e.getCorso()) && mediaPerCorso(c)==mediaPiuAltaPerCorso())
			 	if(mediaPerCorso(c)==mediaPiuAltaPerCorso())
					 listaCorsi.add(c.getDenominazione());
			 //}
		 }
		 return listaCorsi;

	 }
	 
	 private double mediaPerCorso(Corso c) {
		 int voto=0;
		 int cnt=0;
		 for (Esame esame : tuttiEsami()) {
			 if (c.equals(esame.getCorso())) {
				 voto=voto+esame.getVoto();
				 cnt++;
			 }
		 }
		 if(cnt!=0)
			 return voto/cnt; 
		 return -1;
	 }
	 
	 private double mediaPiuAltaPerCorso() {
		 double mediaCurr=0;
		 for (Corso c : tuttiCorsi()) {
			 //for (Esame e : tuttiEsami()) {
				 //if(c.equals(e.getCorso()) && mediaPerCorso(c)>mediaCurr)
			 	if(mediaPerCorso(c)>mediaCurr)
					 mediaCurr=mediaPerCorso(c);
			 //}
		 }
		 return mediaCurr;
	 }
	 
	 //deve restituire l'esame ma gli passo il corso per il toString potabile
	 public Map<String, String> studentiACuiMancaUnEsame(){
		 Map<String, String> listaStudenti= new HashMap<String, String>();
		 for (Studente studente : studenti) {
			if(esamiMancanti(studente).size()==1)
				listaStudenti.put(studente.getMatricola(), esamiMancanti(studente).getFirst().getDenominazione());
		}
		return listaStudenti;
		 
	 }
	 
	 //non lo uso
	 private boolean mancaUnEsame(Studente s) {
		 int cntEsami=0;
		 for (Corso c : s.getPianoDiStudi()) {
			 for (Esame e : s.getEsami()) {
				 if(c.equals(e.getCorso()))
					 cntEsami++;
			 }

		 }
		 if(s.getPianoDiStudi().size()==cntEsami+1)
			 return true;
		 return false;
	 }
	 
	 //non lo uso 
	 private Corso esameMancante(Studente s) {
		 Corso corsoMancante=null;
		 
		 //controllo aggiuntivo che dovrebbe essere inutile,
		 //perchè prima di richiamarlo faccio il controllo per verificare
		 //che effettivamente manca un solo esame
		 if(!mancaUnEsame(s))
			 return null;
		 for (Corso c : s.getPianoDiStudi()) {
			 for (Esame e : s.getEsami()) {
				 if(c.equals(e.getCorso())) {
					 corsoMancante=null;
					 break;
				 }
				 corsoMancante=c;
			 }

		 }
		 return corsoMancante;
		 
	 }
	 
	 private LinkedList<Corso> esamiMancanti(Studente s){
		 LinkedList<Corso> corsiMancanti=new LinkedList<Corso>();
		 for (Corso c : s.getPianoDiStudi()) {
			 boolean trovato=false;
			 for (Esame e : s.getEsami()) {
				 if(c.equals(e.getCorso())) {
					 trovato=true;
					 break;
				 }
			 }
			 if(!trovato)
				 corsiMancanti.add(c); 
		 }
		 return corsiMancanti;
	 }

}
