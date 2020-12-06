package ec.edu.ups.controller.product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Product;
import ec.edu.ups.model.User;
import ec.edu.ups.resources.MathFunction;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProduct() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
        categoryDAO = DAOFactory.getFactory().getCategoryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			Product product;
			int com_id = user.getUseCompany().getComId();
			List<Product> productsList = productDAO.findByCompanyId(com_id);
			List<Category> categoriesList = categoryDAO.findByCompanyId(com_id);
			try {
				product = (Product) getServletContext().getAttribute("productRead");
			} catch (Exception e) {
				product = new Product();
			}
			
			int currentPage;
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}catch (Exception e) {
				currentPage = 0;
			}
			Map<String, Integer> nav = MathFunction.getNavPages(productsList.size(), currentPage, 5);
			int min = nav.get("min");
			int max = nav.get("max");
			int minP = nav.get("minP");
			int maxP = nav.get("maxP");
			int maxPages = nav.get("maxPages");
			productsList = productsList.subList(min, max + 1);
			
			request.setAttribute("min", minP);
			request.setAttribute("max", maxP);
			request.setAttribute("maxPages", maxPages);
			request.setAttribute("currentPage", currentPage);
			
			request.setAttribute("products", productsList);
			request.setAttribute("categories", categoriesList);
			request.setAttribute("productRead", product);
			RequestDispatcher view = request.getRequestDispatcher("/JSP/private/admin/product_register.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/JSP/public/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
