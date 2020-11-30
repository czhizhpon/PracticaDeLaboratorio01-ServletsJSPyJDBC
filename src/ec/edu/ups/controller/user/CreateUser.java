package ec.edu.ups.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private User user;
    private Company company;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        userDAO = DAOFactory.getFactory().getUserDAO();
        user = new User();
        company = new Company();
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
			company.setComId(Integer.parseInt(request.getParameter("com_id")));
			user.setUseName(request.getParameter("use_name"));
			user.setUseLastname(request.getParameter("use_lastname"));
			user.setUseUsername(request.getParameter("use_username"));
			user.setUsePassword(request.getParameter("use_password"));
			user.setUseEmail(request.getParameter("use_email"));
			user.setUseRole(request.getParameter("use_role").charAt(0));
			user.setUseCompany(company);
			int res = userDAO.create(user);
			if(res == 1062) {
				response.getWriter().append("El usuario o correo ya existe&e_notice_error");
			} else if(res == 0) {
				response.getWriter().append("Se ha registrado correctamente&e_notice_sucess");
			} else {
				response.getWriter().append("Hubo un error al crear el Usuario&e_notice_error");
			}
		}catch (Exception e) {
			response.getWriter().append("Hubo un error al crear el Usuario&e_notice_error");
			e.printStackTrace();
		}
	}

}
