package ec.edu.ups.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.model.Product;

/**
 * Servlet implementation class ListProductTemp
 */
@WebServlet("/ListProductTemp")
public class ListProductTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DIV = 7;
	
	private int maxPages;
	private int currentPage;
	private int n;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductTemp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < 30; i++) {
			Product product = new Product();
			product.setProId(i);
			products.add(product);
		}
		n = products.size();
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			currentPage = 0;
		}
		maxPages = (int)((n - 1) / DIV);
        var min = currentPage * DIV;
        var max = min + (DIV - 1);
        if(max >= n){
            max = n - 1;
        }
        products = products.subList(min, max + 1);
        
        min = currentPage - 3;
        if(min < 0) {
        	min = 0;
        }
        max = currentPage + 3;
        if(max >= maxPages) {
        	max = maxPages;
        }
        request.setAttribute("productsList", products);
		request.setAttribute("min", min);
		request.setAttribute("max", max);
		request.setAttribute("maxPages", maxPages);
		request.setAttribute("currentPage", currentPage);
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
