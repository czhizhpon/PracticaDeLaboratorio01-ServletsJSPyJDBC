package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.JDBCDAOFactory;

public abstract class DAOFactory {
protected static DAOFactory factory = new JDBCDAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract void createTables();
	public abstract BillDetailDAO getBillDetailDAO();
	public abstract BillHeadDAO getBillHeadDAO();
	public abstract void getCategoryDAO();
	public abstract CompanyDAO getCompanyDAO();
	public abstract void getProductDAO();
	public abstract UserDAO getUserDAO();
	public abstract boolean close();
}
