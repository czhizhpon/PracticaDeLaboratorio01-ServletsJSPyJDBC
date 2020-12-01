package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.dao.UserDAO;

public class JDBCDAOFactory extends DAOFactory{

	@Override
	public void createTables() {
		String sql;
		
		sql = "DROP TABLE IF EXISTS bill_details";
		ContextJDBC.getJDBC().update(sql);
		sql = "DROP TABLE IF EXISTS products";
		ContextJDBC.getJDBC().update(sql);
		sql = "DROP TABLE IF EXISTS bill_heads";
		ContextJDBC.getJDBC().update(sql);
		sql = "DROP TABLE IF EXISTS users";
		ContextJDBC.getJDBC().update(sql);
		sql = "DROP TABLE IF EXISTS categories";
		ContextJDBC.getJDBC().update(sql);
		sql = "DROP TABLE IF EXISTS companies";
		ContextJDBC.getJDBC().update(sql);
		getCompanyDAO().createTable();
		getUserDAO().createTable();
		getCategoryDAO().createTable();
		getProductDAO().createTable();
		getBillHeadDAO().createTable();
		getBillDetailDAO().createTable();
	}

	@Override
	public BillDetailDAO getBillDetailDAO() {
		return new JDBCBillDetailDAO();
	}

	@Override
	public BillHeadDAO getBillHeadDAO() {
		return new JDBCBillHeadDAO();
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return new JDBCCategoryDAO();
		
	}

	@Override
	public CompanyDAO getCompanyDAO() {
		return new JDBCCompanyDAO();
		
	}

	@Override
	public ProductDAO getProductDAO() {
		return new JDBCProductDAO();
		
	}

	@Override
	public UserDAO getUserDAO() {
		return new JDBCUserDAO();
		
	}

	public boolean close() {
		return ContextJDBC.getJDBC().close();
	}
	
}
