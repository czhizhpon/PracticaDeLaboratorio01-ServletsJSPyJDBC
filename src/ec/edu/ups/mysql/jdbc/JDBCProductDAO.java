package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.Product;

/**
 * Servlet implementation class JDBCProductDAO
 */
@WebServlet("/JDBCProductDAO")
public class JDBCProductDAO extends JDBCGenericDAO<Product, Integer> implements ProductDAO {

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS products ");
		
		jdbc.update("CREATE TABLE products ( "
				+ "pro_id INT NOT NULL AUTO_INCREMENT, "
				+ "pro_name VARCHAR(255), "
				+ "pro_stock INT, "
				+ "pro_price DECIMAL(12,2), "
				+ "pro_deleted BOOLEAN DEFAULT '0', "
				+ "com_id INT, "
				+ "cat_id INT, "
				+ "PRIMARY KEY (pro_id), "
				+ "FOREIGN KEY(com_id) REFERENCES companies(com_id), "
				+ "FOREIGN KEY(cat_id) REFERENCES categories(cat_id) "
				+ ") ");
		
	}

	@Override
	public void create(Product product) {
		String sql = "INSERT INTO products VALUES ("
				+ "NULL, '"
				+ product.getProName() + "', "
				+ product.getProStock() + ", "
				+ product.getProPrice() + ", "
				+ "DEFAULT, "
				+ "NULL, "
				+ product.getProCategory().getCatId()
				+ ")";
		jdbc.update(sql);
		
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		ResultSet rsProduct = jdbc.query("SELECT * FROM products WHERE pro_id = " + id);
		ResultSet rsCategory = null;
		try {
			if (rsProduct.next()) {

				product = getProduct(rsProduct);
				rsCategory = jdbc.query("SELECT * FROM categories WHERE cat_id = " 
						+ rsProduct.getInt("cat_id"));
				Category category = null;
				if(rsCategory != null && rsCategory.next()) {
					category = DAOFactory.getFactory().getCategoryDAO().getCategory(rsCategory);
				}
				product.setProCategory(category);
				Company company = new Company();
				product.setProCompany(company);
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductsDAO:read): " + e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCProductsDAO:read:GLOBAL): " + e.getMessage());
		}
		return product;
	}

	@Override
	public void update(Product product) {
		String sql = "UPDATE products SET "
				+ "pro_name = '" + product.getProName() + "', "
				+ "pro_stock = " + product.getProStock() + ", "
				+ "pro_price = " + product.getProPrice() + " "
				+ "WHERE pro_id = " + product.getProId() + " ";
		jdbc.update(sql);
		
	}

	@Override
	public void delete(Product product) {
		String sql = "UPDATE products SET "
				+ "pro_deleted = '1' "
				+ "WHERE pro_id = " + product.getProId() + " ";;
		jdbc.update(sql);
		
	}

	@Override
	public List<Product> find() {
		List<Product> products = new ArrayList<Product>();
		ResultSet rsProduct = jdbc.query("SELECT * FROM products");
		try {
			while(rsProduct.next()) {
				if (!rsProduct.getBoolean("pro_deleted")) {
					Product product = getProduct(rsProduct);
					products.add(product);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:find): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCProductDAO:find:GLOBAL): " 
					+ e.getMessage());
		}
		return products;
	}

	@Override
	public List<Product> findByCategoryId(int id) {
		List<Product> products = new ArrayList<Product>();
		ResultSet rsProduct = jdbc.query("SELECT * FROM products WHERE cat_id = " + id);
		try {
			while(rsProduct.next()) {
				if (!rsProduct.getBoolean("pro_deleted")) {
					Product product = getProduct(rsProduct);					
					products.add(product);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:findByCategoryId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCProductDAO:findByCategoryId:GLOBAL): " 
					+ e.getMessage());
		}
		
		return products;
	}

	@Override
	public Product getProduct(ResultSet rsProduct) {
		Product product = null;
		try {
			if(rsProduct != null && !rsProduct.getBoolean("pro_deleted")) {
				product = new Product();
				product.setProId(rsProduct.getInt("pro_id"));
				product.setProName(rsProduct.getString("pro_name"));
				product.setProStock(rsProduct.getInt("pro_stock"));
				product.setProPrice(rsProduct.getDouble("pro_price"));
				product.setProDeleted(false);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:getProduct): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCProductDAO:getProduct:GLOBAL): " 
					+ e.getMessage());
		}
		return product;
	}


}
