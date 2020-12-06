package ec.edu.ups.controller.billhead;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.User;
import ec.edu.ups.resources.MathFunction;

/**
 * Servlet implementation class BillManagement
 */
@WebServlet("/bills")
public class BillManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDAO;
	private UserDAO userDAO;
	private List<BillHead> billHeads;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillManagement() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
        userDAO = DAOFactory.getFactory().getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		int useId = user.getUseId();
		user = userDAO.read(useId);
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
			
			int currentPage;
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}catch (Exception e) {
				currentPage = 0;
			}
			Map<String, Integer> nav = MathFunction.getNavPages(billHeads.size(), currentPage, 5);
			int min = nav.get("min");
			int max = nav.get("max");
			int minP = nav.get("minP");
			int maxP = nav.get("maxP");
			int maxPages = nav.get("maxPages");
			billHeads = billHeads.subList(min, max + 1);
			
			request.setAttribute("min", minP);
			request.setAttribute("max", maxP);
			request.setAttribute("maxPages", maxPages);
			request.setAttribute("currentPage", currentPage);
			
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
