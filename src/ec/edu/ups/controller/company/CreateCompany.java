package ec.edu.ups.controller.company;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.Company;

/**
 * Servlet implementation class CreateCompany
 */
@WebServlet("/CreateCompany")
public class CreateCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyDAO companyDAO;
	private Company company;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCompany() {
        super();
        companyDAO = DAOFactory.getFactory().getCompanyDAO();
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
			company.setComName(request.getParameter("com_name"));
			
			int res = companyDAO.create(company);
			
			if (res == 1062) {
				response.getWriter().append("La Empresa ya se encuentra registrada&e_notice_error");
			} else if(res == 0) {
				response.getWriter().append("Se ha registrado correctamente&e_notice_sucess");
			} else {
				response.getWriter().append("Hubo un error al crear la Empresa&e_notice_error");
			}
			
		} catch (Exception e) {
			response.getWriter().append("Hubo un error al crear la Empresa&e_notice_error");
			e.printStackTrace();
		}
	}

}
