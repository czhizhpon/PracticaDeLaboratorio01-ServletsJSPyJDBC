package ec.edu.ups.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter({"/CreateCategory",  "/ReadCategory",  "/UpdateCategory",  "/DeleteCategory",  "/CreateCompany",
	"/ReadCompany",  "/UpdateCompany",  "/DeleteCompany",  "/CreateProduct",  "/ReadProduct",  "/UpdateProduct",
	"/DeleteProduct",  "/CreateUser",  "/ReadUser",  "/UpdateUser",  "/DeleteUser",  "/JSP/private/admin/*",
	"/CreateBilldetail",  "/ReadBilldetail",  "/UpdateBilldetail",  "/DeleteBilldetail",  "/CreateBillhead",
	"/ReadBillhead",  "/UpdateBillhead",  "/DeleteBillhead",  "/ListProduct", "/store"})
public class FilterLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean sesion;
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		try {
			HttpSession session =  httpReq.getSession(false);
			sesion = session == null ? false : (Boolean) session.getAttribute("isLogged");
			if (sesion) {
				chain.doFilter(request, response);
			}else {
				session.invalidate();
				httpResp.sendRedirect("/sgrc/HTML/login.html");
			}
		} catch (Exception e) {
			httpResp.sendRedirect("/sgrc/HTML/login.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
