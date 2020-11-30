package ec.edu.ups.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Product;

/**
 * Servlet implementation class UpdateBillDetail
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private Product product;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
        product = new Product();
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			product = productDAO.read(Integer.parseInt(request.getParameter("pro_id")));
			product.setProName(request.getParameter("pro_name"));
			product.setProStock(Integer.parseInt(request.getParameter("pro_stock")));
			product.setProPrice(Double.parseDouble(request.getParameter("pro_price")));
			product.setProDeleted(false);
			productDAO.update(product);
			RequestDispatcher view = request.getRequestDispatcher("UpdateProduct?pro_id=" + product.getProCategory().getCatId());
	        view.forward(request, response);
		} catch (Exception e) {
			System.out.println("ERROR " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
