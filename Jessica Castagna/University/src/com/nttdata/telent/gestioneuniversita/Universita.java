package com.nttdata.telent.gestioneuniversita;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Universita{

	private List <Studente> studenti;

	
	public Universita() {
		super();
		this.studenti = new LinkedList ();
	}



	public void addStudente(Studente studente) {
		studenti.add(studente);
		
	}

	// ESERCIZIO 1. Per ogni Studente il numero di CFU maturati 

	//Calcola la somma dei CFU per il singolo studente

	//Crea una mappa con chiave matricola e valore CFU

	public Map <String, Integer> getCfuPerOgniStudente () {

		int CfuMaturati;
		String matricola;
		Map <String, Integer> CfuPerOgniStudente = new HashMap<String, Integer>();

		for (Studente studente : studenti) {
			matricola= studente.getMatricola();
			CfuMaturati = sommaCfu(studente);
			CfuPerOgniStudente.put(matricola, CfuMaturati);
		}

		return(CfuPerOgniStudente);

	}

	//fa la somma dei CFU per ogni studente	
	private int sommaCfu (Studente studente) {

		int sommaCfu=0;

		List <Esame> esami = studente.getEsami(); 
		for (Esame esame : esami) {
			Corso corsoEsame = esame.getCorso();
			sommaCfu+= corsoEsame.getCfu();
		}
		return (sommaCfu);

	}




	//ESERCIZIO 2. Per ogni Studente, la sua media pesata


	//crea una mappa con chiave matricola e valore media pesata	
	public Map <String, Double> getMediaPesataPerOgniStudente () {

		Double mediaPesata;
		String matricola;
		Map <String, Double> mediaPesataPerOgniStudente = new HashMap<String, Double>();

		for (Studente studente : studenti) {
			matricola= studente.getMatricola();
			mediaPesata = calcolaMediaPesata(studente);
			mediaPesataPerOgniStudente.put(matricola, mediaPesata);
		}

		return(mediaPesataPerOgniStudente);

	}

	//calcola la media pesata per ogni studente
	private double calcolaMediaPesata (Studente studente) {
		List <Esame> esami = studente.getEsami(); 
		int totCfu= sommaCfu (studente);
		int numeratore=0;
		double mediaPesata=0;

		if (totCfu ==0 ) {
			return 0;
		}

		else {

			for (Esame esame : esami) {

				Corso corsoEsame = esame.getCorso();
				numeratore += esame.getVoto() * corsoEsame.getCfu(); 
			}
			mediaPesata = (double) numeratore/totCfu;

			return mediaPesata;

		}
	}


	//ESERCIZIO 3. Elenco degli studenti che hanno sostenuto tutti gli esami del loro piano di studi 	

	//crea una lista con gli studenti che hanno superato tutti gli esami
	public List<Studente> getStudentiTuttiEsami () {
		List<Studente> miglioriStudenti = new LinkedList();
		for (Studente s : studenti) {
			if (s.pianoDiStudi.size() == s.esami.size() && studentiMigliori(s))
				miglioriStudenti.add(s);		
		}
		return miglioriStudenti;

	}

	//seleziona lo studente che ha superato tutti gli esami;
	// in realtà potrebbe bastare anche il solo controllo della size delle liste,
	// questo metodo controlla eventuali errori di inserimenti di esami non presenti 
	// nel piano di studi
	private boolean studentiMigliori(Studente s){

		boolean esameSuperato = false;

		for (Corso c : s.getPianoDiStudi()) {
			for (Esame e :  s.getEsami()) {
				if (e.getCorso().equals(c)) {
					esameSuperato = true;
				}
			}
			if (esameSuperato == false) {
				return false;
			}
			esameSuperato = false;
		}
		return true;


	}

	// stampa solo la matricola dello studente (si può anche evitare se voglio visualizzare 
	//nell'output tutte le info dello studnete
	private void stampaLista (List <Studente> studenti){

		for (Studente studente:studenti) {
			System.out.println(studente.getMatricola());
		}

	}

	
	
	//ESERCIZIO 4. Per ogni Corso gli studenti con i migliori voti

    //Crea una mappa con il corso e la relativa lista degli studenti con i voti migliori
	public Map <Corso, List<Studente>> MiglioriStudenti(){

		Map <Corso, List<Studente>> mappaStudentiMigliori = new HashMap<Corso, List<Studente>>();
		Set<Corso> corsi = getCorsi(studenti);
		for(Corso c : corsi)
		{
			List<Studente> studentiMiglioriPerCorso = new LinkedList<Studente>();
			studentiMiglioriPerCorso = selezionaStudenti(getMigliorVoto(c), c);		
			mappaStudentiMigliori.put(c, studentiMiglioriPerCorso);
		}

		return mappaStudentiMigliori;		

	}		

	//crea una lista con gli studenti migliori per ciascun corso
	private List <Studente> selezionaStudenti(int voto, Corso c) {

		List<Studente> studentiMiglioriPerCorso = new LinkedList<Studente>();
		for (Studente s:studenti)
			for (Esame e: s.getEsami())
			{
				if (e.getCorso().equals(c) && e.getVoto() == voto)
					studentiMiglioriPerCorso.add(s);
			}
		return studentiMiglioriPerCorso;

	}

	//calcola il voto migliore per ciascun corso
	private int getMigliorVoto(Corso corso) {
		int max =0;
		for (Studente s: studenti) 
		{
			if(max < getVotoCorso(s, corso))
			{
				max= getVotoCorso(s, corso);
			}
		}
		return(max);	
	}

	//estrae il voto del corso ottenuto da ciascun studente
	private int getVotoCorso (Studente studente, Corso corso){

		for (Esame e: studente.getEsami())
		{
			if (e.getCorso().equals(corso))
				return (e.getVoto());		
		}
		return 0;
	}


	//crea un set di corsi (senza ripetizioni) a partire dal piano di studi di ciascun studente
	public static Set<Corso> getCorsi(List <Studente> studenti) {
		Set<Corso> corsiStudenti = new HashSet<Corso>();

		for (Studente s:studenti)
			for (Corso c : s.getPianoDiStudi())
			{
				corsiStudenti.add(c);

			}
		return (corsiStudenti);

	}



	//	ESERCIZIO 5. Per ogni Ruolo, il docente che mediamente eroga i voti più alti--
	
	//Crea una mappa che associa a ciascun ruolo il docente più buono
	public Map <Ruolo, String> docentiBuoni (){
		Map <Ruolo, String> mappaDocentiBuoni = new HashMap<Ruolo, String>();
		Set<Docente> listaDocenti = getDocenti();
		double media=0;
		double max=0;
		Docente docenteMigliore = new Docente(null, null, null, null);
		for (Ruolo ruolo : Ruolo.values()) {
			for (Docente d: listaDocenti){
				if (d.getRuoloDocente().equals(ruolo))
					media = mediaDocente(d);			
				if (media > max) {
					max=media;
					docenteMigliore= d;
				}				
			}
			mappaDocentiBuoni.put(ruolo, docenteMigliore.getCognome());
			max=0;
			media=0;
		}				
		return(mappaDocentiBuoni);
	}

	
	
	
	//calcola la media dei voti erogati da ogni docente
	private double mediaDocente (Docente d) {
		double voti = 0;
		int cont=0;
		for (Studente s : studenti){
			for (Esame e : s.esami) {
				if (e.getDocente().equals(d))  {
					voti+= e.getVoto();
					cont++;
				}
			}
		} 
		if(cont!=0)
			return voti/cont; 
		else 
			return -1;
	}

	//crea un set di docenti a partire dal piano di studi di ogni studente
	public Set<Docente> getDocenti(){
		Set<Docente> listaDocenti = new HashSet<Docente>();

		for (Studente s : studenti){
			for (Corso c : s.getPianoDiStudi())
			{
				listaDocenti.add(c.getDocente());			
			}
		}
		return listaDocenti;


	}

	//ESERCIZIO 6. La lista dei corsi per i quali nessuno studente ha sostenuto l’esame

	//crea la lista di corsi con nessun esame sostenuto
	public List<Corso> listaCorsiNoEsami(){

		List <Corso> corsiNoEsami = new LinkedList();
		Set<Corso> corsi = getCorsi(studenti);

		for (Corso c:corsi)
		{
			if (corsoImpossibile(c) != null)
				corsiNoEsami.add(corsoImpossibile(c));			
		}

		return corsiNoEsami;
	}

	//seleziona il corso che nessuno ha superato
	private Corso corsoImpossibile(Corso corso){

		boolean esameDato = false;
		for (Studente s : studenti)
			for (Esame e: s.getEsami()) {
				if(e.getCorso().equals(corso)) {
					esameDato=true;
				}
			}
		if (!esameDato)
			return corso;
		else
			return null;
	}


	// ESERCIZIO 7. La lista dei corsi più semplici, ovvero per i quali la media voto è la più alta

	//crea una lista con i corsi più semplici
	public List<Corso> listaCorsiSemplici() {
		List <Corso> listaCorsiSemplici = new LinkedList();
		Set <Corso> corsi =getCorsi(studenti);
		Corso corsoMigliore= new Corso(null, null, 0, null);
		double max=0;

		for (Corso c:corsi) {
			if(mediaCorso(c) > max) {
				max=mediaCorso(c);
				corsoMigliore=c;
			}
		}
		listaCorsiSemplici.add(corsoMigliore);

		if(altriCorsiMigliori(max, corsoMigliore) != null)
			listaCorsiSemplici.add(altriCorsiMigliori(max, corsoMigliore));

		return listaCorsiSemplici;

	}


	//calcola la media ottenuta dagli studenti per ciascun corso
	private double mediaCorso (Corso corso) {

		double voti = 0;
		int cont=0;
		for (Studente s : studenti){
			for (Esame e : s.esami) {
				if (e.getCorso().equals(corso))  {
					voti+= e.getVoto();
					cont++;
				}
			}
		} 
		if(cont!=0)
			return voti/cont; 
		else 
			return -1;
	}

	//aggiunge eventuali altri corsi che hanno ottenuto la stessa media
	private Corso altriCorsiMigliori(double max, Corso corsoMigliore){
		Set <Corso> corsi =getCorsi(studenti);
		for(Corso c:corsi) {
			if(mediaCorso(c)==max && !c.getDenominazione().equals(corsoMigliore.getDenominazione()))
				return(c);
		}
		return null;
	}
	
	

	//ESERCIZIO 8. Le matricole degli studenti a cui manca esattamente un esame, e l’esame mancante
	
	//Crea una mappa che associa alla matricola degli studenti a cui manca un solo esame,
	//l'esame mancante
	public Map <Corso, String> studentiMenoUnEsame(){
		Map <Corso, String> mappaStudentiMenoUnEsame = new HashMap<Corso, String>();

		for(Studente s:studenti) {
			if(s.pianoDiStudi.size() - s.esami.size()==1) {
				mappaStudentiMenoUnEsame.put(esameMancante(s), s.getMatricola());
			}

		}
		return mappaStudentiMenoUnEsame;
	}
	
	
	//seleziona l'esame mancante per ciascun studente
	private Corso esameMancante(Studente s) {
		boolean esameMancante=false;
		for(Corso c: s.pianoDiStudi) {
			for (Esame e: s.esami)
			{
				if (c.getDenominazione().equals(e.getCorso().getDenominazione()))
					esameMancante=true;
			}
			if(esameMancante)
				return c;
		}
		return null;		

	}




}



