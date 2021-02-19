package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/CustomerChangetPass")
public class CustomerChangetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpassword = request.getParameter("cpassword");
		String ccpassword = request.getParameter("ccpassword");
		
		if(cpassword.equals(ccpassword)) {
			HttpSession session = request.getSession();
			String cemail = (String) session.getAttribute("femail");
			Model m = new Model();
			m.setCemail(cemail);
			m.setCpassword(cpassword);
			
			boolean change = m.changeCustomerPassword();
			
			if(change==true) {
				response.sendRedirect("CustomerLogin.html");
			}
			else {
				response.sendRedirect("index.html");
			}
		}
		
	}

}
