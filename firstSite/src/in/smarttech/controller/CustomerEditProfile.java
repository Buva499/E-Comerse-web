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

@WebServlet("/CustomerEditProfile")
public class CustomerEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cname = (String) session.getAttribute("cname");
		String cphone = (String) session.getAttribute("cphone");
		String cemail = (String) session.getAttribute("cemail");
		int custid = (int) session.getAttribute("custid");
		String cpassword = (String) session.getAttribute("cpassword");
		
		
		cname = request.getParameter("cname");
		cphone = request.getParameter("cphone");
		cemail = request.getParameter("cemail");
		cpassword = request.getParameter("cpassword");
		
		Model m = new Model();
		m.setCustid(custid);
		m.setCname(cname);
		m.setCphone(cphone);
		m.setCemail(cemail);
		m.setCpassword(cpassword);
		
		boolean update = m.updateProfile();
		
		if(update==true) {
			response.sendRedirect("CustomerLogin.html");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
			rd.forward(request, response);
		}
	}

}
