package it.nttdata.dao.resource;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class StatementExecutor {

	private static String[][] createArray(ResultSet r) {

		String[][] result = null;

		int numRows = 0;
		int numCols = 0;

		try {
			ResultSetMetaData rmtd = r.getMetaData();
			numCols = rmtd.getColumnCount();

			while (r.next()) {
				numRows++;
			}

			r.first();

			if (numRows > 0) {
				result = new String[numRows][numCols];
			}

			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					result[i][j] = r.getString(j + 1);
				}
				r.next();
			}

		} catch (Exception e) {
			result = null;
			e.printStackTrace();
		}

		return result;
	}

	public static String[][] select(String sql) {
		String[][] result = null;
		ResultSet rs = null;

		try {
			rs = ResourceManager.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			result = createArray(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.close(rs);
		}

		return result;
	}

	public static int update(String sql) {
		int result = 0;
		try {
			result = ResourceManager.getConnection().createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}

	private StatementExecutor() {
		
	}
	
}
