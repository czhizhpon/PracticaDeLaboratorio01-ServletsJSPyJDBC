package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;

public class JDBCDAOFactory extends DAOFactory{

	@Override
	public void createTables() {
		
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
	public void getCategoryDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCompanyDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getProductDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUerDAO() {
		// TODO Auto-generated method stub
		
	}

	public boolean close() {
		return ContextJDBC.getJDBC().close();
	}
	
}
