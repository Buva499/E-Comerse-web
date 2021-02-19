package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.Model;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		boolean status= false;
		
		try {
			Model m = new Model();
			
			m.setName(name);
			m.setEmail(email);
			m.setPhone(phone);
			m.setPassword(password);
			
			status = m.signUp();
			
			if(status==true) {
				response.sendRedirect("Sucessful.html");
			}
			else {
				response.sendRedirect("Error.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
