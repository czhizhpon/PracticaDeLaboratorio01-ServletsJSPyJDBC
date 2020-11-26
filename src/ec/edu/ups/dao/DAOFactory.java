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
	public abstract CategoryDAO getCategoryDAO();
	public abstract CompanyDAO getCompanyDAO();
	public abstract ProductDAO getProductDAO();
	public abstract void getUerDAO();
	public abstract boolean close();
}
