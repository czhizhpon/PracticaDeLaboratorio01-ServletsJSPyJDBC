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
		
		compDAO.create(new Company("NuvaTech"));
		compDAO.create(new Company("NuvaHome"));
		compDAO.create(new Company("NuvaFood"));
		
		Company cm = new Company();
		cm.setComId(1);
		
		User[] usersList = new User[4];
		
		for (int i = 0; i < usersList.length; i++) {
			usersList[i] = new User();
			usersList[i].setUseUsername("username"+i);
			usersList[i].setUseEmail("email" + i + "@example.com");
			usersList[i].setUseName("Name"+i);
			usersList[i].setUseLastname("LastName"+i);
			usersList[i].setUsePassword("password"+i);
			usersList[i].setUseRole('U');
			usersList[i].setUseCompany(cm);
			userDAO.create(usersList[i]);
		}
		
		
		Category catc1 = new Category();
		catc1.setCatId(1);
		catc1.setCatName("Categoria1");
		catc1.setCatCompany(cm);
		cat.create(catc1);
		
		Category catc2 = new Category();
		catc2.setCatId(2);
		catc2.setCatName("Categoria2");
		catc2.setCatCompany(cm);
		cat.create(catc2);
		
		Product pro = new Product();
		
		for (int i = 0; i < 30; i++) {
			pro = new Product();
			pro.setProId(i+1);
			pro.setProName("Producto"+ (i+1));
			pro.setProStock(10);
			pro.setProPrice(22.5);
			pro.setProCategory(catc1);
			
			p.create(pro);
		}
		
		for (int j = 30; j < 60; j++) {
			pro = new Product();
			
			pro.setProId(j+1);
			pro.setProName("Producto"+ (j+1));
			pro.setProStock(10);
			pro.setProPrice(22.5);
			pro.setProCategory(catc2);
			
			p.create(pro);
		}
		
		System.out.println("\nSe ha creado...");
		System.out.println("Cierre: " + DAOFactory.getFactory().close());
		
	}

}
