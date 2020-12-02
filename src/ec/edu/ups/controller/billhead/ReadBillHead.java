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

/**
 * Servlet implementation class ReadBillHead
 */
@WebServlet("/ReadBillHead")
public class ReadBillHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDAO;
	private BillHead billHead;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadBillHead() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int heaId = Integer.parseInt(request.getParameter("hea_id"));
			billHead = billHeadDAO.read(heaId);
			getServletContext().setAttribute("billHeadRead", billHead);
		} catch (Exception e) {
			getServletContext().setAttribute("billHeadRead", null);
			response.sendRedirect("/JSP/public/error.jsp");
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
