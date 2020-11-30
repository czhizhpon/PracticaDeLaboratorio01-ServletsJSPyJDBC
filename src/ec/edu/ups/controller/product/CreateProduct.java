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
 * Servlet implementation class CreateProduct
 */
@WebServlet("/CreateProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private Product product;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProduct() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
        product = new Product();
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
			product.setProName(request.getParameter("pro_name"));
			product.setProStock(Integer.parseInt(request.getParameter("pro_stock")));
			product.setProPrice(Double.parseDouble(request.getParameter("pro_price")));
			product.setProDeleted(false);
			productDAO.create(product);
			url = "/index.jsp";
		} catch (Exception e) {
			System.out.println("ERROR");
			url = "/JSP/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
