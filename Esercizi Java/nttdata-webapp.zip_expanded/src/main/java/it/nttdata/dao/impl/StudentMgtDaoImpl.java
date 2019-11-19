package it.nttdata.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import it.nttdata.dao.IStudentMgtDao;
import it.nttdata.dao.entity.Corsi;
import it.nttdata.dao.entity.PianoDiStudi;
import it.nttdata.dao.entity.Studente;
import it.nttdata.dao.resource.StatementExecutor;

public class StudentMgtDaoImpl implements IStudentMgtDao{
	
	@Override
	public boolean addStudente(Studente studente) {
		boolean result = false;

		if (studente != null) {
			StringBuilder sqlQuery = new StringBuilder();
			
			sqlQuery.append("Insert into STUDENTI (PK_MATRICOLA, FK_ID_CORSO_LAUREA, NOME, COGNOME, CODICE_FISCALE, SESSO, LOCALITA, PROVINCIA, DATA_NASCITA, TELEFONO, EMAIL, DATA_IMMATRICOLAZIONE, DATA_CESSAZIONE) ");
			sqlQuery.append("VALUES (");
			sqlQuery.append("'").append(studente.getPkMatricola()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append(studente.getFkIdCorsoLaurea());
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getNome()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getCognome()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getCodiceFiscale()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getSesso()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getLocalita()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getProvincia()).append("'");
			sqlQuery.append(", ");			
			sqlQuery.append("TO_DATE('").append(new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataNascita())).append("'");
			sqlQuery.append(", 'DD/MM/YYYY')");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getTelefono()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getEmail()).append("'");
			sqlQuery.append(", ");		
			sqlQuery.append("TO_DATE('").append(new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataImmatricolazione())).append("'");
			sqlQuery.append(", 'DD/MM/YYYY')");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(studente.getDataCessazione()!=null ?studente.getDataCessazione() :"").append("'");
			sqlQuery.append(")");
			
			result = StatementExecutor.update(sqlQuery.toString()) > 0;
		}

		return result;
	}

	@Override
	public boolean updStudente(Studente studente) {
		boolean result = false;

		if (studente != null) {
			StringBuilder sqlQuery = new StringBuilder();
			
			sqlQuery.append("UPDATE STUDENTI SET ");
			sqlQuery.append("fk_id_corso_laurea");
			sqlQuery.append("=");
			sqlQuery.append(studente.getFkIdCorsoLaurea());
			sqlQuery.append(", ");
			sqlQuery.append("nome");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getNome()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("cognome");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getCognome()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("codice_fiscale");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getCodiceFiscale()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("sesso");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getSesso()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("localita");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getLocalita()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("provincia");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getProvincia()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("data_nascita");
			sqlQuery.append("=");
			sqlQuery.append("TO_DATE('").append(new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataNascita())).append("'");
			sqlQuery.append(", 'DD/MM/YYYY')");
			sqlQuery.append(", ");
			sqlQuery.append("telefono");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getTelefono()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("email");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getEmail()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("data_immatricolazione");
			sqlQuery.append("=");
			sqlQuery.append("TO_DATE('").append(new SimpleDateFormat("dd/MM/yyyy").format(studente.getDataImmatricolazione())).append("'");
			sqlQuery.append(", 'DD/MM/YYYY')");
			sqlQuery.append(", ");
			sqlQuery.append("data_cessazione");
			sqlQuery.append("=");
			sqlQuery.append("'").append(studente.getDataCessazione() != null ? studente.getDataCessazione() : "").append("'");
			sqlQuery.append(" ");
			sqlQuery.append("WHERE pk_matricola=");
			sqlQuery.append("'");
			sqlQuery.append(studente.getPkMatricola());
			sqlQuery.append("'");

			result = StatementExecutor.update(sqlQuery.toString()) > 0;
		}

		return result;
	}

	@Override
	public boolean delStudente(String matricola) {
		boolean result = false;

		if (matricola != null && matricola.length() > 0) {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("DELETE FROM studenti");
			sqlQuery.append(" ");
			sqlQuery.append("WHERE pk_matricola=");
			sqlQuery.append("'");
			sqlQuery.append(matricola);
			sqlQuery.append("'");

			result = StatementExecutor.update(sqlQuery.toString()) > 0;
		}

		return result;
	}

	@Override
	public Studente findStudenteByMatricola(String matricola) {
		Studente result = null;

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT pk_matricola, fk_id_corso_laurea, nome, cognome, codice_fiscale, sesso, localita, provincia, data_nascita, telefono, email, data_immatricolazione, data_cessazione FROM studenti");
		sqlQuery.append(" ");
		sqlQuery.append("WHERE pk_matricola=");
		sqlQuery.append("'");
		sqlQuery.append(matricola);
		sqlQuery.append("'");

		if (matricola != null && matricola.length() > 0) {

			String[][] resultSql = StatementExecutor.select(sqlQuery.toString());

			if (resultSql != null && resultSql.length > 0) {
				try {
					result = new Studente(	resultSql[0][0],
											resultSql[0][1] != null ? Integer.parseInt(resultSql[0][1]) : 0, 
											resultSql[0][2],
											resultSql[0][3], 
											resultSql[0][4], 
											resultSql[0][5], 
											resultSql[0][6], 
											resultSql[0][7],
											resultSql[0][8] != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSql[0][8]) : null,
											resultSql[0][9], 
											resultSql[0][10],
											resultSql[0][11] != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSql[0][11]) : null,
											resultSql[0][12] != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSql[0][12]) : null);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public List<Studente> findAllStudente() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT pk_matricola, fk_id_corso_laurea, nome, cognome, codice_fiscale, sesso, localita, provincia, data_nascita, telefono, email, data_immatricolazione, data_cessazione FROM studenti");
		sqlQuery.append(" ");
		sqlQuery.append("ORDER BY cognome ASC");
		
		String[][] resultSql = StatementExecutor.select(sqlQuery.toString());
		List<Studente> result = null;

		if (resultSql != null && resultSql.length > 0) {

			result = new ArrayList<>();

			for (int row = 0; row < resultSql.length; row++) {

				try {
					result.add(new Studente(resultSql[row][0],
											resultSql[row][1] != null ? Integer.parseInt(resultSql[row][1]) : 0, 
											resultSql[row][2],
											resultSql[row][3], 
											resultSql[row][4], 
											resultSql[row][5], 
											resultSql[row][6],
											resultSql[row][7],
											resultSql[row][8] != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSql[row][8]) : null,
											resultSql[row][9], 
											resultSql[row][10],
											resultSql[row][11] != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSql[row][11]) : null,
											resultSql[row][12] != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSql[row][12]) : null));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}
	
	@Override
	public List<Corsi> findAllCorsi() {
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append("SELECT pk_id_corso, denominazione, cfu, settore, fk_tipologia, fk_id_corso_laurea, fk_id_docente, flag_opzionale FROM corsi");
		sqlQuery.append(" ");
		sqlQuery.append("ORDER BY pk_id_corso ASC");

		String[][] resultSql = StatementExecutor.select(sqlQuery.toString());

		List<Corsi> result = null;

		if (resultSql != null && resultSql.length > 0) {

			result = new ArrayList<>();

			for (int row = 0; row < resultSql.length; row++) {

				result.add(new Corsi(	resultSql[row][0] != null ? Integer.parseInt(resultSql[row][0]) : 0, 
										resultSql[row][1], 
										resultSql[row][2] != null ? Integer.parseInt(resultSql[row][2]) : 0, 
										resultSql[row][3], 
										resultSql[row][4],
										resultSql[row][5] != null ? Integer.parseInt(resultSql[row][5]) : 0,
										resultSql[row][6] != null ? Integer.parseInt(resultSql[row][6]) : 0, 
										resultSql[row][7]));
			}
		}

		return result;
	}

	@Override
	public boolean addPianoDiStudi(PianoDiStudi pianoDiStudi) {
		boolean result = false;

		if (pianoDiStudi != null) {
			StringBuilder sqlQuery = new StringBuilder();

			sqlQuery.append("INSERT INTO piano_di_studi (fk_matricola, fk_id_corso, anno, semestre) ");
			sqlQuery.append("VALUES (");
			sqlQuery.append("'").append(pianoDiStudi.getFkMatricola()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(pianoDiStudi.getFkIdCorso()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(pianoDiStudi.getAnno()).append("'");
			sqlQuery.append(", ");
			sqlQuery.append("'").append(pianoDiStudi.getSemestre()).append("'");
			sqlQuery.append(")");
			
			result = StatementExecutor.update(sqlQuery.toString()) > 0;
		}

		return result;
	}

	@Override
	public boolean delPianoDiStudi(String matricola) {
		boolean result = false;

		if (matricola != null && matricola.length() > 0) {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("DELETE FROM piano_di_studi");
			sqlQuery.append(" ");
			sqlQuery.append("WHERE fk_matricola=");
			sqlQuery.append("'");
			sqlQuery.append(matricola);
			sqlQuery.append("'");

			result = StatementExecutor.update(sqlQuery.toString()) > 0;
		}

		return result;
	}

	@Override
	public List<Object[]> findAllExam(String matricola) {

		List<Object[]> result = new ArrayList<>();

		if (matricola != null && matricola.length() > 0) {
			StringBuilder sqlQuery = new StringBuilder();

			sqlQuery.append("SELECT s.fk_id_corso_laurea, s.pk_matricola, c.denominazione, c.cfu, ps.anno, ps.semestre FROM studenti s, piano_di_studi ps, corsi c ");
			sqlQuery.append(" ");
			sqlQuery.append("WHERE ps.fk_matricola=s.pk_matricola AND ps.fk_id_corso=c.pk_id_corso AND ");
			sqlQuery.append("s.pk_matricola=");
			sqlQuery.append("'");
			sqlQuery.append(matricola);
			sqlQuery.append("'");
			sqlQuery.append(" ");
			sqlQuery.append("ORDER BY anno ASC");

			String[][] resultSql = StatementExecutor.select(sqlQuery.toString());

			if (resultSql != null && resultSql.length > 0) {

				for (int row = 0; row < resultSql.length; row++) {
					result.add(new Object[] { resultSql[row][0], resultSql[row][1], resultSql[row][2], resultSql[row][3], resultSql[row][4], resultSql[row][5] });
				}
			}
		}
		
		return result;
	}

}
