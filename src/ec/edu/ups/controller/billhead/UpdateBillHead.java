package ec.edu.ups.controller.billhead;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillDetail;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class UpdateBillHead
 */
@WebServlet("/UpdateBillHead")
public class UpdateBillHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDAO;
	private BillHead billHead;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBillHead() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			int useId = user.getUseId();
			billHead = billHeadDAO.findShoppingByUserId(useId);
			if (!billHead.calcualteTotal()) {
				response.getWriter().append("No se pudo realizar las operaciones&e_notice_error");
			}else {
				billHead.setHeaStatus('R');
				billHead.setHeaDate(Calendar.getInstance());
				if (billHead.getHeaBillDetails() == null) {
					response.getWriter().append("No se encontraron productos en el carrito&e_notice_warning");
				}else {
					for(BillDetail billDetail : billHead.getHeaBillDetails()) {
						int stock = billDetail.getDetProduct().getProStock();
						int amount = billDetail.getDetAmount();
						if(stock - amount < 0) {
							response.getWriter().append("No se pudo procesar el pedido, "
									+ "no hay stock suficiente para \"" 
									+ billDetail.getDetProduct().getProName() + "\". Disponible: " 
									+ billDetail.getDetProduct().getProStock() + "&e_notice_warning");
							break;
						}else {
							billDetail.getDetProduct().setProStock(stock - amount);
							billHeadDAO.update(billHead);
							response.getWriter().append("a&e_notice_sucess");
							RequestDispatcher view = request.getRequestDispatcher("CreateBillHead");
							view.forward(request, response);
						}
					}
				}
				
			}
		}catch (Exception e) {
			response.getWriter().append("No se pudo realizar su pedido&e_notice_error");
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
