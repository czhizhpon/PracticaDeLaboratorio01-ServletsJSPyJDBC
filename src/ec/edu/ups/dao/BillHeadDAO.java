package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.util.List;

import ec.edu.ups.model.BillHead;

public interface BillHeadDAO extends GenericDAO<BillHead, Integer>{
	public abstract List<BillHead> findByUserId(int id);
	
	public abstract BillHead findShoppingBillByUserId(int useId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract BillHead findShoppingByUserId(int id);
	
	/**
	 * Función que retorna un BillHead a partir de una Consulta a la Base
	 * de datos. BillHead solo carga los atributos directos, 
	 * atributos como User o BillDetail no son seteados.
	 *  
	 * @param rsBillHead
	 * @return
	 */
	public abstract BillHead getBillHead(ResultSet rsBillHead);
	
	public abstract void setBillHeadTotal(int id);
	
	public abstract List<BillHead> findBillByComId(int comId, String s);
}
