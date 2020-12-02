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
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
	private Product product;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
        product = new Product();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			int d = Integer.parseInt(request.getParameter("pro_deleted"));
			product.setProId(Integer.parseInt(request.getParameter("pro_id")));
			product.setProDeleted(d != 0);
			productDAO.delete(product);
			if(d == 1) 
				response.getWriter().append("Se ha eliminado el producto&e_notice_sucess");
			else
				response.getWriter().append("Se ha restaurado el producto&e_notice_sucess");
			
		} catch (Exception e) {
			response.getWriter().append("Hubo un error al eliminar el producto&e_notice_error");
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
