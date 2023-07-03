package comPadrao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import comPadrao.Exceptions.DatabaseConnectionException;
import comPadrao.Exceptions.JDBCDriverNotFoundException;

public class DatabaseConnection {
	public Connection getConnection(String driver, String url, String user, String pwd)
			throws JDBCDriverNotFoundException, DatabaseConnectionException {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException cnfe) {
			throw new JDBCDriverNotFoundException("Driver JDBC não encontrado: " + driver);
		} catch (SQLException se) {
			throw new DatabaseConnectionException("Não foi possível conectar ao banco de dados: " + se.getMessage());
		}

		return conn;
	}
}
