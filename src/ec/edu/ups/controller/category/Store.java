package ec.edu.ups.controller.category;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class CategoryList
 */
@WebServlet("/store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private List<Category> categories;
    private List<Product> products;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store() {
        super();
        categoryDAO = DAOFactory.getFactory().getCategoryDAO();
        productDAO = DAOFactory.getFactory().getProductDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categories = new ArrayList<Category>();
        User user = (User) request.getSession().getAttribute("user");
        int catId = 0;
        String s = "";
        try {
           catId  = Integer.parseInt(request.getParameter("cat_id"));
		} catch (Exception e) {
			
		}
        s  = request.getParameter("s") == null ? "" : request.getParameter("s");
        
        categories = categoryDAO.findByCompanyId(user.getUseCompany().getComId());
        products = new ArrayList<Product>();
        for (Category category : categories) {
        	if (catId == 0) {
        		products.addAll(productDAO.findToStoreCatId(category.getCatId(), s));
			}else if(catId != 0) {
				if (category.getCatId() == catId) {
					products.addAll(productDAO.findToStoreCatId(category.getCatId(), s));
				}
			}
		}
        int currentPage;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			currentPage = 0;
		}
		Map<String, Integer> nav = MathFunction.getNavPages(products.size(), currentPage, 5);
		int min = nav.get("min");
		int max = nav.get("max");
		int minP = nav.get("minP");
		int maxP = nav.get("maxP");
		int maxPages = nav.get("maxPages");
		products = products.subList(min, max + 1);
		
		request.setAttribute("min", minP);
		request.setAttribute("max", maxP);
		request.setAttribute("maxPages", maxPages);
		request.setAttribute("currentPage", currentPage);
		
		request.setAttribute("catId", catId);
		request.setAttribute("s", s);
        request.setAttribute("categories", categories);
        request.setAttribute("productsList", products);
		RequestDispatcher view = request.getRequestDispatcher("/JSP/private/user/products.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
