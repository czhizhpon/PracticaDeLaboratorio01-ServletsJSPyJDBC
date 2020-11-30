package ec.edu.ups.controller.billdetail;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillDetailDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillDetail;

/**
 * Servlet implementation class UpdateBillDetail
 */
@WebServlet("/UpdateBillDetail")
public class UpdateBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDetailDAO billDetailDAO;
	private BillDetail billDetail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBillDetail() {
        super();
        billDetailDAO = DAOFactory.getFactory().getBillDetailDAO();
        billDetail = new BillDetail();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorUrl = "/sgrc/JSP/error.jsp";
		try {
			billDetail = billDetailDAO.read(Integer.parseInt(request.getParameter("det_id")));
			billDetail.setDetAmount(Integer.parseInt(request.getParameter("det_amount")));
			billDetail.calculateTotal();
			billDetail.setDetDeleted(false);
			billDetailDAO.update(billDetail);
			RequestDispatcher view = request.getRequestDispatcher("UpdateBillHead?hea_id=" + billDetail.getDetBillHead().getHeaId());
	        view.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect(errorUrl);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
