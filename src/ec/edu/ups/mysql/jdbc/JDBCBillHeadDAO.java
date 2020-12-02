package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.BillDetailDAO;
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
		jdbc.update("DROP TABLE IF EXISTS bill_heads ");
		jdbc.update("CREATE TABLE bill_heads ( "
				+ "hea_id INT NOT NULL AUTO_INCREMENT, "
				+ "hea_subtotal DECIMAL(12,2), "
				+ "hea_vat DECIMAL(12,2), "
				+ "hea_date DATETIME" + ", "
				+ "hea_status VARCHAR(1) DEFAULT 'C'" + ", "
				+ "hea_total DECIMAL(12,2), "
				+ "hea_deleted BOOLEAN DEFAULT '0', "
				+ "use_id INT, "
				+ "PRIMARY KEY (hea_id), "
				+ "FOREIGN KEY(use_id) REFERENCES users(use_id) "
				+ ") ");
	}

	@Override
	public int create(BillHead billHead) {
		int code = 0;
		String date = DateFormat.getMySQLDate(billHead.getHeaDate());
		String sql = "INSERT INTO bill_heads VALUES( "
				+ "NULL" + ", "
				+ MathFunction.getTrunkDecimal(billHead.getHeaSubtotal()) + ", "
				+ MathFunction.getTrunkDecimal(billHead.getHeaVat()) + ", "
				+ date + ", "
				+ "DEFAULT, "
				+ "DEFAULT, "
				+ MathFunction.getTrunkDecimal(billHead.getHeaTotal()) + ", "
				+ (billHead.getHeaUser() == null 
					? "NULL" : billHead.getHeaUser().getUseId()) + " "
				+ ") ";
		code = jdbc.update(sql);
		List<BillDetail> billDetails = billHead.getHeaBillDetails();
		if(billDetails != null) {
			for(BillDetail billDetail : billDetails) {
				code = DAOFactory.getFactory().getBillDetailDAO().create(billDetail);
			}
		}
		return code;
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
				User user = new User();
				user.setUseId(rsBillHead.getInt("use_id"));
				billHead.setHeaUser(user);
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
		BillDetailDAO billDetailDAO = DAOFactory.getFactory().getBillDetailDAO();
		List<BillDetail> billDetails = billDetailDAO.findByBillHeadId(billHead.getHeaId());
		if (billHead.getHeaBillDetails() == null && billDetails != null) {
			for (BillDetail billDetail : billDetails) {
				billDetailDAO.delete(billDetail);
			}
		} else if (billHead.getHeaBillDetails() != null && billDetails == null) {
			for (BillDetail billDetail : billHead.getHeaBillDetails()) {
				billDetailDAO.create(billDetail);
			}
		} else if (billHead.getHeaBillDetails() != null && billDetails != null) {
			for (BillDetail billDetail : billHead.getHeaBillDetails()) {
				billDetailDAO.update(billDetail);
			}
		}
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
	public BillHead findShoppingByUserId(int id) {
		List<BillDetail> billDetails = new ArrayList<BillDetail>();
		BillHead billHead = null;
		ResultSet rsBillHead = jdbc.query("SELECT * FROM bill_heads WHERE "
				+ "use_id = " + id + " AND hea_status = 'C' AND hea_deleted = '0'");
		try {
			if(rsBillHead.next()) {
				if (!rsBillHead.getBoolean("hea_deleted")) {
					billHead = getBillHead(rsBillHead);
					billDetails = DAOFactory.getFactory().getBillDetailDAO().findByBillHeadId(billHead.getHeaId());
					billHead.setHeaBillDetails(billDetails);
					User user = new User();
					user.setUseId(rsBillHead.getInt("use_id"));
					billHead.setHeaUser(user);
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingByUserId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingByUserId:GLOBAL): " 
					+ e.getMessage());
		}
		return billHead;
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

	@Override
	public void setBillHeadTotal(int id) {
		
	}

	@Override
	public BillHead findShoppingBillByUserId(int useId) {
		BillHead billHead = null;
		ResultSet rsBillHead = jdbc.query("SELECT * FROM bill_heads where use_id = " 
				+ useId + " AND hea_status LIKE 'C' AND hea_deleted = '0'");
		try {
			if(rsBillHead.next()) {
				billHead = new BillHead();
				billHead = getBillHead(rsBillHead);
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingBillByUserId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findShoppingBillByUserId:GLOBAL): " 
					+ e.getMessage());
		}
		return billHead;
	}

	@Override
	public List<BillHead> findBillByComId(int comId, String s) {
		List<BillHead> billHeads = new ArrayList<BillHead>();
		String sql = "SELECT bill_heads.*, users.use_email "
				+ "FROM bill_heads "
				+ "INNER JOIN users ON bill_heads.use_id = users.use_id AND users.use_email LIKE '%" + s + "%' "
				+ "INNER JOIN companies ON companies.com_id = " + comId + " WHERE bill_heads.hea_status NOT LIKE 'C'";
		ResultSet rsBillHead = jdbc.query(sql);
		try {
			while (rsBillHead.next()) {
				BillHead billHead = getBillHead(rsBillHead);
//				List<BillDetail> billDetails = DAOFactory.getFactory()
//						.getBillDetailDAO().findByBillHeadId(billHead.getHeaId());
//				billHead.setHeaBillDetails(billDetails);
				User user = new User();
				user.setUseEmail(rsBillHead.getString("use_email"));
				billHead.setHeaUser(user);
				billHeads.add(billHead);
				
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findBillByComId): " 
					+ e.getMessage());
		}catch (Exception e) {
			System.out.println(">>>WARNING (JDBCBillHeadDAO:findBillByComId:GLOBAL): " 
					+ e.getMessage());
		}
		
		return billHeads;
	}


}
