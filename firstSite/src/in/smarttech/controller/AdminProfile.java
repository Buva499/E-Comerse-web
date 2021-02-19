package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/AdminProfile")
public class AdminProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		
		try {
			Model m = new Model();
			m.setEmail(email);
			m.setPassword(password);
			
			boolean status = m.adminProfile();
			
			if(status==true) {
				session.setAttribute("name", m.getName());
				session.setAttribute("phone", m.getPhone());
				responce.sendRedirect("AdminProfile.jsp");
			}
			else {
				responce.sendRedirect("AdminPanal.html");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
