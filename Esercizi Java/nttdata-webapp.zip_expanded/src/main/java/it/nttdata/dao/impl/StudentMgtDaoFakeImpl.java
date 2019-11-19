package it.nttdata.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.nttdata.dao.IStudentMgtDao;
import it.nttdata.dao.entity.Corsi;
import it.nttdata.dao.entity.PianoDiStudi;
import it.nttdata.dao.entity.Studente;

public class StudentMgtDaoFakeImpl implements IStudentMgtDao {

	private static List<Corsi> corsiList = new ArrayList<>();
	private static List<Studente> studenteList = new ArrayList<>();
	private static List<PianoDiStudi> pianoDiStudiList = new ArrayList<>();

	public StudentMgtDaoFakeImpl() {
		try {
			this.init();
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}
	
	private void init() throws ParseException {
		
		// ADD CORSI
		corsiList.add(new Corsi(1, "Analisi 1", 5, "ING-INF", "A", 1, 1, ""));
		corsiList.add(new Corsi(2, "Analisi 2", 5, "ING-INF", "A", 1, 1, ""));
		corsiList.add(new Corsi(3, "Fisica 1", 5, "ING-INF", "C", 1, 2, ""));
		corsiList.add(new Corsi(4, "Fisica 2", 5, "ING-INF", "C", 1, 2, ""));
		corsiList.add(new Corsi(5, "Elettrotecnica", 6, "ING-INF", "B", 1, 3, ""));

		// ADD Studente		
		studenteList.add(new Studente("AA001", 1, "Danilo", "Fazio", "FZADNL85A08D086A", "M", "Cosenza", "CS", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"), "33615286", "danilo@mail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"), null));
		studenteList.add(new Studente("AA002", 1, "Francesco", "Maida", "MZADNL85A09D086B", "M", "Cosenza", "CS", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"), "33615286", "danilo@mail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"), null));
		studenteList.add(new Studente("AA003", 1, "Giuseppe", "Fraccaro", "TZADNL85A08D086H", "M", "Cosenza", "CS", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"), "33615286", "danilo@mail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"), null));
		studenteList.add(new Studente("AA004", 1, "Armando", "Rossi", "TZADNL85A08D086H", "M", "Catanzaro", "CZ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"), "33615286", "danilo@mail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"), null));
		studenteList.add(new Studente("AA005", 1, "Luisa", "Muzuno", "LZADNL85A08D084G", "F", "Catanzaro", "CZ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"), "33615286", "danilo@mail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"), null));
		studenteList.add(new Studente("AA006", 1, "Maria", "Liparulo", "MLADNL85A08D086N", "F", "Napoli", "NA", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"), "33615286", "danilo@mail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"), null));
		
		// Piano Di Studi
		pianoDiStudiList.add(new PianoDiStudi("AA001", 1, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA001", 2, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA001", 3, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA001", 4, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA001", 5, 2019, 1));

		pianoDiStudiList.add(new PianoDiStudi("AA002", 1, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA002", 2, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA002", 3, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA002", 4, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA002", 5, 2019, 1));

		pianoDiStudiList.add(new PianoDiStudi("AA003", 1, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA003", 2, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA003", 3, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA003", 4, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA003", 5, 2019, 1));

		pianoDiStudiList.add(new PianoDiStudi("AA004", 1, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA004", 2, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA004", 3, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA004", 4, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA004", 5, 2019, 1));

		pianoDiStudiList.add(new PianoDiStudi("AA005", 1, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA005", 2, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA005", 3, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA005", 4, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA005", 5, 2019, 1));
		
		
		pianoDiStudiList.add(new PianoDiStudi("AA006", 1, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA006", 2, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA006", 3, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA006", 4, 2019, 1));
		pianoDiStudiList.add(new PianoDiStudi("AA006", 5, 2019, 1));
	}

	@Override
	public boolean addStudente(Studente studente) {
		boolean result = false;

		if (studente != null) {
			studenteList.add(studente);

			result = true;
		}

		return result;
	}
	
	@Override
	public boolean updStudente(Studente studente) {
		boolean result = false;
		
		if(studente!=null) {
			this.delStudente(studente.getPkMatricola());
		
			this.addStudente(studente);
		}
		
		return result;
	}
	
	@Override
	public boolean delStudente(String matricola) {
		boolean result = false;

		for (Studente s : studenteList) {
			if (matricola.equalsIgnoreCase(s.getPkMatricola())) {
				studenteList.remove(s);
				
				result = true;
				
				break;
			}
		}

		return result;
	}
	
	@Override
	public boolean addPianoDiStudi(PianoDiStudi pianoDiStudi) {
		boolean result = false;

		if (pianoDiStudiList != null) {
			pianoDiStudiList.add(pianoDiStudi);
			
			result = true;
		}

		return result;
	}

	@Override
	public Studente findStudenteByMatricola(String matricola) {
		Studente result = null;

		for (Studente s : studenteList) {
			if (matricola.equalsIgnoreCase(s.getPkMatricola())) {
				
				result = s;
				
				break;
			}
		}

		return result;
	}

	@Override
	public List<Studente> findAllStudente() {
		return studenteList;
	}
	
	@Override
	public List<Corsi> findAllCorsi() {
		return corsiList;
	}
	
	@Override
	public boolean delPianoDiStudi(String matricola) {
		boolean result = false;

		if (matricola != null) {

			Iterator<PianoDiStudi> iter = pianoDiStudiList.iterator();

			while (iter.hasNext()) {
				if (iter.next().getFkMatricola().equalsIgnoreCase(matricola)) {
					iter.remove();
					result = true;
				}
			}

		}

		return result;
	}

	@Override
	public List<Object[]> findAllExam(String matricola) {
		List<Object[]> examList = new ArrayList<>();

		if (matricola != null) {

			Studente s = this.findStudenteByMatricola(matricola);

			for (PianoDiStudi ps : pianoDiStudiList) {

				if (s.getPkMatricola().equalsIgnoreCase(ps.getFkMatricola())) {
					Corsi corso = this.findCorsoByID(ps.getFkIdCorso());
					
					examList.add(new Object[] { s.getFkIdCorsoLaurea(), s.getPkMatricola(), corso.getDenominazione(), corso.getCfu(), ps.getAnno(), ps.getSemestre() });
					
				}

			}

		}

		return examList;
	}
	
	private Corsi findCorsoByID(int pkIdCorso) {
		Corsi result = null;

		for (Corsi c : corsiList) {
			if (pkIdCorso == c.getPkIdCorso()) {
				result = c;
				break;
			}
		}

		return result;
	}
	
}
