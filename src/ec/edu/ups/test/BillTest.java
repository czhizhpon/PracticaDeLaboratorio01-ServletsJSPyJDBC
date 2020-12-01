package ec.edu.ups.test;

import java.util.Calendar;

import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillDetail;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.User;
import ec.edu.ups.mysql.jdbc.JDBCDAOFactory;

public class BillTest {
	public static void main(String[] args) {
		BillHeadDAO bh = DAOFactory.getFactory().getBillHeadDAO();
		User user = new User();
		user.setUseId(1);
		bh.createTable();
		BillHead[] billHeads = new BillHead[5];
		billHeads[0] = new BillHead();
		billHeads[0].setHeaSubtotal(0.0);
		billHeads[0].setHeaVat(0.0);
		billHeads[0].setHeaDate(Calendar.getInstance());
		billHeads[0].setHeaStatus('C');
		billHeads[0].setHeaDeleted(false);
		billHeads[0].setHeaUser(user);;
		bh.create(billHeads[0]);
//		System.out.println(bh.read(1));
//		
//		billHeads[1] = new BillHead();
//		billHeads[1].setHeaSubtotal(200.0);
//		billHeads[1].setHeaVat(20.0);
//		billHeads[1].setHeaDate(null);
//		billHeads[1].setHeaStatus('B');
//		billHeads[1].setHeaDeleted(false);
//		bh.create(billHeads[1]);
//		System.out.println(bh.read(2));
//		
//		billHeads[2] = new BillHead();
//		billHeads[2].setHeaSubtotal(300.0);
//		billHeads[2].setHeaVat(30.0);
//		billHeads[2].setHeaDate(null);
//		billHeads[2].setHeaStatus('B');
//		billHeads[2].setHeaDeleted(false);
//		bh.create(billHeads[2]);
//		System.out.println(bh.read(3));
//		
//		
//		// Detalle
//		billHeads[3] = bh.read(1);
//		billHeads[3].setHeaTotal(999.9999999);
//		bh.update(billHeads[3]);
//		System.out.println(bh.read(1));
//		
//		BillDetailDAO bd = DAOFactory.getFactory().getBillDetailDAO();
//		BillDetail[] billDetails = new BillDetail[5];
//		billDetails[0] = new BillDetail();
//		billDetails[0].setDetAmount(1);
//		billDetails[0].setDetUnitPrice(1.0);
//		billDetails[0].setDetTotal(1.0);
//		billDetails[0].setDetDeleted(false);
//		billDetails[0].setDetProduct(null);
//		billDetails[0].setDetBillHead(billHeads[3]);
//		bd.create(billDetails[0]);
//		System.out.println(bd.read(1));
//		
//		billDetails[1] = new BillDetail();
//		billDetails[1].setDetAmount(2);
//		billDetails[1].setDetUnitPrice(2.0);
//		billDetails[1].setDetTotal(2.0);
//		billDetails[1].setDetDeleted(false);
//		billDetails[1].setDetProduct(null);
//		billDetails[1].setDetBillHead(billHeads[3]);
//		bd.create(billDetails[1]);
//		
//		billDetails[2] = bd.read(2);
//		billDetails[2].setDetDeleted(true);
//		bd.delete(billDetails[2]);
//		
//		
//		System.out.println("\nBillHead con detalles: \n" + bh.read(1) + "\n");
//		System.out.println(bd.read(1));
//		
//		System.out.println(JDBCBillDetailDAO.findByBillHeadId(1));
//		System.out.println(JDBCDAOFactory.getFactory().close());
	}
}
