package ec.edu.ups.controller.billdetail;

import java.io.IOException;

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
			int detAmount = Integer.parseInt(request.getParameter("det_amount"));
			billDetail = billDetailDAO.read(Integer.parseInt(request.getParameter("det_id")));
			if (detAmount > billDetail.getDetProduct().getProStock()) {
				response.getWriter().append("No hay suficiente stock. Disponible: " 
						+ billDetail.getDetProduct().getProStock() + "&e_notice_warning");
			}else {
				billDetail.setDetAmount(detAmount);
				billDetail.calculateTotal();
				billDetail.setDetDeleted(false);
				billDetailDAO.update(billDetail);
				response.getWriter().append("Y&e_notice_sucess");
			}
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
