package ec.edu.ups.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Product;

/**
 * Servlet implementation class ReadProduct
 */
@WebServlet("/ReadProduct")
public class ReadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
	private Product product;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadProduct() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int proId = Integer.parseInt(request.getParameter("pro_id"));
			product = productDAO.read(proId);
			getServletContext().setAttribute("productRead", product);
		} catch (Exception e) {
			getServletContext().setAttribute("productRead", null);
			response.sendRedirect("/JSP/public/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
