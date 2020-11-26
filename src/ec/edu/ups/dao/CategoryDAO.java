package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.util.List;

import ec.edu.ups.model.Category;

public interface CategoryDAO extends GenericDAO<Category, Integer>{
	public abstract List<Category> findByCategoryId(int id);
	
	/**
	 * Funcion 
	 *  
	 * @param rsCategory
	 * @return
	 */
	public abstract Category getCategory(ResultSet rsCategory);
	
}
