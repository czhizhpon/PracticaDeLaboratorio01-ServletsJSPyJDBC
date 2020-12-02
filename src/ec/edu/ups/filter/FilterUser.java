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

import ec.edu.ups.model.User;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter()
//@WebFilter({"/JSP/private/user/*", "/CreateBilldetail", "/UpdateBilldetail",  "/DeleteBilldetail", "/UpdateBillhead",  "/DeleteBillhead"})
public class FilterUser implements Filter {

    /**
     * Default constructor. 
     */
    public FilterUser() {
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
		HttpSession session =  httpReq.getSession(false);

		try {
			User user = (User)session.getAttribute("user");
			
			sesion = session == null ? false : (Boolean) session.getAttribute("isLogged");
			
			if (sesion) {
				if (user.getUseRole() == 'U') {
					chain.doFilter(request, response);
//					httpResp.sendRedirect("JSP/");
				}else {
					session.invalidate();
					httpResp.sendRedirect("/sgrc/HTML/login.html");
				}
			}else {
				session.invalidate();
				httpResp.sendRedirect("/sgrc/HTML/login.html");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
