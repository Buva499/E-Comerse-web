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

@WebServlet("/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int custid = (int) session.getAttribute("custid");
		
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		Model m = new Model();
		m.setCustid(custid);
		m.setPno(pno);
		
		boolean rem = m.removeCartProduct();
		
		if(rem==true) {
			RequestDispatcher rd = request.getRequestDispatcher("ViewCart");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("ViewCart");
			rd.forward(request, response);
		}
	}

}
