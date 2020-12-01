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
 * Servlet implementation class DeleteBillDetail
 */
@WebServlet("/DeleteBillDetail")
public class DeleteBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDetailDAO billDetailDAO;
	private BillDetail billDetail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBillDetail() {
        super();
        billDetailDAO = DAOFactory.getFactory().getBillDetailDAO();
        billDetail = new BillDetail();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			billDetail = billDetailDAO.read(Integer.parseInt(request.getParameter("det_id")));
			billDetail.setDetAmount(0);
			billDetailDAO.delete(billDetail);
			response.getWriter().append("&e_notice_sucess");
		} catch (Exception e) {
			response.getWriter().append("No se pudo eliminar el producto&e_notice_error");
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
