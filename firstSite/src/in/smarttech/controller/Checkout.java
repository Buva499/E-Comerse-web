package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		HttpSession session = request.getSession();
		session.setAttribute("pno", pno);
		Object custid = session.getAttribute("custid");
		
		if(custid==null) {
			response.sendRedirect("CheckoutLogin.html");;
		}
		else {
			response.sendRedirect("CheckoutForm.jsp");
		}
	}

}
