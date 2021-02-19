package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);
		boolean status = false;
		
		try {
			Model m = new Model();
			m.setEmail(email);
			m.setPassword(password);
			
			status = m.login();
			if(status==true) {
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				response.sendRedirect("AdminPanal.html");
			}
			else {
				response.sendRedirect("login.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
