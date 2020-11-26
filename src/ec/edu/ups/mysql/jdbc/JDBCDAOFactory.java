package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;

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
	public CategoryDAO getCategoryDAO() {
		return new JDBCCategoryDAO();
		
	}

	@Override
	public CompanyDAO getCompanyDAO() {
		return null;
		//Roby edito xq no podia cargar mi parte sin esta opcion
		
	}

	@Override
	public ProductDAO getProductDAO() {
		return new JDBCProductDAO();
		
	}

	@Override
	public void getUerDAO() {
		// TODO Auto-generated method stub
		
	}

	public boolean close() {
		return ContextJDBC.getJDBC().close();
	}
	
}
