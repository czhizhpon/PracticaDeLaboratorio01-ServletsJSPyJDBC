package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillDetail;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.User;
import ec.edu.ups.resources.DateFormat;
import ec.edu.ups.resources.MathFunction;

public class JDBCBillHeadDAO extends JDBCGenericDAO<BillHead, Integer> implements BillHeadDAO{

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS bill_details ");
		jdbc.update("DROP TABLE IF EXISTS bill_heads ");
		
		// ** Temporal solo para pruebas
		jdbc.update("DROP TABLE IF EXISTS users ");
		jdbc.update("CREATE TABLE users (use_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)");
		// **
		
		jdbc.update("CREATE TABLE bill_heads ( "
				+ "hea_id INT NOT NULL AUTO_INCREMENT, "
				+ "hea_subtotal DECIMAL(18,6), "
				+ "hea_vat DECIMAL(18,6), "
				+ "hea_date DATETIME" + ", "
				+ "hea_status VARCHAR(1) DEFAULT 'C'" + ", "
				+ "hea_total DECIMAL(18,6), "
				+ "hea_deleted BOOLEAN DEFAULT '0', "
				+ "use_id INT, "
				+ "PRIMARY KEY (hea_id), "
				+ "FOREIGN KEY(use_id) REFERENCES users(use_id) "
				+ ") ");
		DAOFactory.getFactory().getBillDetailDAO().createTable();
	}

	@Override
	public void create(BillHead billHead) {
		String date = DateFormat.getMySQLDate(billHead.getHeaDate());
		String sql = "INSERT INTO bill_heads VALUES( "
				+ "NULL" + ", "
				+ MathFunction.getTrunkDecimal(billHead.getHeaSubtotal()) + ", "
				+ MathFunction.getTrunkDecimal(billHead.getHeaVat()) + ", "
				+ date + ", "
				+ "'" + billHead.getHeaStatus() + "', "
				+ "DEFAULT, "
				+ MathFunction.getTrunkDecimal(billHead.getHeaTotal()) + ", "
				+ (billHead.getHeaUser() == null 
					? "NULL" : billHead.getHeaUser().getUseId()) + " "
				+ ") ";
		jdbc.update(sql);
		List<BillDetail> billDetails = billHead.getHeaBillDetails();
		if(billDetails != null) {
			for(BillDetail billDetail : billDetails) {
				DAOFactory.getFactory().getBillDetailDAO().create(billDetail);
			}
		}
	}

	@Override
	public BillHead read(Integer id) {
		BillHead billHead = null;
		ResultSet rsBillHead = jdbc.query("SELECT * FROM bill_heads WHERE hea_id = " + id);
		try {
			if (rsBillHead.next()) {
				billHead = getBillHead(rsBillHead);
				List<BillDetail> billDetails = DAOFactory.getFactory().getBillDetailDAO().findByBillHeadId(rsBillHead.getInt("hea_id"));
				billHead.setHeaBillDetails(billDetails);
//				billHead.setHeaUser(null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:read): " + e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:read:GLOBAL): " + e.getMessage());
		}
		return billHead;
	}

	@Override
	public void update(BillHead billHead) {
		String date = DateFormat.getMySQLDate(billHead.getHeaDate());
		String sql = "UPDATE bill_heads SET "
				+ "hea_subtotal = " + MathFunction.getTrunkDecimal(billHead.getHeaSubtotal()) + ", "
				+ "hea_vat = " + MathFunction.getTrunkDecimal(billHead.getHeaVat()) + ", "
				+ "hea_date = " + date + ", "
				+ "hea_status = '" + billHead.getHeaStatus() + "', "
				+ "hea_total = " + MathFunction.getTrunkDecimal(billHead.getHeaTotal()) + " "
				+ "WHERE hea_id = " + billHead.getHeaId() + " ";
		jdbc.update(sql);
	}

	@Override
	public void delete(BillHead billHead) {
		String sql = "UPDATE bill_heads SET "
				+ "hea_deleted = '1' "
				+ "WHERE hea_id = " + billHead.getHeaId() + " ";
		jdbc.update(sql);
	}

	@Override
	public List<BillHead> find() {
		List<BillHead> billHeads = new ArrayList<BillHead>();
		ResultSet rsBillHead = jdbc.query("SELECT * FROM bill_heads");
		try {
			while(rsBillHead.next()) {
				if (!rsBillHead.getBoolean("det_deleted")) {
					BillHead billHead = getBillHead(rsBillHead);
					billHeads.add(billHead);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:find): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:find:GLOBAL): " 
					+ e.getMessage());
		}
		return billHeads;
	}
	
	@Override
	public List<BillHead> findByUserId(int id) {
		List<BillHead> billHeads = new ArrayList<BillHead>();
		ResultSet rsBillHead = jdbc.query("SELECT * FROM bill_heads WHERE "
				+ "usu_id = " + id);
		try {
			while(rsBillHead.next()) {
				if (!rsBillHead.getBoolean("hea_deleted")) {
					BillHead billHead = getBillHead(rsBillHead);
					billHeads.add(billHead);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findByUserId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findByUserId:GLOBAL): " 
					+ e.getMessage());
		}
		return billHeads;
	}
	
	@Override
	public List<BillDetail> findShoppingByUserId(int id) {
		List<BillDetail> billDetails = new ArrayList<BillDetail>();
		ResultSet rsBillHead = jdbc.query("SELECT * FROM bill_heads WHERE "
				+ "usu_id = " + id + " AND hea_status = 'C' AND hea_deleted = '0'");
		try {
			if(rsBillHead.next()) {
				if (!rsBillHead.getBoolean("hea_deleted")) {
					BillHead billHead = getBillHead(rsBillHead);
					billDetails = DAOFactory.getFactory().getBillDetailDAO().findByBillHeadId(billHead.getHeaId());
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingByUserId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingByUserId:GLOBAL): " 
					+ e.getMessage());
		}
		return billDetails;
	}
	
	@Override
	public BillHead getBillHead(ResultSet rsBillHead) {
		BillHead billHead = null;
		try {
			if(rsBillHead != null && !rsBillHead.getBoolean("hea_deleted")) {
				billHead = new BillHead();
				billHead.setHeaId(rsBillHead.getInt("hea_id"));
				billHead.setHeaSubtotal(rsBillHead.getDouble("hea_subtotal"));
				billHead.setHeaVat(rsBillHead.getDouble("hea_vat"));
				billHead.setHeaDate(DateFormat.getCalentarByTimestamp(rsBillHead
						.getTimestamp("hea_date")));
				billHead.setHeaStatus(rsBillHead.getString("hea_status").charAt(0));
				billHead.setHeaTotal(rsBillHead.getDouble("hea_total"));
				billHead.setHeaDeleted(false);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingByUserId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingByUserId:GLOBAL): " 
					+ e.getMessage());
		}
		return billHead;
	}

}
