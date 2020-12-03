package ec.edu.ups.controller.company;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.Company;

/**
 * Servlet implementation class ListCompany
 */
@WebServlet("/ListCompany")
public class ListCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyDAO companyDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCompany() {
        super();
        companyDAO = DAOFactory.getFactory().getCompanyDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Company company = companyDAO.read(1);
		List<Company> companiesList = companyDAO.find();
		request.setAttribute("companies", companiesList);
		RequestDispatcher view = request.getRequestDispatcher("/JSP/private/admin/company_register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
