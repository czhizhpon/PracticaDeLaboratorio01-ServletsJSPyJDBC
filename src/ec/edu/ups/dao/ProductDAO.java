package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.util.List;

import ec.edu.ups.model.Product;

public interface ProductDAO extends GenericDAO<Product, Integer>{
	public abstract List<Product> findByCategoryId(int id);
	public abstract List<Product> findToStoreCatId(int id, String s);
	public abstract List<Product> findAll();
	public abstract Product getProduct(ResultSet rsProduct);
	public abstract void updateWhitoutCat(Product product);
}
