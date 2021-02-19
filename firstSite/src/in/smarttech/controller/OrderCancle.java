package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/OrderCancle")
public class OrderCancle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		HttpSession hs = request.getSession();
		int custid = (int) hs.getAttribute("custid");
		
		Model m = new Model();
		m.setPno(pno);
		m.setCustid(custid);
		
		boolean cancle = m.cancleOrder();
		
		if(cancle==true) {
			response.sendRedirect("OrderCancled.html");
		}
		else {
			response.sendRedirect("OrderCancleError.html");
		}
	}

}
