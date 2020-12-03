package ec.edu.ups.test;

import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.Product;
import ec.edu.ups.model.User;

public class CreateTables {

	public static void main(String[] args) {
		UserDAO userDAO = DAOFactory.getFactory().getUserDAO();
		CompanyDAO compDAO = DAOFactory.getFactory().getCompanyDAO();
		CategoryDAO cat = DAOFactory.getFactory().getCategoryDAO();
		ProductDAO p = DAOFactory.getFactory().getProductDAO();
		
		DAOFactory.getFactory().createTables();
		Company company = new Company();
		company.setComName("NuvaTech");
		compDAO.create(company);
		company.setComName("NuvaHome");
		compDAO.create(company);
		company.setComName("NuvaFood");
		compDAO.create(company);
		
		Company cm = new Company();
		cm.setComId(1);
		
		User[] usersList = new User[4];
		
		for (int i = 0; i < usersList.length; i++) {
			usersList[i] = new User();
			usersList[i].setUseUsername("e1u"+i);
			usersList[i].setUseEmail("email" + i + "@emp1.com");
			usersList[i].setUseName("Name"+i);
			usersList[i].setUseLastname("LastName"+i);
			usersList[i].setUsePassword("pass"+i);
			usersList[i].setUseRole('U');
			usersList[i].setUseCompany(cm);
			userDAO.create(usersList[i]);
		}
		
		Company cm2 = new Company();
		cm2.setComId(2);
		
		for (int i = 0; i < usersList.length; i++) {
			usersList[i] = new User();
			usersList[i].setUseUsername("e2u"+i);
			usersList[i].setUseEmail("email" + i + "@emp2.com");
			usersList[i].setUseName("Name"+i);
			usersList[i].setUseLastname("LastName"+i);
			usersList[i].setUsePassword("pass"+i);
			usersList[i].setUseRole('U');
			usersList[i].setUseCompany(cm2);
			userDAO.create(usersList[i]);
		}
		
		
		Category catc1 = new Category();
		catc1.setCatId(1);
		catc1.setCatName("Cat 1 Emp 1");
		catc1.setCatCompany(cm);
		cat.create(catc1);
		
		Category catc2 = new Category();
		catc2.setCatId(2);
		catc2.setCatName("Cat 2 Emp 1");
		catc2.setCatCompany(cm);
		cat.create(catc2);
		
		Category catc3 = new Category();
		catc3.setCatId(3);
		catc3.setCatName("Cat 1 Emp 2");
		catc3.setCatCompany(cm2);
		cat.create(catc3);
		
		Category catc4 = new Category();
		catc4.setCatId(4);
		catc4.setCatName("Cat 2 Emp 2");
		catc4.setCatCompany(cm2);
		cat.create(catc4);
		
		Product pro = new Product();
		
		for (int i = 0; i < 15; i++) {
			pro = new Product();
			pro.setProId(i+1);
			pro.setProName("E1Producto"+ (i+1));
			pro.setProStock(10);
			pro.setProPrice(22.5);
			pro.setProCategory(catc1);
			
			p.create(pro);
		}
		
		for (int j = 15; j < 30; j++) {
			pro = new Product();
			pro.setProId(j+1);
			pro.setProName("E1Producto"+ (j+1));
			pro.setProStock(10);
			pro.setProPrice(22.5);
			pro.setProCategory(catc2);
			
			p.create(pro);
		}
		
		for (int i = 0; i < 15; i++) {
			pro = new Product();
			pro.setProId(i+1);
			pro.setProName("E2Producto"+ (i+1));
			pro.setProStock(10);
			pro.setProPrice(22.5);
			pro.setProCategory(catc3);
			
			p.create(pro);
		}
		
		for (int j = 15; j < 30; j++) {
			pro = new Product();
			
			pro.setProId(j+1);
			pro.setProName("E2Producto"+ (j+1));
			pro.setProStock(10);
			pro.setProPrice(22.5);
			pro.setProCategory(catc4);
			
			p.create(pro);
		}
		
		System.out.println("\nSe ha creado...");
		System.out.println("Cierre: " + DAOFactory.getFactory().close());
	}

}
