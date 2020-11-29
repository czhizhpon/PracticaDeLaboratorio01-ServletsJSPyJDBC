package ec.edu.ups.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.Category;

/**
 * Servlet implementation class CreateCategory
 */
@WebServlet("/CreateCategory")
public class CreateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	private Category category;
	
    public CreateCategory() {
        super();
        categoryDAO = DAOFactory.getFactory().getCategoryDAO();
        category = new Category();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		
		try {
			category.setCatName(request.getParameter("cat_name"));
			categoryDAO.create(category);
			url = "/index.jsp";
		} catch (Exception e) {
			System.out.println("ERROR");
			url = "/JSP/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
