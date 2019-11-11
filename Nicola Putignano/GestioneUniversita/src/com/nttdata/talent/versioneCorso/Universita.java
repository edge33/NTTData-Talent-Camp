package com.nttdata.talent.versioneCorso;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.nttdata.talent.versioneCorso.Corso;
import com.nttdata.talent.versioneCorso.Esame;
import com.nttdata.talent.versioneCorso.Studente;

public class Universita {

	private List<Studente> elencoStudenti;

	public Universita() {
		elencoStudenti = new LinkedList<>();
	}
	
	//Genera la lista dei Docenti che hanno almeno un corso nel piano di studi 
	//di uno studente
	public List<Docente> getProfessors(){
		List<Docente> elencoDocenti = new LinkedList<>();
		for(Corso courseCurr : getCourse()) {
			if(!elencoDocenti.contains(courseCurr.getDocente())) {
				elencoDocenti.add(courseCurr.getDocente());
			}
		}

		return elencoDocenti;
	}

	//aggiunge lo studente in input all'elenco studenti, se non già presente
	public void addStudente(Studente s) {
		if(!elencoStudenti.contains(s)) {
			elencoStudenti.add(s);
		}
	}

	//restituisce tutti i corsi presenti almeno una volta in un piano di studi
	public List<Corso> getCourse(){
		List<Corso> elencoCorsi= new LinkedList<>();
		for(Studente studentCurr : elencoStudenti) {
			for(Corso courseCurr : studentCurr.getPianoDiStudi()) {
				if(!elencoCorsi.contains(courseCurr)) {
					elencoCorsi.add(courseCurr);
				}
			}		
		}
		return elencoCorsi;

	}

	//Per ogni Studente il numero di CFU maturati	
	public Map<Studente, Integer> getSumCfuAllStudent(){

		Map<Studente, Integer> mappaStudentiSommaCfu = new HashMap<>();

		for(Studente currStudent: elencoStudenti) {
			mappaStudentiSommaCfu.put(currStudent, currStudent.getSumCfu());
		}

		return mappaStudentiSommaCfu;

	}

	//Per ogni Studente, la sua media pesata
	public Map<Studente, Double> mediaPesataAllStudent(){

		Map<Studente, Double> mappaMediaPesata = new HashMap<>();

		for(Studente currStudent: elencoStudenti) {
			mappaMediaPesata.put(currStudent, currStudent.getMediaPesata());
		}

		return mappaMediaPesata;

	}

	//Elenco degli studenti che hanno sostenuto tutti gli esami del loro 
	//piano di studi
	public List<Studente> studentsFinishedTheirStudies(){

		List<Studente> studentsList = new LinkedList<>();
		for(Studente currStudent : elencoStudenti) {
			if(currStudent.getEsamiSostenuti().size() == currStudent.getPianoDiStudi().size()) {
				studentsList.add(currStudent);
			}
		}
		return studentsList;
	}

	//Per ogni Corso gli studenti con i migliori voti
	public Map<Corso, List<Studente>> topStudentsForCourse (){

		Map<Corso, List<Studente>> mapCourseBestStudents = new HashMap<>();
		for (Corso currCourse : getCourse()) {
			List<Studente> bestStudentList = new LinkedList<>();
			for(Studente currStudent : elencoStudenti) {
				if(gradeCourseStudent(currStudent, currCourse) == bestGradeOfCourse(currCourse)
						&& bestGradeOfCourse(currCourse) != 0) {
					bestStudentList.add(currStudent);
				}
			}
			mapCourseBestStudents.put(currCourse, bestStudentList);
		}

		return mapCourseBestStudents;
	}

	//Il voto d'esame associato ad un determinato corso preso da un determinato studente   	
	private int gradeCourseStudent (Studente s, Corso c) {
		for (Esame currExame : s.getEsamiSostenuti()) {
			if (currExame.getCorso().equals(c)) {
				return currExame.getVoto();
			}
		}

		return 0;
	}

	//restituisce il voto migliore preso ad un esame di un determinato corso passato
	//in input
	private int bestGradeOfCourse(Corso c) {
		int bestGrade = 0;
		for(Studente currStudent : elencoStudenti) {
			if(gradeCourseStudent(currStudent, c)>bestGrade) {
				bestGrade = gradeCourseStudent(currStudent, c);
			}
		}
		return bestGrade;
	}

