package ec.edu.ups.test;

import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.Company;

public class TablesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CompanyDAO compDAO = DAOFactory.getFactory().getCompanyDAO();
		compDAO.createTable();
		
		compDAO.create(new Company("NuvaTech"));

	}

}
