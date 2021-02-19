package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/CheckoutLogin")
public class CheckoutLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cemail = request.getParameter("cemail");
		String cpassword = request.getParameter("cpassword");
		
		Model m = new Model();
		m.setCemail(cemail);
		m.setCpassword(cpassword);
		
		boolean status = m.checkoutLogin();
		System.out.println(status);
		if(status==true) {
			HttpSession session = request.getSession();
			session.setAttribute("cemail", cemail);
			session.setAttribute("cpassword", cpassword);
			session.setAttribute("custid", m.getCustid());
			session.setAttribute("cphone", m.getCphone());
			session.setAttribute("cname", m.getCname());
			RequestDispatcher rd = request.getRequestDispatcher("CheckoutProductDetails");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("CheckoutLogin.html");
		}
	}

}
