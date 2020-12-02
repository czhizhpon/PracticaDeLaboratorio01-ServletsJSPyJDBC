package ec.edu.ups.controller.billhead;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.BillDetail;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class BillManagement
 */
@WebServlet("/bills")
public class BillManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDAO;
	private BillDetailDAO billDetailDAO;
	private UserDAO userDAO;
	private List<BillHead> billHeads;
	private List<BillDetail> billDetails;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillManagement() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
        userDAO = DAOFactory.getFactory().getUserDAO();
        billDetailDAO = DAOFactory.getFactory().getBillDetailDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = userDAO.read(2);
		try {
			String s = "";
			s = request.getParameter("s") == null ? "" : request.getParameter("s");
			billHeads = billHeadDAO.findBillByComId(user.getUseCompany().getComId(), s);
			BillHead billHeadRead;
			try {
				billHeadRead = (BillHead) getServletContext().getAttribute("billHeadRead");
			} catch (Exception e) {
				billHeadRead = new BillHead();
			}
			request.setAttribute("billHeads", billHeads);
			request.setAttribute("billHeadRead", billHeadRead);
			request.setAttribute("s", s);
			RequestDispatcher view = request.getRequestDispatcher("/JSP/private/admin/bills_management.jsp");
	        view.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
