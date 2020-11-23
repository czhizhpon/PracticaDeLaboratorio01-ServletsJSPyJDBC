package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID> {
	protected static ContextJDBC jdbc = ContextJDBC.getJDBC();
}
