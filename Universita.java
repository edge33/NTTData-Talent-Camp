package com.talentcamp.universita;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universita {
	
	public List<Studente> studenti;
	
	public Universita() {
		super();
		studenti = new LinkedList<>();	
	}
	
	public void addStudente(Studente studente) {
		studenti.add(studente);
	}
	
	public Map<String, Integer> getNumCfuPerOgniStudente()
	{
		int cfuMaturati = 0;

		Map <String, Integer> numCfuPerOgniStudente = new HashMap<String, Integer>();
			
		for(Studente studente: studenti)
		{ 
			String matr = studente.getMatricola();
            cfuMaturati = calcolaNumCfu(studente);

            numCfuPerOgniStudente.put(matr, cfuMaturati);
		}
		
		return numCfuPerOgniStudente;		
	}
	
	public Map<String, Double> getMediaPesataPerOgniStudente ()
	{
		double mediaPesata = 0.;
		
		Map <String, Double> mediaPesataPerOgniStudente = new HashMap<String, Double>();
		
		for(Studente studente: studenti)
		{ 
			String matr = studente.getMatricola();
			mediaPesata = calcolaMediaPesata(studente);

			mediaPesataPerOgniStudente.put(matr, mediaPesata);
		}
		
		return mediaPesataPerOgniStudente;
	}
	
	public List<Studente> getStudentiCheHannoCompletatoPianoDiStudi ()
	{
		List<Studente> studentiConPianoDiStudiCompletato = new LinkedList<Studente>();
		
		for(Studente studente: studenti)
		{
			int cont = 0;
			List<Corso> pDS = new LinkedList<Corso>();
			
			pDS = studente.getPianoDiStudi();
			
			for(Corso corso: pDS)
			{				
				if (trovaEsameInCarriera(studente, corso))
				  cont++;
			}
			
			if(pDS.size() == cont)
			  studentiConPianoDiStudiCompletato.add(studente);
		}
		
		return studentiConPianoDiStudiCompletato;
	}
	
	public Map<Corso, List<Studente>> getStudentiMiglioriPerOgniCorso()
	{
		Map<Corso, List<Studente>> mappaDegliStudentiBravissimi = new HashMap<Corso, List<Studente>>();
		
		for(Corso corso: getSetDeiCorsi())
		{
			int votoMassimo = trovaVotoMassimo(corso);
			List<Studente> studentiBravissimi = new LinkedList<Studente>();
			
			for(Studente studente: getListaDegliStudentiCheHannoSostenutoLEsameRelativoAlCorso(corso))
			{
		    	if((getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(corso)).get(studente) == votoMassimo)
		    	 studentiBravissimi.add(studente);
		    }
			
			mappaDegliStudentiBravissimi.put(corso, studentiBravissimi);
		}	
		
		return mappaDegliStudentiBravissimi;
	}

	public Map<Ruolo, List<Docente>> getMappaProfBuoni()
	{
		Map<Ruolo, List<Docente>> mappaProfBuoni = new HashMap<Ruolo, List<Docente>>();
		List<Docente> listaProfBuoniPerRuolo = new LinkedList<Docente>();		
		
		for(Ruolo ruolo: getSetRuoli())
		{
			listaProfBuoniPerRuolo = getListaProfMediaVotiPiuAltaPerRuolo(ruolo);
			mappaProfBuoni.put(ruolo, listaProfBuoniPerRuolo);
		}	
		
		return mappaProfBuoni;
	}
	
	public List<Corso> getCorsiNessunEsame ()
	{
		List<Corso> corsiNessunEsame = new LinkedList<Corso>();
		
		for(Corso corso: getSetDeiCorsi())
		{
			if(getMappaDiTuttiICorsiConStudentiEVoti().get(corso).size() == 0)
			 corsiNessunEsame.add(corso);
		}	
		
		return corsiNessunEsame;
	}
	
	public List<Corso> getCorsiFacili ()
	{
		List<Corso> corsiFacili = new LinkedList<Corso>();
		
		for(Corso corso: getSetDeiCorsi())
		{
			if(calcolaMediaVoti(corso) == getMediaVotiPiuAlta())
			 corsiFacili.add(corso);
		}	
		
		return corsiFacili;
	}
	
	public Map<String, String> getStudentiConUnSoloEsameMancante ()
	{
		Map<String, String> studentiConUnSoloEsameMancante = new HashMap<String, String>();
				
		for(Studente studente: studenti)
		{
			int contEsamiInCarriera = 0;
			Corso corsoMancante = new Corso();
			List<Corso> pDS = new LinkedList<Corso>();
			
			pDS = studente.getPianoDiStudi();
			
			for(Corso corso: pDS)
			{	
				int contSpia = 0;
				
				if (trovaEsameInCarriera(studente, corso))
				{
					contEsamiInCarriera++;
					contSpia++;
				}
				
				if(contSpia == 0)
				  corsoMancante = corso;
			}
			
			if(pDS.size() == contEsamiInCarriera + 1)
			  studentiConUnSoloEsameMancante.put(studente.getMatricola(), corsoMancante.getDenominazione());		
		}
		
		return studentiConUnSoloEsameMancante;
	}
		
// metodi di utilità per la Classe Universita
	
	private int calcolaNumCfu (Studente studente)
	{		
		List<Esame> esami = studente.getEsami();

		int cfuMaturati = 0;
		
		for(Esame esame: esami)
		  cfuMaturati += esame.getCorso().getCfu();
		
		return cfuMaturati;
	}	
	
	private double calcolaMediaPesata (Studente studente)
	{
		int numeratore = 0;
		
		int cfuTot = calcolaNumCfu(studente);

		if(cfuTot < 1)
		  return 0;	
			
		for(Esame esame: studente.getEsami())
		  numeratore += esame.getVoto()* esame.getCorso().getCfu();

		return (double) numeratore/cfuTot;	
	}
	
	public boolean trovaEsameInCarriera (Studente studente, Corso corso)
	{
		for(Esame esame: studente.getEsami())
	      {
			if (corso.equals(esame.getCorso()))
			  return true;
	      }
		
		return false;
	}
	
	// creiamo un utile sotto-metodo che per ogni corso restituisce la lista di studenti che hanno
	// sostenuto l'esame ad esso corrispondente
	
	private List<Studente> getListaDegliStudentiCheHannoSostenutoLEsameRelativoAlCorso(Corso corso)
	{
		List<Studente> listaStudentiConQuellEsame = new LinkedList<Studente>();

		for(Studente studente: studenti)
		{
			if(trovaEsameInCarriera(studente, corso))
			  listaStudentiConQuellEsame.add(studente);
		}
		
		return listaStudentiConQuellEsame;
	}
	
	private Map<Studente, Integer> getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(Corso corso)
	{
		Map<Studente, Integer> mappaStudenti = new HashMap<Studente, Integer>();
		
		for(Studente studente: getListaDegliStudentiCheHannoSostenutoLEsameRelativoAlCorso(corso))
		  mappaStudenti.put(studente, getEsame(studente, corso).getVoto());
		
		return mappaStudenti;
	}

	public Map<Corso, Map<Studente, Integer>> getMappaDiTuttiICorsiConStudentiEVoti()
	{
		Map<Corso,Map<Studente, Integer>> mappaDeiCorsi = new HashMap<Corso, Map<Studente, Integer>>();
		
		for(Corso corso: getSetDeiCorsi())
		  mappaDeiCorsi.put(corso, getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(corso));	
		
		return mappaDeiCorsi;
	}
	
	// per ogni corso trovo il massimo voto ottenuto, poi scorro la mappa studenti:voti e mi trovo quali studenti 
	// hanno ottenuto proprio quel voto; quindi li listo. Con una doppia ricerca lineare mi evito di distruggere e 
	// ricreare una qualche altra lista ogni volta che trovo un nuovo voto massimo cercando direttamente nella mappa
	
	private int trovaVotoMassimo (Corso corso)
	{
		int votoMassimo = 0;
		
	    for(Studente studente: getListaDegliStudentiCheHannoSostenutoLEsameRelativoAlCorso(corso))
		{
	    	if((getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(corso)).get(studente) > votoMassimo)
	    	  votoMassimo = (getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(corso)).get(studente);
	    }
	    
	    return votoMassimo;
	}
	
	private double calcolaMediaVoti (Corso corso)
	{
		int cont = getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(corso).size();
		int numeratore = 0;
		
		if(cont != 0)
	    {
			for(Studente studente: getListaDegliStudentiCheHannoSostenutoLEsameRelativoAlCorso(corso))
			  numeratore += getMappaDegliStudentiCheHannoSuperatoQuellEsameConAssociatoIlVoto(corso).get(studente);
			
			return (double) numeratore/cont;
	    }
		
	    return 0;
	}
	
	private double getMediaVotiPiuAlta ()
	{
		double mediaVotiPiuAlta = 0.;
		
	    for(Corso corso: getSetDeiCorsi())
		{
	    	if(calcolaMediaVoti (corso) > mediaVotiPiuAlta)
	    	  mediaVotiPiuAlta = calcolaMediaVoti (corso);
	    }
	    
	    return mediaVotiPiuAlta;
	}

	private Esame getEsame (Studente studente, Corso corso)
	{
		Esame esameDaTrovare = new Esame();
		
		for(Esame esame: studente.getEsami())
		{
			if(esame.getCorso().equals(corso))
			 esameDaTrovare = esame;
		}
		
		return esameDaTrovare;
	}
	
	private List<Docente> getListaProfMediaVotiPiuAltaPerRuolo (Ruolo ruolo)
	{
		List<Docente> profMediaVotiPiuAltaPerRuolo = new LinkedList<Docente>();
	    double mediaVotiPiuAlta = getMediaVotiPiuAltaPerRuolo(ruolo);
	    
		for(Docente docente: mappaDocentiPerRuolo().get(ruolo))
		{
			if(getMediaProf(docente) == mediaVotiPiuAlta)
		      profMediaVotiPiuAltaPerRuolo.add(docente);
		}
		
	    return profMediaVotiPiuAltaPerRuolo;
	}
	
	private double getMediaVotiPiuAltaPerRuolo(Ruolo ruolo)
	{
		double mediaVotiPiuAlta = 0.;
		
		for(Docente docente: mappaDocentiPerRuolo().get(ruolo))
		{
			if(getMediaProf(docente) > mediaVotiPiuAlta)
		    	mediaVotiPiuAlta = getMediaProf(docente);
		}
		
		return mediaVotiPiuAlta;
	}
	
	private double getMediaProf(Docente docente)
	{
		int numeratore = 0;
		int cont = 0;

		for(Esame esame: getListaEsami())
		{
			if(esame.getCorso().getDocente().equals(docente))
			{
				cont++;
				numeratore += esame.getVoto();
			}
		}
		
		if(cont != 0)
		 return (double) numeratore/cont;
		
		return 0;
	}

	// le seguenti altre funzioni di utilità memorizzano in strutture dati dinamiche le informazioni recuperate 
	// dall'unica lista cui ha accesso Universita: la lista "studenti".
	
	private List<Esame> getListaEsami()
	{
		List<Esame> listaEsami = new LinkedList<Esame>();

		for(Studente studente: studenti)
		{
			for(Esame esame:studente.getEsami())
			  listaEsami.add(esame);
		}

		return listaEsami;
	}
	
	// questo metodo restituisce il set di tutti i corsi esistenti frugando nei piani di studio di ogni studente
	
	private Set<Corso> getSetDeiCorsi ()
	{
		Set<Corso> setDeiCorsi = new HashSet<Corso>();
		
		for(Studente studente: studenti)
		{
			for(Corso corso: studente.getPianoDiStudi())
			  setDeiCorsi.add(corso);
		}
		
		return setDeiCorsi;
	}
	
	private Set<Docente> setDocenti ()
	{
		Set<Docente> setDocenti = new HashSet<Docente>();
		
		for(Corso corso: getSetDeiCorsi())
		  setDocenti.add(corso.getDocente());
		
		return setDocenti;
	}
	
	private Set<Ruolo> getSetRuoli ()
	{
		Set<Ruolo> setRuoli = new HashSet<Ruolo>();
		
		for(Corso corso: getSetDeiCorsi())
		  setRuoli.add(corso.getDocente().getRuolo());
		
		return setRuoli;
	}
	
	private Map<Ruolo, List<Docente>> mappaDocentiPerRuolo ()
	{
		Map<Ruolo, List<Docente>> mappaDocentiPerRuolo = new HashMap<Ruolo, List<Docente>>();
		
		for(Ruolo ruolo: getSetRuoli())
		{
		   List<Docente> listaDocenti = new LinkedList<Docente>();
		   
		   for(Docente docente: setDocenti())
			 {
			   if(docente.getRuolo() == ruolo)
				 listaDocenti.add(docente);
			 }
		   
		   mappaDocentiPerRuolo.put(ruolo, listaDocenti);	   
		}  
		
		return mappaDocentiPerRuolo;
	}
	
}
