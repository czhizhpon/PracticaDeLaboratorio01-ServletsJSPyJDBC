package ec.edu.ups.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Product;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/CreateProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDAO productDAO;
	private Product product;
	private Category category;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProduct() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
        product = new Product();
        category = new Category();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			category.setCatId(Integer.parseInt(request.getParameter("cat_id")));
			product.setProName(request.getParameter("pro_name"));
			product.setProStock(Integer.parseInt(request.getParameter("pro_stock")));
			product.setProPrice(Double.parseDouble(request.getParameter("pro_price")));
			product.setProCategory(category);
			//product.setProDeleted(false);
			
			int res = productDAO.create(product);
			
			if (res == 0) {
				response.getWriter().append("Se ha registrado correctamente&e_notice_sucess");
			} else {
				response.getWriter().append("Hubo un error al crear el Producto&e_notice_error");
			}
			
		} catch (Exception e) {
			response.getWriter().append("Hubo un error al crear el Producto&e_notice_error");
			e.printStackTrace();
		}
		//getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
