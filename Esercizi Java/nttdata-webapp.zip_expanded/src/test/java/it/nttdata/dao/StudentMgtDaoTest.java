package it.nttdata.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.nttdata.dao.entity.Studente;
import it.nttdata.dao.impl.StudentMgtDaoFakeImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMgtDaoTest {

	private static IStudentMgtDao iStudentMgtDao = null;

	@BeforeClass
	public static void initCalculator() {
		iStudentMgtDao = new StudentMgtDaoFakeImpl();
	}

	@Test
	public void testAFindAllStudente() {
		List<Studente> studenteList = iStudentMgtDao.findAllStudente();

		assertTrue(!studenteList.isEmpty());
	}

	@Test
	public void testBFindStudenteByMatricola() {
		String matricola = "AA001";

		Studente studente = iStudentMgtDao.findStudenteByMatricola(matricola);

		assertEquals(matricola, studente.getPkMatricola());
	}

	@Test
	public void testCAddStudente() throws Exception {
		Studente newStudente = new Studente("AA100", 
											1, 
											"Maria_ADD", 
											"Liparulo_ADD", 
											"MLADNL85A08D_DD", 
											"F",
											"Napoli_ADD", "NA", 
											new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1984-10-08 14:43:11"),
											"33615286", 
											"danilo@mail.com", 
											new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-01 14:50:00"),
											null);
		
		boolean operation = iStudentMgtDao.addStudente(newStudente);

		assertTrue(operation);
	}

	
}
