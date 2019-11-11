package nttdata.talentcamp.universita;


import java.util.LinkedList;
import java.util.List;

public class Studente extends Persona {
	private int matricola;
	private List <Corso> pianoDiStudio;
	private List <Esame> esami;
	

	
	public boolean esameIsPresente(Esame es) {
		for (Esame esameCurr: esami) {
			if(esameCurr.equals(es)) {
				return true;
			}
		}return false;
	}
	
	public void addEsame(Esame es) {
		if(!esameIsPresente(es)) {
			esami.add(es);
		}

	}
	
	
	public Studente(String codiceFiscale, String nome, String cognome, int matricola) {
		super(codiceFiscale, nome, cognome);
		this.matricola = matricola;
		pianoDiStudio= new LinkedList <Corso>();
		esami= new LinkedList <Esame>();
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public List<Corso> getPianoDiStudio() {
		return pianoDiStudio;
	}

	public void setPianoDiStudio(List<Corso> pianoDiStudio) {
		this.pianoDiStudio = pianoDiStudio;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + "]";
	}

	
	
		
	
	

}
