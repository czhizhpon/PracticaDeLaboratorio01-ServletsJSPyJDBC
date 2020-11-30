package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.User;

public class JDBCUserDAO extends JDBCGenericDAO<User, Integer> 
							implements UserDAO {

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS users");
		
		// Pruebas
		jdbc.update("DROP TABLE IF EXISTS companies");
		jdbc.update("CREATE TABLE companies (com_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)");
		jdbc.update("INSERT INTO companies VALUES(NULL)");
		//
		
		// SQL
		jdbc.update("CREATE TABLE users"
				+ " ( "
				+ "use_id INT NOT NULL AUTO_INCREMENT, "
				+ "use_username VARCHAR(255) NOT NULL UNIQUE, "
				+ "use_email VARCHAR(255) NOT NULL UNIQUE, "
				+ "use_password VARCHAR(255) NOT NULL, "
				+ "use_name VARCHAR(255) NOT NULL, "
				+ "use_lastname VARCHAR(255) NOT NULL, "
				+ "use_role VARCHAR(1) NOT NULL, "
				+ "use_deleted BOOLEAN DEFAULT '0', "
				+ "com_id INT, "
				+ "PRIMARY KEY (use_id), "
				+ "FOREIGN KEY (com_id) REFERENCES companies(com_id) "
				+ ") ");
	}

	@Override
	public void create(User user) {		
		String sql = "INSERT INTO users "
				+ "(use_username, use_email, use_password, use_name, "
				+ "use_lastname, use_role, com_id)"
				+ " VALUES( "
				//+ "NULL" + ", "
				+ "'" + user.getUseUsername() + "', "
				+ "'" + user.getUseEmail() + "', "
				+ "'" + user.getUsePassword() + "', "
				+ "'" + user.getUseName() + "', "
				+ "'" + user.getUseLastname() + "', "
				+ "'" + user.getUseRole() + "', "
				//+ "DEFAULT, "
				+ (user.getUseCompany() == null ? "NULL" : 
					user.getUseCompany().getComId()) + " "
				+ ") ";
		
		//System.out.println(sql);
		jdbc.update(sql);
		
	}

	@Override
	public User read(Integer id) {
		User user = null;
		String query = "SELECT * FROM users WHERE use_id = " + id;
		ResultSet rsUser = jdbc.query(query);
		
		try {
			if (rsUser.next()) {
				user = getUser(rsUser);
				Company company = new Company();
				company.setComId(rsUser.getInt("com_id"));
				user.setUseCompany(company);
				
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " 
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read:GLOBAL): " 
					+ e.getMessage());
		}
		
		return user;
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET "
				+ "use_username = '" + user.getUseUsername() + "', "
				+ "use_email = '" + user.getUseEmail() + "', "
				+ "use_password = '" + user.getUsePassword() + "', " 
				+ "use_name = '" + user.getUseName() + "', " 
				+ "use_lastname = '" + user.getUseLastname() + "', " 
				+ "use_role = '" + user.getUseRole() + "' "
				+ "WHERE use_id = " + user.getUseId() + " ";
		
		jdbc.update(sql);
	}

	@Override
	public void delete(User user) {
		String sql = "UPDATE users SET "
				+ "use_deleted = '1' "
				+ "WHERE use_id = " + user.getUseId() + " ";
		
		jdbc.update(sql);
	}

	@Override
	public List<User> find() {
		List<User> usersList = new ArrayList<User>();
		String query = "SELECT * FROM users";
		ResultSet rsUsersList = jdbc.query(query);
		
		try {
			while (rsUsersList.next()) {
				if (!rsUsersList.getBoolean("use_deleted")) {
					User user = getUser(rsUsersList);
					usersList.add(user);
				}
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:find): " 
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCUserDAO:find:GLOBAL): " 
					+ e.getMessage());
		}
		
		return usersList;
	}
	
	@Override
	public User getUser(ResultSet rsUser) {
		User user = null;
		
		try {
			
			if (rsUser != null && !rsUser.getBoolean("use_deleted")) {
				user = new User();
				user.setUseId(rsUser.getInt("use_id"));
				user.setUseUsername(rsUser.getString("use_username"));
				user.setUseEmail(rsUser.getString("use_email"));
				user.setUsePassword(rsUser.getString("use_password"));
				user.setUseName(rsUser.getString("use_name"));
				user.setUseLastname(rsUser.getString("use_lastname"));
				user.setUseRole(rsUser.getString("use_role").charAt(0));
				user.setUseDeleted(false);
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:getUser): " 
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCUserDAO:getUser:GLOBAL): " 
					+ e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public List<User> findByCompanyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
