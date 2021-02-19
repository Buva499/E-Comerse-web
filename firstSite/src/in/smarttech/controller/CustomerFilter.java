package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CustomerFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Inside Filter");
		String password = request.getParameter("cpassword");
		String cpassword = request.getParameter("ccpassword");
		String cphone = request.getParameter("cphone");
		String cemail = request.getParameter("cemail");
		if(password.equals(cpassword) && cphone.length()==10 && cemail.endsWith("@gmail.com")) {
			request.getServletContext().getRequestDispatcher("/CustomerRegister").forward(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("CustomerRegistrationError.html");
		}
	}
	
}
