package com.nttdata.talentcamp.università;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universita {

	private List<Studente> studenti;

	public Universita() {
		super();
		this.studenti = new LinkedList<Studente>();
	}// end Costruttore

	
	// Per ogni Studente il numero di CFU maturati
	public Map<Studente, Integer> numeroDiCfuAcquisiti() {

		Map<Studente, Integer> mappaStudentiCfu = new HashMap<Studente, Integer>();

		for (Studente s : studenti) {

			mappaStudentiCfu.put(s, calcolaNumeroCfu(s.getEsami()));

		}
		return mappaStudentiCfu;

	}// end numeroDiCfuAcquisiti

	public int calcolaNumeroCfu(List<Esame> esami) {
		int numCfu = 0;
		for (Esame e : esami) {
			numCfu += e.getCorso().getCfu();
		}
		return numCfu;
	}// end calcolaNumeroCfu
	
	
//Per ogni Studente, la sua media pesata

	public Map<Studente, Double> mediaStudente() {

		Map<Studente, Double> mappaStudentiCfu = new HashMap<Studente, Double>();

		for (Studente studente : studenti) {
			mappaStudentiCfu.put(studente, CalcolaMedia(studente));
		}
		return mappaStudentiCfu;
	} // end mediaStudente

	public double CalcolaMedia(Studente s) {
		double media = 0;
		if (calcolaNumeroCfu(s.getEsami()) != 0) {
			media = votoPerCredito(s) / calcolaNumeroCfu(s.getEsami());
		}
		return media;
	}// end CalcolaMedia

	public int votoPerCredito(Studente s) {
		int sommatoria = 0;
		for (Esame e : s.getEsami()) {
			sommatoria = sommatoria +(e.getVoto() * e.getCorso().getCfu());
		}

		return sommatoria;
	}// end votoPerCredito

	public void addStudente(Studente s1) {
		if (!studenti.contains(s1)) {
			studenti.add(s1);
		}
	}// end addStudente

// per ogni corso gli studenti con i migliori voti
	
	public Map<Corso, List<Studente>> studentiConIMiglioriVoti() {

		Set<Corso> corsiUni = CreaListaCorsiUniversita();
		Map<Corso, List<Studente>> studentiMigliori = new HashMap<Corso, List<Studente>>();

		for (Corso corso : corsiUni) {
			studentiMigliori.put(corso, CalcolaStudentiMigliori(corso));
		}

		return studentiMigliori;
	}// end studentiConIMiglioriVoti

	public List<Studente> CalcolaStudentiMigliori(Corso c) {
		List<Studente> studentiMigliori = new LinkedList<Studente>();
		for (Studente studente : studenti) {
			for (Esame e : studente.getEsami()) {
				if (e.getCorso().equals(c) && VotoMax(c) == e.getVoto()) {
					studentiMigliori.add(studente);
				}
			}
		}
		return studentiMigliori;
	}// end CalcolaStudentiMigliori

	public int VotoMax(Corso c) {
		int bestVoto = 18;
		for (Studente studente : studenti) {
			for (Esame e : studente.getEsami()) {
				if (e.getCorso().equals(c) && e.getVoto() > bestVoto) {
					bestVoto = e.getVoto();

				}
			}
		}
		return bestVoto;
	}// end VotoMax

	public Set<Corso> CreaListaCorsiUniversita() {
		Set<Corso> corsiUni = new HashSet<Corso>();
		for (Studente studente : studenti) {
			// for (Corso corso : studente.getPianoDiStudi()) {
			// corsiUni.add(corso);
			// }
			corsiUni.addAll(studente.getPianoDiStudi());

		}
		return corsiUni;
	}// end CreaListaCorsiUniversita

//elenco degli studenti che hanno sostenuti tutti gli esami del loro piano di studi
	
	public List<Studente> StudentiChehannoFinitoGliesami() {
		List<Studente> elencoStudenti = new LinkedList<Studente>();

		for (Studente studente : studenti) {
			if (studente.getPianoDiStudi().size() == studente.getEsami().size()) {
//			if(CorsoPresenteInEsami(studente.getPianoDiStudi(),studente.getEsami())) {
				elencoStudenti.add(studente);
			}
		}
		return elencoStudenti;
	}// end StudentiChehannoFinitoGliesami


	public Set<Docente> getDocenti() {
		Set<Docente> docenti = new HashSet<Docente>();
		// recupera i docenti a partire dai corsi e esami di ciascun
		// studente
		for (Studente s : studenti) {
			for (Corso c : s.getPianoDiStudi()) {
				docenti.add(c.getDocente());
			}
		}
		return docenti;
	}// end getDocenti

	// per ogni ruolo il docente che mediamente eroga i voti più alti

	public Map<RuoloDocenti, Docente> DocenteBuono() {

		Map<RuoloDocenti, Docente> docenti = new HashMap<RuoloDocenti, Docente>();
		Set<Docente> elencoDocenti = getDocenti();

		for (Docente docente : elencoDocenti) {
			docenti.put(docente.getRuolo(), BestDocente(docente.getRuolo()));
		}
		return docenti;
	}// end DocenteBuono

	public Docente BestDocente(Enum<RuoloDocenti> ruolo) {
		// mediaDeiVotiPiùAlta
		Set<Docente> elencoDocenti = getDocenti();
		Docente docenteCurr = null;
		double mediaCurr = 0;
		for (Docente docente : elencoDocenti) {
			if (docente.getRuolo() == ruolo && CalcolaMediaVoti(docente) > mediaCurr) {
				mediaCurr = CalcolaMediaVoti(docente);
				docenteCurr = docente;
			}
		}
		return docenteCurr;
	}//end BestDocente

	public double CalcolaMediaVoti(Docente d) {

		Set<Esame> esamiDocente = new HashSet<Esame>();

		for (Studente studente : studenti) {
			for (Esame esame : studente.getEsami()) {
				
				if (esame.getDocente().equals(d)) {

					esamiDocente.add(esame);
				}
			}
		}
		double media = MediaVoti(esamiDocente);
		return media;
	}// end  CalcolaMediaVoti

	public double MediaVoti(Set<Esame> esami) {
		int sommaVoti = 0;
		double media = 0;
		for (Esame esame : esami) {
			sommaVoti += esame.getVoto();
		}
		if (esami.size() != 0)
			media = sommaVoti / esami.size();
		return media;
	}// end  MediaVoti

	// La lista dei corsi per i quali nessuno studente ha sostenuto l’esame

	public List<Corso> CorsiDifficili() {
		Set<Corso> corsiUni = CreaListaCorsiUniversita();
		List<Corso> corsiDifficili = new LinkedList<Corso>();
		for (Corso corso : corsiUni) {
			if (!EsameSostenuto(corso)) {
				corsiDifficili.add(corso);
			}
		}
		return corsiDifficili;
	}// end

	public boolean EsameSostenuto(Corso c) {
		boolean esameSostenuto = true;
		for (Studente studente : studenti) {
			for (Esame esame : studente.getEsami()) {
				if (!esame.getCorso().equals(c)) {
					esameSostenuto = false;
				}
				if (esameSostenuto == true) {
					return true;
				}
				esameSostenuto = true;
			}

		}
		return false;
	}// end

	// La lista dei corsi più semplici, ovvero per i quali la media voto è la più
	// alta
	public List<Corso> CorsiFacili() {
		Set<Corso> corsiUni = CreaListaCorsiUniversita();
		List<Corso> corsiFacili = new LinkedList<Corso>();

		for (Corso corso : corsiUni) {
			if (MaxMediaVoto(corso)) {
				corsiFacili.add(corso);
			}
		}
		return corsiFacili;
	}

	public boolean MaxMediaVoto(Corso c) {
		double mediaCurr = CalcolaMediaVotoCorso(c);
		Set<Corso> corsiUni = CreaListaCorsiUniversita();
		for (Corso corso : corsiUni) {
			if (CalcolaMediaVotoCorso(corso) > mediaCurr) {
				return false;
			}

		}
		return true;

	}

	public double CalcolaMediaVotoCorso(Corso c) {

		List<Esame> esamiCorso = new LinkedList<Esame>();

		for (Studente studente : studenti) {
			for (Esame esame : studente.getEsami()) {
				
				if (esame.getCorso().equals(c)) {
					esamiCorso.add(esame);
				}
			}
		}
		double media = MediaVotiCorso(esamiCorso);
		return media;
	}// end

	public double MediaVotiCorso(List<Esame> esami) {
		int sommaVoti = 0;
		double media = 0;
		for (Esame esame : esami) {
			sommaVoti += esame.getVoto();
		}
		if (esami.size() != 0)
			media = sommaVoti / esami.size();
		return media;
	}// end


	// Le matricole degli studenti a cui manca esattamente un esame, e l’esame
	// mancante

	public Map<String, Corso> UltimoEsame() {
		Map<String, Corso> ultimoEsame = new HashMap<String, Corso>();
		for (Studente studente : studenti) {
			if (!IsUltimo(studente).isEmpty() && IsUltimo(studente).size() == 1) {
				ultimoEsame.put(studente.getMatricola(), IsUltimo(studente).get(0));
			}
			return ultimoEsame;
		}
		return null;
	}// end

	public List<Corso> IsUltimo(Studente s) {
		List<Corso> esameCurr = new LinkedList<Corso>();
		if (!StudentiChehannoFinitoGliesami().contains(s)) {
			for (Corso corso : s.getPianoDiStudi()) {
				if (!EsameSostenuto(corso)) {
					esameCurr.add(corso);
				}
			}
		}
		return esameCurr;
	}

	@Override
	public String toString() {
		return "Universita [studenti=" + studenti + ", numeroDiCfuAcquisiti()=" + numeroDiCfuAcquisiti()
				+ ", mediaStudente()=" + mediaStudente() + ", studentiConIMiglioriVoti()=" + studentiConIMiglioriVoti()
				+ ", StudentiChehannoFinitoGliesami()=" + StudentiChehannoFinitoGliesami() + "]";
	}

}
