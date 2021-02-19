package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class VerifyAddress implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Inside Filter");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String modelno = request.getParameter("modelno");
		String size = request.getParameter("size");
		String other = request.getParameter("other");
		
		System.out.println(modelno);
		System.out.println(size);
		System.out.println(other);
		
		
		if(phone.length()==10) {
			if(address.contains("pin") || address.contains("Pin")
					&& address.contains("Tal") || address.contains("tal") && address.contains("Dist")
					|| address.contains("dist")) {
				if(modelno!=null) {
					request.getServletContext().getRequestDispatcher("/Mobile").forward(request, response);
				}
				else if(size!=null) {
					request.getServletContext().getRequestDispatcher("/Tshirt").forward(request, response);
				}
				else {
					request.getServletContext().getRequestDispatcher("/Other").forward(request, response);
				}
			}
			else {
				if(modelno!=null) {
					((HttpServletResponse) response).sendRedirect("MobileCatagory.html");
				}
				else if(size!=null) {
					((HttpServletResponse) response).sendRedirect("TshirtsCatogary.html");
				}
				else {
					((HttpServletResponse) response).sendRedirect("OtherCatagory.html");
				}
			}
		}
		else {
			if(modelno!=null) {
				((HttpServletResponse) response).sendRedirect("MobileCatagory.html");
			}
			else if(size!=null) {
				((HttpServletResponse) response).sendRedirect("TshirtsCatogary.html");
			}
			else {
				((HttpServletResponse) response).sendRedirect("OtherCatagory.html");
			}
		}
	}

	
}
