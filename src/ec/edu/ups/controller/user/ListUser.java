package ec.edu.ups.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Category;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class ListUser
 */
@WebServlet("/ListUser")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUser() {
        super();
        userDAO = DAOFactory.getFactory().getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		List<User> usersList = userDAO.findByCompanyId(user.getUseCompany().getComId());
		List<Company> companies = DAOFactory.getFactory().getCompanyDAO().find();
		request.setAttribute("users", usersList);
		request.setAttribute("companies", companies);
		RequestDispatcher view = request.getRequestDispatcher("/JSP/private/admin/user_register.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
