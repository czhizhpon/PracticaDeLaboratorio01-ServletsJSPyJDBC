package ec.edu.ups.test;

import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.Product;

public class Products {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CategoryDAO cat = DAOFactory.getFactory().getCategoryDAO();
		ProductDAO p = DAOFactory.getFactory().getProductDAO();
		
		cat.createTable();
				
		Company cm = new Company();
		cm.setComId(1);
		cm.setComName("Compania");
		
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
		
		System.out.println(cat.read(1));
		
//		catc1.setCatName("Ver");
//		cat.update(catc1);
//		System.out.println(cat.read(1));
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
		
		System.out.println(p.read(1));

		
//		pro.setProStock(20);
//		p.update(pro);
//		
//		System.out.println(p.read(1));
		
//		p.delete(pro);
		
		
	}

}
