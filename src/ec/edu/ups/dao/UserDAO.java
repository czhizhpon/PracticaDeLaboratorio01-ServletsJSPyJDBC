package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.util.List;

import ec.edu.ups.model.User;

public interface UserDAO extends GenericDAO<User, Integer>{
	
	/**
	 * Metodo que retorna un objeto "User" a partir de una consulta 
	 * a la Base de Datos. User solo carga los atributos propios del
	 * objeto, no los atributos objetos como Company.
	 * @param rsUser
	 * @return
	 */
	public abstract User getUser(ResultSet rsUser);
	
	/**
	 * Metodo que permite obtener una lista de objetos "User" que
	 * pertenecen a un mismo objeto "Company".
	 * @param id
	 * @return
	 */
	public abstract List<User> findByCompanyId(int id);

}
