package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.model.Company;

public class JDBCCompanyDAO extends JDBCGenericDAO<Company, Integer> 
								implements CompanyDAO {

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS companies");
		
		// SQL
		jdbc.update("CREATE TABLE companies"
				+ " ( "
				+ "com_id INT NOT NULL AUTO_INCREMENT, "
				+ "com_name VARCHAR(255) NOT NULL, "
				+ "com_deleted BOOLEAN DEFAULT '0', "
				+ "PRIMARY KEY (com_id) "
				+ ") ");
		
		// Llamar al create de Users.
	}

	@Override
	public int create(Company company) {
		String sql = "INSERT INTO companies "
				+ "(com_name)"
				+ " VALUES( "
				//+ "NULL" + ", "
				+ "'" + company.getComName() + "', "
				//+ "DEFAULT, "
				+ ") ";
		//System.out.println(sql);
		return jdbc.update(sql);
	}

	@Override
	public Company read(Integer id) {
		Company company = null;
		String query = "SELECT * FROM companies WHERE com_id = " + id;
		ResultSet rsCompany = jdbc.query(query);
		
		try {
			if (rsCompany.next()) {
				company = getCompany(rsCompany);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCompanyDAO:read): " 
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCompanyDAO:read:GLOBAL): " 
					+ e.getMessage());
		}
		
		return company;
	}

	@Override
	public void update(Company company) {
		String sql = "UPDATE companies SET "
				+ "use_username = '" + company.getComName() + "', "
				+ "WHERE com_id = " + company.getComId() + " ";
		
		jdbc.update(sql);
	}

	@Override
	public void delete(Company company) {
		String sql = "UPDATE companies SET "
				+ "com_deleted = '1' "
				+ "WHERE com_id = " + company.getComId() + " ";
		
		jdbc.update(sql);
	}

	@Override
	public List<Company> find() {

		

		
		return null;
	}
	
	@Override
	public Company getCompany(ResultSet rsCompany) {
		Company company = null;
		
		try {
			if (rsCompany != null && !rsCompany.getBoolean("com_deleted")) {
				company = new Company();
				company.setComId(rsCompany.getInt("com_id"));
				company.setComName(rsCompany.getString("com_name"));
				company.setComDeleted(false);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCompanyDAO:getCompany): " 
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCompanyDAO:getCompany:GLOBAL): " 
					+ e.getMessage());
		}
		
		return company;
	}

}
