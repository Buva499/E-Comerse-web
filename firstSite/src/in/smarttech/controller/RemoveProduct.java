package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.Model;

@WebServlet("/RemoveProduct")
public class RemoveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		try {
			Model m = new Model();
			m.setPno(pno);
			
			boolean status = m.remove();
			
			if(status==true) {
				RequestDispatcher rd = request.getRequestDispatcher("ImageViewerAdmin");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("AdminPanal.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
