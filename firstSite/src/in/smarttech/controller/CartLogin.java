package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/CartLogin")
public class CartLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cemail = request.getParameter("cemail");
		String cpassword = request.getParameter("cpassword");
		
		Model m = new Model();
		m.setCemail(cemail);
		m.setCpassword(cpassword);
		
		boolean status = m.cartLogin();
		System.out.println(status);
		if(status==true) {
			HttpSession session = request.getSession();
			session.setAttribute("cemail", cemail);
			session.setAttribute("cpassword", cpassword);
			session.setAttribute("custid", m.getCustid());
			session.setAttribute("cphone", m.getCphone());
			session.setAttribute("cname", m.getCname());
			response.sendRedirect("SingleProductDetail.jsp");
		}
		else {
			response.sendRedirect("CartCustomerLogin.html");
		}
	}

}
