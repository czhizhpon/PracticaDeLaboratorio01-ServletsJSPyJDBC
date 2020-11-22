package ec.edu.ups.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/sgrc";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private static ContextJDBC jdbc = null;
	private Statement statement = null;
	
	public ContextJDBC() {
		connect();
	}
	
	protected static ContextJDBC getJDBC() {
		if(jdbc == null)
			jdbc = new ContextJDBC();
		return jdbc;
	}
	
	private void connect() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(">>>WARNING (JDBC:Connect)... Problemas con el driver");
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:Connect)... Problemas con la BD");
		}
	}
	
	public ResultSet query(String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:query): --- \n" + sql + "\n ---\n" + e);
		}
		return null;
	}
	
	public boolean update(String sql) {
		try {
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:update): --- \n" + sql + "\n ---\n" + e);
		} catch (Exception e) {
			System.out.println(">>>WARNING GLOBAL (JDBC:update): --- \n" + sql + "\n ---\n" + e);
		}
		return false;
	}
	
	public boolean close() {
		try {
			statement.getConnection().close();
			return true;
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:close): " + e);
		} catch (Exception e) {
			System.out.println(">>>WARNING GLOBAL (JDBC:close): " + e);
		}
		return false;
	}
}
