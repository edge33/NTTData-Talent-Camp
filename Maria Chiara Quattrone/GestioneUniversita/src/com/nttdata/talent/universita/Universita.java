package com.nttdata.talent.universita;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Universita {
	
private List <Studente> studenti;




public Universita() {
	super();
	this.studenti = new LinkedList<Studente>();
}




public List<Studente> getStudenti() {
	return studenti;
}




public void setStudenti(List<Studente> studenti) {
	this.studenti = studenti;
}




@Override
public String toString() {
	return "Universita [studenti=" + studenti + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}




public Set <Docente> getDocenti(){
	
Set <Docente> docenti= new HashSet<Docente>();	
	for (Studente studenteCorrente:studenti) {
		for(Corso corsoCorrente:studenteCorrente.getPianoDiStudi()) {
			
				docenti.add(corsoCorrente.getDocente());
			}
	
		for (Studente studenteCorrente1:studenti) {
			for (Esame esameCorrente: studenteCorrente1.getEsami() ) {
					
					docenti.add(esameCorrente.getDocente());
				
			}	
			
		}
	}
	
	return docenti;
}


public HashMap <String, Integer> studenteCfu (List <Studente> studenti){
	
	HashMap <String, Integer> studCfu = new HashMap <String, Integer> ();
	
	for(Studente studenteCorrente: studenti) {
		studCfu.put(studenteCorrente.getMatricola(), sommaCfu(studenteCorrente));
	}
return studCfu; 
}


//somma di cfu maturati dallo studente
private static Integer sommaCfu (Studente studente) {
	
	Integer cfu=0;
	
		for(Esame esameCorrente: studente.getEsami()) {
	
				cfu+=esameCorrente.getCorso().getCfu();
			}

		
	return cfu;
}




public void addStudente(Studente s) {
// s = new Studente(s.getMatricola(), s.getCodiceFiscale(), s.getNome(), s.getCognome());
 studenti.add(s);
}



//studenti che hanno fatto tutti gli esami
public List<String> studTuttiEsami(List <Studente> studenti){
	
	List<String> studAllExams= new LinkedList<String>();
	
	for(Studente studenteCorrente:studenti) {
		if(studenteCorrente.getEsami().size() == studenteCorrente.getPianoDiStudi().size()) {
			studAllExams.add(studenteCorrente.getMatricola());
	}
	}
	return studAllExams;
}


//media ponderata degli studenti
public HashMap <String, Double> studenteMediaP (List <Studente> studenti){
	
	HashMap <String, Double> studMedia = new HashMap <String, Double> ();
	for(Studente studenteCorrente: studenti) {
		studMedia.put(studenteCorrente.getMatricola(), mediaPonderata(studenteCorrente));
	}
return studMedia; 
}
 


public Double mediaPonderata (Studente studente) {
Double mediaP= (double) 0;
	mediaP=(double) (sommaCfuVoto(studente)/sommaCfu(studente));
	return mediaP;
}


private double sommaCfuVoto (Studente studente) {
	double cfuVoto=0;
		for(Esame esameCorrente: studente.getEsami()) {
				cfuVoto+=(esameCorrente.getVoto()*esameCorrente.getCorso().getCfu());
			}
	return cfuVoto;
}


/* public HashMap <String, Double> mediaVotiDocente1 () {
	 
	
	HashMap<String, Double> Doc2=new HashMap <String, Double>();
	
	
	List<Esame> esami= new LinkedList<Esame>();
	for(Studente studenteCorrente: studenti) {
	 esami.addAll(studenteCorrente.getEsami());
	}

	
	for(Docente docenteCorrente: getDocenti()) {
		Doc2.putAll(mediaVotiDocente2(docenteCorrente.getCodiceFiscale(), esami));
		
	}
	return Doc2;
	
}*/



// per ogni ruolo, il docente che da i voti maggiori mediamente
private Double mediaVotiDocente (Docente docente) {
	
	
	Double mediaVotiDocente= (double) 0;
	double sommaVoti=0;
	int countEsami=0;
	
	
	List<Esame> esami= new LinkedList<Esame>();
	for(Studente studenteCorrente: studenti) {
	 esami.addAll(studenteCorrente.getEsami());
	}
	
	
		for(Esame esameCorrente: esami) {
			if(docente.getCodiceFiscale().equals((esameCorrente.getDocente().getCodiceFiscale()))) {
			sommaVoti+=esameCorrente.getVoto();
            countEsami++;
		}
			
		if(countEsami!=0) 
		mediaVotiDocente= sommaVoti/countEsami;
	
	}	
return mediaVotiDocente;
}

public HashMap<String, Ruolo> maxMediaVotiDoc () {
	
	HashMap<String, Ruolo> docBuonoMax = new HashMap <String, Ruolo>();
	
	
	for (Ruolo ruoloCorrente: Ruolo.values()) {
		String docBuono= " ";
		double max= 0; 
		for (Docente docenteCorrente: getDocenti()) {
			if(docenteCorrente.getRuolo().equals(ruoloCorrente)) {
		
				if(mediaVotiDocente(docenteCorrente) >= max) {
					docBuono= docenteCorrente.getCodiceFiscale();
					max=mediaVotiDocente(docenteCorrente);
				} 
	 
		
			}
		}
	docBuonoMax.put(docBuono, ruoloCorrente);
	}
	return docBuonoMax;
}




//Per ogni corso, la lista di studenti con voto maggiore

//Dato un Corso trovo la Lista degli studenti che seguono il Corso
public List <Studente> studCorso (Corso corso) {
	
List<Studente> studentiCorso= new LinkedList<Studente>();

for(Studente studenteCorrente: studenti) {
	for (Esame esame : studenteCorrente.getEsami()) {
		if(esame.getCorso().equals(corso)) {
			studentiCorso.add(studenteCorrente);
			break;
		}
	
	}
	
}

return studentiCorso;
}



private int votoStudCorsoMax (Corso corso) {

	
	
	int maxVoto=0;
	for(Studente studenteCorrente: studCorso(corso)) {
		for(Esame esameCorrente: studenteCorrente.getEsami()) {
		if(esameCorrente.getVoto()>=maxVoto && esameCorrente.getCorso().equals(corso)) {
			maxVoto=esameCorrente.getVoto();
		}
			
			
		}
		
	}
	return maxVoto;
	
}

public Map <String, List <String>> corsoStudBetter (){
	
	Map <String, List <String>> corsoStud= new HashMap <String, List <String>>();
	
		
	Set <Corso> corsi= new HashSet <Corso>();
	for(Studente studenteCorrente: studenti) {
		corsi.addAll(studenteCorrente.getPianoDiStudi());
		}	
	
	List<Esame> esami= new LinkedList<Esame>();
	for(Studente studenteCorrente: studenti) {
	 esami.addAll(studenteCorrente.getEsami());
	}	
	
	
	for(Corso corsoCorrente: corsi) {
		List<String> studentiBetterCorso= new LinkedList<String>();
		
		for(Studente studenteCorrente: studCorso(corsoCorrente)) {
			for(Esame esameCorrente: studenteCorrente.getEsami()) {
				
				if(esameCorrente.getCorso().equals(corsoCorrente) && esameCorrente.getVoto()==votoStudCorsoMax(corsoCorrente)) {
					
					studentiBetterCorso.add(studenteCorrente.getCodiceFiscale());			
				}
			}
		}	
	corsoStud.put(corsoCorrente.getNome(), studentiBetterCorso);	
	}	
	return corsoStud;
}


//Lista corsi per i quali nessuno studente ha sostenuto l'esame

public List <String> nessunEsame (){
	List <String> corsiNessunEsame = new LinkedList <String>();
	Set <Corso> corsi= new HashSet <Corso>();
	for(Studente studenteCorrente: studenti) {
		corsi.addAll(studenteCorrente.getPianoDiStudi());
		}
	
	for (Corso corsoCorrente: corsi) {
		if(studCorso(corsoCorrente).isEmpty()) {
			corsiNessunEsame.add(corsoCorrente.getNome());
		}
	}
	
	return corsiNessunEsame;
	
}

//Lista dei corsi più semplici, ovvero quelli per cui la media dei voti è più alta
//dagli studenti che hanno fatto l'esame di un corso prendo il voto del loro esame e ne faccio al media

public double mediaVotiStessoCorso (Corso corso) {
	int sommaVoti=0;
	double mediaVotiCorso=0;
	
	for(Studente studenteCorrente: studCorso(corso)) {
		for(Esame esameCorrente: studenteCorrente.getEsami()) {
			if(esameCorrente.getCorso().equals(corso)) {
				sommaVoti+=esameCorrente.getVoto();
				}
			
		}
		
	}
	if(studCorso(corso).size()!=0) {
	mediaVotiCorso=sommaVoti/studCorso(corso).size();
	}	
	return mediaVotiCorso;
}


public List <String> corsiSemplici (){
	Set <Corso> corsi= new HashSet <Corso>();
	for(Studente studenteCorrente: studenti) {
		corsi.addAll(studenteCorrente.getPianoDiStudi());
		}
	
	List <String> corsiEasy= new LinkedList <String>();
	
	double maxMediaCorso=0;
	for(Corso corsoCorrente:corsi) {
		if(mediaVotiStessoCorso(corsoCorrente)>=maxMediaCorso) {
			maxMediaCorso=mediaVotiStessoCorso(corsoCorrente);
			corsiEasy.add(corsoCorrente.getNome());
		}
	}
	return corsiEasy;
	
}

//Matricole degli studenti a cui manca un esame e l'esame mancante



/*public int esamiMancanti (Studente studente) {

	int numeroCorsi= studente.getPianoDiStudi().size(); 
	int numeroEsami= studente.getEsami().size();
	int numeroEsamiMancanti=0;
	
	if(numeroCorsi>=numeroEsami) {
		numeroEsamiMancanti= numeroCorsi-numeroEsami;
	}
	return numeroEsamiMancanti;
}*/

public Set<Corso> corsiEsamiFatti (Studente studente) {

	final int MIN_VOTO=18;
	
	//List <Esame> esamiSostenuti= studente.getEsami(); //contiene gli esami già fatti di uno studente
	List <Corso> corsi= studente.getPianoDiStudi(); //contiene i corsi ai quali può non corrispondere un esame 
    Set <Corso> corsiEsamiFatti=new HashSet<Corso>(); //contiene i corsi per i quali lo studente ha fatto l'esmae
    
    
    for(Esame esameCorrente: studente.getEsami()) {
    	if(corsi.contains(esameCorrente.getCorso()) && esameCorrente.getVoto()>=MIN_VOTO) {
    		corsiEsamiFatti.add(esameCorrente.getCorso());
    	}

    }
    return corsiEsamiFatti;

}
	

public Set<Corso> corsiEsamiMancanti (Studente studente){
	
	Set <Corso> corsiMancanti= new HashSet<Corso>();
	for(Corso corsoCorrente: studente.getPianoDiStudi()) {
			if(!corsiEsamiFatti(studente).contains(corsoCorrente)) {
				corsiMancanti.add(corsoCorrente);
			}

	}
	
	return corsiMancanti;
	
}



public Map<String, Set<Corso>> onlyOne(){
	
	Map<String, Set<Corso>> studenteEsameMancante= new HashMap<String, Set<Corso>>();
	
	final int MAX_ESAMI_MANCANTI=1;
	for(Studente studenteCorrente: studenti) {
		if(corsiEsamiMancanti(studenteCorrente).size()==MAX_ESAMI_MANCANTI) {
			studenteEsameMancante.put(studenteCorrente.getMatricola(), corsiEsamiMancanti(studenteCorrente));

		}
	}
	
	return studenteEsameMancante; 
	
}

}
		


