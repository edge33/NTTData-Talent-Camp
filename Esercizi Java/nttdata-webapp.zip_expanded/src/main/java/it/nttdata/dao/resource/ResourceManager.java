package it.nttdata.dao.resource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceManager {

	private static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String JDBC_URL = "jdbc:oracle:thin:@10.186.16.88:1521:ORCL11R2";
	private static String JDBC_USER = "JAVA_TALENT";
	private static String JDBC_PASSWORD = "JAVA_TALENT";
	
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				@SuppressWarnings("rawtypes")
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.err.println("Failed to initialise JDBC driver" + e);
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("Failed to initialise JDBC driver" + e);
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.err.println("Failed to initialise JDBC driver" + e);
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			System.err.println("Failed to initialise JDBC driver" + e);
		}
	}
}