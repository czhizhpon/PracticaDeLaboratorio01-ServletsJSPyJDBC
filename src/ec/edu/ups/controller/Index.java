package ec.edu.ups.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CompanyDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductDAO;
import ec.edu.ups.model.Company;
import ec.edu.ups.model.Product;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class Index
 */
@WebServlet("/home")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private CompanyDAO companyDAO;
	private List<Product> products;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        productDAO = DAOFactory.getFactory().getProductDAO();
        companyDAO = DAOFactory.getFactory().getCompanyDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			List<Company> companies = companyDAO.find();
			List<Company> companiesAux = new ArrayList<Company>();
			List<List<Product>> allProducts = new ArrayList<List<Product>>();
			for (int i = 0; i < companies.size(); i++) {
				products = productDAO.findBestProductsByComId(companies.get(i).getComId(), 5);
				if(products.isEmpty()) {
//					companies.remove(i);
				} else {
					allProducts.add(products);
					companiesAux.add(companies.get(i));
				}
				
			}
			request.setAttribute("companies", companiesAux);
			request.setAttribute("allProducts", allProducts);
			request.setAttribute("usuer", user);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
