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
 * Servlet implementation class DeleteBillHead
 */
@WebServlet("/RequestBillHead")
public class RequestBillHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDAO;
	private BillHead billHead;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestBillHead() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
        billHead = new BillHead();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		char heaStatus;
		int heaId;
		try {
			heaStatus = request.getParameter("hea_status").charAt(0);
			heaId = Integer.parseInt(request.getParameter("hea_id"));
			billHead = billHeadDAO.read(heaId);
			billHead.setHeaStatus(heaStatus);
			billHeadDAO.update(billHead);
			response.getWriter().append("Cambios almacenados&e_notice_sucess");
		}catch (Exception e) {
			response.getWriter().append("No se pudo cambiar el estado&e_notice_error");
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
