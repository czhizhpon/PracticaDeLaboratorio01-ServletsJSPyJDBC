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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			billHead = new BillHead();
			billHead.setHeaUser(user);
			billHeadDao.create(billHead);
			response.getWriter().append("Se ha registrado&e_notice_sucess");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
