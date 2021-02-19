package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		String cust = request.getParameter("custid");
		int custid = Integer.parseInt(cust);
		
		HttpSession session = request.getSession();
		session.setAttribute("pno", pno);
		session.setAttribute("custid", custid);
		
		response.sendRedirect("UpdateOrderStatus.html");
		
	}

}
