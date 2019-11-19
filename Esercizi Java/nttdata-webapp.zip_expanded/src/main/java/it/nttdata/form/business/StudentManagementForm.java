package it.nttdata.form.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.nttdata.dao.IStudentMgtDao;
import it.nttdata.dao.entity.Corsi;
import it.nttdata.dao.entity.PianoDiStudi;
import it.nttdata.dao.entity.Studente;
import it.nttdata.dao.impl.StudentMgtDaoFakeImpl;
import it.nttdata.form.model.ExamDetailsForm;
import it.nttdata.form.model.StudentForm;

public class StudentManagementForm {
	
	//TODO: USE StudentMgtDaoFakeImpl
	private static IStudentMgtDao iStudentMgtDao = new StudentMgtDaoFakeImpl();
	
	//private static IStudentMgtDao iStudentMgtDao = new StudentMgtDaoImpl();
	
	public static List<StudentForm> selectAllStudentForm() {
		System.out.println("StudentManagementForm.selectAllStudentForm() IN");
		
		List<StudentForm> result = new ArrayList<>();

		for (Studente s : iStudentMgtDao.findAllStudente()) {

			result.add(new StudentForm(	s.getPkMatricola(), 
										String.valueOf(s.getFkIdCorsoLaurea()), 
										s.getNome(),
										s.getCognome(), 
										s.getCodiceFiscale(), 
										s.getSesso(), 
										s.getLocalita(), 
										s.getProvincia(),
										s.getDataNascita() != null ? new SimpleDateFormat("dd/MM/yyyy").format(s.getDataNascita()) : "", 
										s.getTelefono(), 
										s.getEmail(),
										s.getDataImmatricolazione() != null ? new SimpleDateFormat("dd/MM/yyyy").format(s.getDataImmatricolazione()) : "",
										s.getDataCessazione() != null ? s.getDataCessazione().toString() : ""));
		}

		System.out.println("StudentManagementForm.selectAllStudentForm() OUT result= "+result);
		return result;
	}
	
	public static StudentForm findStudentByIDForm(String matricola) {
		System.out.println("StudentManagementForm.findStudentByIDForm() IN matricola="+matricola);
		
		StudentForm result = null;

		Studente studente = iStudentMgtDao.findStudenteByMatricola(matricola);

		if (studente != null) {

			result = new StudentForm(	studente.getPkMatricola(), 
											String.valueOf(studente.getFkIdCorsoLaurea()), 
											studente.getNome(),
											studente.getCognome(), 
											studente.getCodiceFiscale(), 
											studente.getSesso(), 
											studente.getLocalita(), 
											studente.getProvincia(),
											studente.getDataNascita() != null ? new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataNascita()) : "", 
											studente.getTelefono(), 
											studente.getEmail(),
											studente.getDataImmatricolazione() != null ? new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataImmatricolazione()) : "",
											studente.getDataCessazione() != null ? new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataCessazione()) : "");	
		}

		System.out.println("StudentManagementForm.findStudentByIDForm() OUT result="+result);
		return result;
	}
	
	public static boolean insertStudentForm(HttpServletRequest request) throws Exception {
		System.out.println("StudentManagementForm.insertStudentForm() IN");
		
		boolean result = false;

		if (request != null) {
			String matricolaF = request.getParameter("matricola");
			String cognomeF = request.getParameter("cognome");
			String nomeF = request.getParameter("nome");
			String codiceFiscaleF = request.getParameter("codiceFiscale");
			String sessoF = request.getParameter("sesso");
			String localitaF = request.getParameter("localita");
			String provinciaF = request.getParameter("provincia");
			String telefonoF = request.getParameter("telefono");
			String emailF = request.getParameter("email");
			
			String dataNascitaF = request.getParameter("dataNascita");
			String dataImmaF = request.getParameter("dataImma");
			
			Studente newStudent = new Studente(	matricolaF,
												1, 
												nomeF, 
												cognomeF, 
												codiceFiscaleF,
												sessoF, 
												localitaF, 
												provinciaF, 
												new SimpleDateFormat("dd/MM/yyyy").parse(dataNascitaF), 
												telefonoF, 
												emailF,
												new SimpleDateFormat("dd/MM/yyyy").parse(dataImmaF), 
												null);
			
			
			
			iStudentMgtDao.addStudente(newStudent);

			for (Corsi c : iStudentMgtDao.findAllCorsi()) {
				iStudentMgtDao.addPianoDiStudi(new PianoDiStudi(newStudent.getPkMatricola(), c.getPkIdCorso(), 2019, 1));
			}
			
			result = true;
		}

		System.out.println("StudentManagementForm.insertStudentForm() OUT result="+result);
		return result;
	}
	
	public static boolean deleteStudentForm(String matricola) {
		System.out.println("StudentManagementForm.deleteStudentForm() IN matricola="+matricola);
		
		boolean result = false;

		if (matricola != null && iStudentMgtDao.delPianoDiStudi(matricola)) {
			result = iStudentMgtDao.delStudente(matricola);
		}

		System.out.println("StudentManagementForm.deleteStudentForm() IN result="+result);
		return result;
	}
	
	public static boolean updateStudentForm(HttpServletRequest request) throws Exception {
		System.out.println("StudentManagementForm.updateStudentForm() IN");
		
		boolean result = false;

		if (request != null) {
			String matricolaF = request.getParameter("matricola");
			
			String cognomeF = request.getParameter("cognome");
			String nomeF = request.getParameter("nome");
			String codiceFiscaleF = request.getParameter("codiceFiscale");
			String sessoF = request.getParameter("sesso");
			String localitaF = request.getParameter("localita");
			String provinciaF = request.getParameter("provincia");
			String telefonoF = request.getParameter("telefono");
			String emailF = request.getParameter("email");
			
			String dataNascitaF = request.getParameter("dataNascita");
			String dataImmaF = request.getParameter("dataImma");
			

			Studente studente = iStudentMgtDao.findStudenteByMatricola(matricolaF);

			studente.setCognome(cognomeF);
			studente.setNome(nomeF);
			studente.setCodiceFiscale(codiceFiscaleF);
			studente.setSesso(sessoF);
			studente.setLocalita(localitaF);
			studente.setProvincia(provinciaF);
			studente.setTelefono(telefonoF);
			studente.setEmail(emailF);
			studente.setDataNascita(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascitaF));
			studente.setDataImmatricolazione(new SimpleDateFormat("dd/MM/yyyy").parse(dataImmaF));

			iStudentMgtDao.updStudente(studente);

			result = true;
		}

		System.out.println("StudentManagementForm.updateStudentForm() OUT result="+result);
		return result;
	}
	
	public static List<ExamDetailsForm> selectAllExamForm(String matricola) {
		System.out.println("StudentManagementForm.selectAllExamForm() IN matricola="+matricola);
		List<ExamDetailsForm> listExam = new ArrayList<>();

		List<Object[]> examList = iStudentMgtDao.findAllExam(matricola);

		for (Object[] o : examList) {
			listExam.add(new ExamDetailsForm(	o[0].toString(), 
												o[1].toString(), 
												o[2].toString(), 
												o[3].toString(),
												o[4].toString(), 
												o[5].toString()));
		}

		System.out.println("StudentManagementForm.selectAllExamForm() IN listExam="+listExam);
		return listExam;
	}
	
	private StudentManagementForm() {
		
	}
}
