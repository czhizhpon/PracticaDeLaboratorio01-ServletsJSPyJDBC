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

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/CategoryList")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private Category category;
    private List<Category> categories;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryList() {
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
        
        try {
           catId  = Integer.parseInt(request.getParameter("cat_id"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        categories = categoryDAO.findByCompanyId(1);
        for (Category category : categories) {
        	if (catId == 0) {
        		category.setCatProducts(productDAO.findByCategoryId(category.getCatId()));
			}else if(catId != 0) {
				if (category.getCatId() == catId) {
	        		category.setCatProducts(productDAO.findByCategoryId(category.getCatId()));
				}
			}
			
		}
        System.out.println(categories);
//        request.setAttribute("categories", categories);
//		RequestDispatcher view = request.getRequestDispatcher("/JSP/private/?????");
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
