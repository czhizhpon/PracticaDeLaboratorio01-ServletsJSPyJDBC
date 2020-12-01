package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.util.List;

import ec.edu.ups.model.BillDetail;

public interface BillDetailDAO extends GenericDAO<BillDetail, Integer>{
	public abstract List<BillDetail> findByBillHeadId(int id);
	public abstract BillDetail getBillDetail(ResultSet rsBillDetail);
	public abstract BillDetail getBillDetailShoppingByProductId(int proId, int heaId);
}
