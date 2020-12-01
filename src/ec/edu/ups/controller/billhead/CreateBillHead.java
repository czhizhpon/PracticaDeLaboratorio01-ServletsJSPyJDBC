package ec.edu.ups.controller.billhead;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class CreateBillHead
 */
@WebServlet("/CreateBillHead")
public class CreateBillHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDao;
	private BillHead billHead;
	
    public CreateBillHead() {
        super();
        billHeadDao = DAOFactory.getFactory().getBillHeadDAO();
        billHead = new BillHead();
//        User user = new User();
//        billHead.setHeaUser(user);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		billHead = new BillHead();
		User user = new User();
		user.setUseId(1);
		billHead.setHeaUser(user);
		billHeadDao.create(billHead);
		response.getWriter().append("Se ha registrado&e_notice_sucess");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		
		try {
			billHead.setHeaSubtotal(Double.parseDouble(request.getParameter("hea_subtotal")));
			billHead.setHeaVat(Double.parseDouble(request.getParameter("hea_vat")));
			billHead.setHeaDate(null);
			billHead.setHeaTotal(Double.parseDouble(request.getParameter("hea_total")));
//			billHead.getHeaUser().setUseId(Integer.parseInt((request.getParameter("use_id"))));
			billHead.setHeaStatus('C');
			billHeadDao.create(billHead);
//			System.out.println("LLEGO: " + billHead.getHeaUser().getUseId());
			url = "/index.jsp";
		} catch (Exception e) {
			System.out.println("ERROR");
			url = "/JSP/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
