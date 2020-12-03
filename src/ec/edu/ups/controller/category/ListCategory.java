package ec.edu.ups.controller.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoryDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class ListCategory
 */
@WebServlet("/ListCategory")
public class ListCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	private List<Category> categories;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategory() {
        super();
        categoryDAO = DAOFactory.getFactory().getCategoryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			categories = categoryDAO.findByCompanyId(user.getUseCompany().getComId());
			request.setAttribute("categories", categories);
			request.setAttribute("user", user);
			getServletContext().getNamedDispatcher("/JSP/private/admin/category_register.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
