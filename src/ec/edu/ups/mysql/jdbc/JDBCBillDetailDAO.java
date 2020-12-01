package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillDetail;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.Product;

public class JDBCBillDetailDAO extends JDBCGenericDAO<BillDetail, Integer> implements BillDetailDAO{

	@Override
	public void createTable() {
		// ** Temporal solo para pruebas
//		jdbc.update("DROP TABLE IF EXISTS products ");
		// **
		
		jdbc.update("DROP TABLE IF EXISTS bill_details ");
		
		// ** Temporal solo para pruebas
//		jdbc.update("CREATE TABLE products (pro_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)");
//		for (int i = 0; i < 30; i++) {
//			jdbc.update("INSERT INTO products VALUES(NULL)");
//		}
		// **
		
		jdbc.update("CREATE TABLE bill_details ( "
				+ "det_id INT NOT NULL AUTO_INCREMENT, "
				+ "det_amount INT, "
				+ "det_unit_price DECIMAL(12,2), "
				+ "det_total DECIMAL(12,2), "
				+ "det_deleted BOOLEAN DEFAULT '0', "
				+ "hea_id INT, "
				+ "pro_id INT, "
				+ "PRIMARY KEY (det_id), "
				+ "FOREIGN KEY(hea_id) REFERENCES bill_heads(hea_id), "
				+ "FOREIGN KEY(pro_id) REFERENCES products(pro_id) "
				+ ") ");
	}

	@Override
	public int create(BillDetail billDetail) {
		String sql = "INSERT INTO bill_details VALUES ("
				+ "NULL, "
				+ billDetail.getDetAmount() + ", "
				+ billDetail.getDetUnitPrice() + ", "
				+ billDetail.getDetTotal() + ", "
				+ "DEFAULT, "
				+ billDetail.getDetBillHead().getHeaId() + ", "
				+ billDetail.getDetProduct().getProId() + " "
				+ ")";
		return jdbc.update(sql);
	}

	@Override
	public BillDetail read(Integer id) {
		BillDetail billDetail = null;
		ResultSet rsBillDetail = jdbc.query("SELECT * FROM bill_details WHERE det_id = " + id);
		ResultSet rsBillHead = null;
		try {
			if (rsBillDetail.next()  && !rsBillDetail.getBoolean("det_deleted")) {
				billDetail = getBillDetail(rsBillDetail);
				rsBillHead = jdbc.query("SELECT * FROM bill_heads WHERE hea_id = " 
						+ rsBillDetail.getInt("hea_id"));
				BillHead billHead = null;
				if(rsBillHead != null && rsBillHead.next()) {
					billHead = DAOFactory.getFactory().getBillHeadDAO().getBillHead(rsBillHead);
				}
				billDetail.setDetBillHead(billHead);
				Product product = DAOFactory.getFactory().getProductDAO().read(rsBillDetail.getInt("pro_id"));
				billDetail.setDetProduct(product);
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:read): " + e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:read:GLOBAL): " + e.getMessage());
		}
		return billDetail;
	}

	@Override
	public void update(BillDetail billDetail) {
		String sql = "UPDATE bill_details SET "
				+ "det_amount = " + billDetail.getDetAmount() + ", "
				+ "det_unit_price = " + billDetail.getDetUnitPrice() + ", "
				+ "det_total = " + billDetail.getDetTotal() + ", "
				+ "det_deleted = '" + (!billDetail.isDetDeleted() ? 0 : 1) + "' "
				+ "WHERE det_id = " + billDetail.getDetId() + " ";
		jdbc.update(sql);
		if(billDetail.getDetProduct() != null) {
			DAOFactory.getFactory().getProductDAO().updateWhitoutCat(billDetail.getDetProduct());
		}
		
	}

	@Override
	public void delete(BillDetail billDetail) {
		String sql = "UPDATE bill_details SET "
				+ "det_deleted = '1' "
				+ "WHERE det_id = " + billDetail.getDetId() + " ";;
		jdbc.update(sql);
		
	}

	@Override
	public List<BillDetail> find() {
		List<BillDetail> billDetails = new ArrayList<BillDetail>();
		ResultSet rsBillDetail = jdbc.query("SELECT * FROM bill_details");
		try {
			while(rsBillDetail.next()) {
				if (!rsBillDetail.getBoolean("det_deleted")) {
					BillDetail billDetail = getBillDetail(rsBillDetail);
					billDetails.add(billDetail);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:find): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:find:GLOBAL): " 
					+ e.getMessage());
		}
		return billDetails;
	}

	@Override
	public List<BillDetail> findByBillHeadId(int id) {
		List<BillDetail> billDetails = new ArrayList<BillDetail>();
		ResultSet rsBillDetail = jdbc.query("SELECT * FROM bill_details WHERE hea_id = " + id + " AND det_deleted = '0'");
		ResultSet rsProduct;
		try {
			while(rsBillDetail.next()) {
				if (!rsBillDetail.getBoolean("det_deleted")) {
					BillDetail billDetail = getBillDetail(rsBillDetail);
					rsProduct = jdbc.query("SELECT * FROM products WHERE pro_id = " 
							+ rsBillDetail.getInt("pro_id"));
					if(rsProduct.next()) {
						Product product = DAOFactory.getFactory().getProductDAO().getProduct(rsProduct);
						billDetail.setDetProduct(product);
					}
					billDetails.add(billDetail);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:findByBillHeadId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:findByBillHeadId:GLOBAL): " 
					+ e.getMessage());
		}
		
		return billDetails;
	}
	
	@Override
	public BillDetail getBillDetail(ResultSet rsBillDetail) {
		BillDetail billDetail = null;
		try {
			if(rsBillDetail != null) {
				billDetail = new BillDetail();
				billDetail.setDetId(rsBillDetail.getInt("det_id"));
				billDetail.setDetAmount(rsBillDetail.getInt("det_amount"));
				billDetail.setDetUnitPrice(rsBillDetail.getDouble("det_unit_price"));
				billDetail.setDetTotal(rsBillDetail.getDouble("det_total"));
				billDetail.setDetDeleted(rsBillDetail.getBoolean("det_deleted"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:getBillDetail): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:getBillDetail:GLOBAL): " 
					+ e.getMessage());
		}
		return billDetail;
	}

	@Override
	public BillDetail getBillDetailShoppingByProductId(int proId, int heaId) {
		BillDetail billDetail = null;
		ResultSet rsBillDetail = jdbc.query("SELECT * FROM bill_details "
				+ "WHERE pro_id = " + proId + " AND hea_id = " + heaId);
		try {
			if (rsBillDetail.next()) {
				billDetail = getBillDetail(rsBillDetail);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:getBillDetailShoppingByProductId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillDetailDAO:getBillDetailShoppingByProductId:GLOBAL): " 
					+ e.getMessage());
		}
		return billDetail;
	}
}
