package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/OrderStatus")
public class OrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		HttpSession session = request.getSession();
		int custid = (int) session.getAttribute("custid");
		
		Model m = new Model();
		m.setCustid(custid);
		m.setPno(pno);
		
		boolean stat = m.getStatus();
		
		if(stat==true) {
			session.setAttribute("status", m.getOstatus());
			response.sendRedirect("Status.jsp");
		}
		else {
			response.sendRedirect("ErrorStatus.html");
		}
	}

}
