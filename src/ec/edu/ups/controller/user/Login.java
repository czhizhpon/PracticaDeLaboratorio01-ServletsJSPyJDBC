package ec.edu.ups.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    private User user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        userDAO = DAOFactory.getFactory().getUserDAO();
        user = new User();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username = request.getParameter("use_username");
			String password = request.getParameter("use_password");
			
			
			user = userDAO.CompareByNameANDPassword(username, password);
			
			if (user.getUseId() == 0) {
				response.getWriter().append("Credenciales incorrectas&e_notice_warning");
			}else {
				HttpSession session = request.getSession(true);
				session.setAttribute("isLogged", true);
				session.setAttribute("user", user);
				response.getWriter().append(" &e_notice_sucess");
			}
		} catch (Exception e) {
			response.getWriter().append("Hubo un error en el sistema&e_notice_error");
		}		
	}

}
