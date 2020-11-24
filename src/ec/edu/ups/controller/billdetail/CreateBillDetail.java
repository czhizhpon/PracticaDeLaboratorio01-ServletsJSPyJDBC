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
import ec.edu.ups.resources.MathFunction;

/**
 * Servlet implementation class CreateBillDetail
 */
@WebServlet("/CreateBillDetail")
public class CreateBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDetailDAO billDetailDAO;
	private BillDetail billDetail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBillDetail() {
        super();
        billDetailDAO = DAOFactory.getFactory().getBillDetailDAO();
        billDetail = new BillDetail();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			billDetail.setDetAmount(Integer.parseInt(request.getParameter("det_amount")));
			billDetail.setDetUnitPrice(Double.parseDouble(request.getParameter("pro_price")));
			MathFunction.setBillDetailTotal(billDetail);
			billDetail.setDetDeleted(false);
			billDetailDAO.create(billDetail);
			url = "/index.jsp";
		} catch (Exception e) {
			System.out.println("ERROR");
			url = "/JSP/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
