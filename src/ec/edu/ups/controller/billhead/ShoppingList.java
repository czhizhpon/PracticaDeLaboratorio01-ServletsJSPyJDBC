package ec.edu.ups.controller.billhead;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillHead;

/**
 * Servlet implementation class ShoppingList
 */
@WebServlet("/ShoppingList")
public class ShoppingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BillHeadDAO billHeadDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingList() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int page = 1;
//		int recordsPerPage = 5;
//		if(request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
		BillHead billHead = billHeadDAO.findShoppingByUserId(1);
		request.setAttribute("billHead", billHead);
		RequestDispatcher view = request.getRequestDispatcher("/JSP/private/carrito.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
