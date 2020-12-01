package ec.edu.ups.controller.category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DIV = 7;
	
	private int maxPages;
	private int currentPage;
	private int n;
	
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private List<Category> categories;
    private List<Product> products;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store() {
        super();
        // TODO Auto-generated constructor stub
        categoryDAO = DAOFactory.getFactory().getCategoryDAO();
        productDAO = DAOFactory.getFactory().getProductDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categories = new ArrayList<Category>();
        int catId = 0;
        String s = "";
        n = 0;
        try {
           catId  = Integer.parseInt(request.getParameter("cat_id"));
		} catch (Exception e) {
			
		}
        s  = request.getParameter("s") == null ? "" : request.getParameter("s");
        
        categories = categoryDAO.findByCompanyId(1);
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
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			currentPage = 0;
		}
		n = products.size();
		maxPages = (int)((n - 1) / DIV);
        var min = currentPage * DIV;
        var max = min + (DIV - 1);
        if(max >= n){
            max = n - 1;
        }
        min = min > max ? max : min;
        min = min < 0 ? 0 : min;
        products = products.subList(min, max + 1);
        
        min = currentPage - 3;
        if(min < 0) {
        	min = 0;
        }
        max = currentPage + 3;
        if(max >= maxPages) {
        	max = maxPages;
        }
		request.setAttribute("min", min);
		request.setAttribute("max", max);
		request.setAttribute("maxPages", maxPages);
		request.setAttribute("catId", catId);
		request.setAttribute("s", s);
		request.setAttribute("currentPage", currentPage);
        request.setAttribute("categories", categories);
        request.setAttribute("productsList", products);
		RequestDispatcher view = request.getRequestDispatcher("/JSP/private/user/products.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