	//La lista dei Corsi per i quali nessuno studente ha sostenuto l'esame
	public List<Corso> studentsWithoutPassedExam(){
		List<Corso> listCourses = new LinkedList<>();
		for(Corso currCourse : getCourse()) {	
				if(bestGradeOfCourse(currCourse) == 0) {
					listCourses.add(currCourse);
				}
		}
		
		return listCourses;
	}
	
	//La lista dei corsi più semplici, ovvero per i quali la media voto è la più alta
	public List<Corso> simpleCourses(){
		List<Corso> listSimpleCourses = new LinkedList<>();
		for(Corso currCourse : getCourse()) {
			if(averageGradeCorso(currCourse) == maxAverageGradeCourses()) {
				listSimpleCourses.add(currCourse);
			}
		}
		return listSimpleCourses;
	}
	
	//media voto degli esami associati al corso passato in input
	private double averageGradeCorso (Corso c) {
		if(studentsWithoutPassedExam().contains(c)) {
			return 0;
		}
		double sumGrade = 0;
		int numExams = 0;
		for(Studente currStudent : elencoStudenti) {
			if(gradeCourseStudent(currStudent, c) != 0) {
				sumGrade += gradeCourseStudent(currStudent, c);
				numExams++;
			}
		}
		return sumGrade/numExams;
	}
	
	//il massimo tra le medie voto esame associate a tutti i corsi
	private double maxAverageGradeCourses(){
		double max = 0;
		for(Corso currCourse : getCourse()) {
			if(averageGradeCorso(currCourse) > max) {
				max = averageGradeCorso(currCourse);
			}
		}
		return max;
	}
	
	//Le matricole degli studenti a cui manca esattamente un esame,
	//e l’esame mancante
	public Map<String,Corso> studentsWithOneExame (){
		Map <String, Corso> studentsSingleExame= new HashMap<>();
		for (Studente currStudent : elencoStudenti) {
			if(currStudent.getPianoDiStudi().size()-1 == currStudent.getEsamiSostenuti().size()) {
				studentsSingleExame.put(currStudent.getMatricola(), missingCourse(currStudent));
			}
		}
		return studentsSingleExame;
		
	}
	
	//il corso associato all'ultimo esame mancante allo studente dato in input
	private Corso missingCourse(Studente s){
		for (Corso currCourse: s.getPianoDiStudi()) {
			boolean trovato=false;
			for(Esame currExame : s.getEsamiSostenuti()) {
				if (currExame.getCorso().equals(currCourse)) {
					trovato=true;
					break;
				}
			}
			if (!trovato) {
				return currCourse;
			}
		}
		return null;
	}

	//per ogni RuoloDocente, il docente che eroga i voti più alti
	public Map<RuoloDocente, List<Docente>> professorsHighestGradeForRole(){
		Map<RuoloDocente, List<Docente>> mapRoleProfessors = new HashMap<>();
		for (RuoloDocente currRole : RuoloDocente.values()) {
			List<Docente> professorsHighestGrade = new LinkedList<>();
			double currMaxGrade = 0;
			for (Docente currProfessor : allProfessorsForRole(currRole)) {
				if(averageGradeExameForProfessor(currProfessor) > currMaxGrade) {
					professorsHighestGrade.clear();
					professorsHighestGrade.add(currProfessor);
					currMaxGrade=averageGradeExameForProfessor(currProfessor);
				}
				if(averageGradeExameForProfessor(currProfessor) == currMaxGrade) {
					professorsHighestGrade.add(currProfessor);
				}
			}
			mapRoleProfessors.put(currRole, professorsHighestGrade);
		}
		return mapRoleProfessors;
	}
	
	//ritorna la lista di tutti i docenti aventi come ruolo quello passato in input 
	private List<Docente> allProfessorsForRole (RuoloDocente rd){
		List<Docente> professors = new LinkedList<>();
		for(Docente currProfessor : getProfessors()) {
			if(currProfessor.getRuoloDocente() == rd) {
				professors.add(currProfessor);
			}
		}
		return professors;
	}
	
	//La media dei voti dati da un Docente passato in input
	private double averageGradeExameForProfessor (Docente d) {
		double sumGrade = 0;
		int numExame = 0;
		for(Studente currStudent : elencoStudenti) {
			for(Esame currExam : currStudent.getEsamiSostenuti()) {
				if(currExam.getDocente().equals(d)) {
					sumGrade += currExam.getVoto();
					numExame++;
				}
			}
		}
		if(numExame == 0) {
			return 0;
		}
		return sumGrade/numExame;
	}
	
}
