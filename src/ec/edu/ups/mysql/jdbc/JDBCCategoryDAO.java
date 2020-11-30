package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.Product;

/**
 * Servlet implementation class JDBCCategoryDAO
 */
@WebServlet("/JDBCCategoryDAO")
public class JDBCCategoryDAO extends JDBCGenericDAO<Category, Integer> implements CategoryDAO {

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS products ");
		jdbc.update("DROP TABLE IF EXISTS categories ");
		jdbc.update("DROP TABLE IF EXISTS companies ");

		jdbc.update("CREATE TABLE companies ("
				+"com_id INT NOT NULL AUTO_INCREMENT "
				+ "PRIMARY KEY )"
				);
		
		jdbc.update("INSERT INTO companies VALUES "
				+ "(NULL)");
		
		jdbc.update("CREATE TABLE categories ( "
				+ "cat_id INT NOT NULL AUTO_INCREMENT, "
				+ "cat_name VARCHAR(255), "
				+ "cat_deleted BOOLEAN DEFAULT '0', "
				+ "com_id INT, "
				+ "PRIMARY KEY (cat_id), "
				+ "FOREIGN KEY(com_id) REFERENCES companies(com_id) "
				+ ") ");
		DAOFactory.getFactory().getProductDAO().createTable();
	}

	@Override
	public void create(Category category) {
		String sql = "INSERT INTO categories VALUES( "
				+ "NULL" + ", '"
				+ category.getCatName() + "', "
				+ "DEFAULT, "
				+ category.getCatCompany().getComId()
				+ ") ";
		jdbc.update(sql);
		List<Product> products = category.getCatProducts();
		if(products != null) {
			for(Product product : products) {
				DAOFactory.getFactory().getProductDAO().create(product);
			}
		}
	}

	@Override
	public Category read(Integer id) {
		Category category = null;
		ResultSet rsCategory = jdbc.query("SELECT * FROM categories WHERE cat_id = " + id);
		try {
			if (rsCategory.next()) {
				Company company = new Company();
				company.setComId(1);
				category = getCategory(rsCategory);
				List<Product> products = DAOFactory.getFactory().getProductDAO().findByCategoryId(rsCategory.getInt("cat_id"));
				category.setCatProducts(products);
				category.setCatCompany(company);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:read): " + e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:read:GLOBAL): " + e.getMessage());
		}
		return category;
	}

	@Override
	public void update(Category category) {
		String sql = "UPDATE categories SET "
				+ "cat_name = '" + category.getCatName() + "', "
				+ "com_id = " + category.getCatCompany() + " "
				+ "WHERE cat_id = " + category.getCatId() + " ";
		jdbc.update(sql);
		ProductDAO productDAO = DAOFactory.getFactory().getProductDAO();
		List<Product> products = productDAO.findByCategoryId(category.getCatId());
		if (category.getCatProducts() == null && products != null) {
			for (Product product : products) {
				productDAO.delete(product);
			}
		} else if (category.getCatProducts() != null && products == null) {
			for (Product product : category.getCatProducts()) {
				productDAO.create(product);
			}
		} else if (category.getCatProducts() != null && products != null) {
			for (Product product : products) {
				productDAO.update(product);
			}
		}
	}

	@Override
	public void delete(Category category) {
		String sql = "UPDATE categories SET "
				+ "cat_deleted = '1' "
				+ "WHERE cat_id = " + category.getCatId() + " ";
		jdbc.update(sql);
		
	}

	@Override
	public List<Category> find() {
		List<Category> categories = new ArrayList<Category>();
		ResultSet rsCategory = jdbc.query("SELECT * FROM categories");
		try {
			while(rsCategory.next()) {
				if (!rsCategory.getBoolean("cat_deleted")) {
					Category category = getCategory(rsCategory);
					categories.add(category);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:find): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:find:GLOBAL): " 
					+ e.getMessage());
		}
		return categories;
	}

	@Override
	public List<Category> findByProductId(int id) {
		List<Category> categories = new ArrayList<Category>();
		ResultSet rsCategory = jdbc.query("SELECT * FROM categories WHERE "
				+ "cat_id = " + id);
		try {
			while(rsCategory.next()) {
				if (!rsCategory.getBoolean("cat_deleted")) {
					Category category = getCategory(rsCategory);
					categories.add(category);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:findByProductId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:findByProductId:GLOBAL): " 
					+ e.getMessage());
		}
		return categories;
	}

	@Override
	public Category getCategory(ResultSet rsCategory) {
		Category category = null;
		try {
			if(rsCategory != null && !rsCategory.getBoolean("cat_deleted")) {
				category = new Category();
				category.setCatId(rsCategory.getInt("cat_id"));
				category.setCatName(rsCategory.getString("cat_name"));
				category.setCatDeleted(false);
			}
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:findCategoryId:GLOBAL): " 
					+ e.getMessage());
		}
		return category;
	}

	@Override
	public List<Category> findByCompanyId(int id) {
		List<Category> categories = new ArrayList<Category>();
		Category category = null;
		ResultSet rsCategory = jdbc.query("SELECT * FROM categories WHERE "
				+ "com_id = " + id + " AND cat_deleted = '0'");
		try {
			while(rsCategory.next()) {
				if (!rsCategory.getBoolean("cat_deleted")) {
					category = getCategory(rsCategory);
					categories.add(category);
				}
			}
			
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:findByCompanyId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:ffindByCompanyId:GLOBAL): " 
					+ e.getMessage());
		}
		return categories;
	}

}
