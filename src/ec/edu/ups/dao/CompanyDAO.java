package ec.edu.ups.dao;

import java.sql.ResultSet;

import ec.edu.ups.model.Company;

public interface CompanyDAO extends GenericDAO<Company, Integer>{
	
	/**
	 * M�todo que retorna un objeto "Company" a partir de una consulta 
	 * a la Base de Datos. Company solo carga los atributos propios del
	 * objeto, no los atributos objetos como User o Product.
	 * @param rsCompany
	 * @return
	 */
	public abstract Company getCompany(ResultSet rsCompany);
	public abstract Company geCompanyByUserId(int useId);

}
