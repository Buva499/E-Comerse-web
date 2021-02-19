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

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qt = request.getParameter("qty");
		int qty = Integer.parseInt(qt);
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		HttpSession session = request.getSession();
		Object custid = session.getAttribute("custid");
		Model m = new Model();
		if(custid==null) {
			response.sendRedirect("CartCustomerLogin.html");
		}
		else {
			int cust = (int) session.getAttribute("custid");
			Object cost = session.getAttribute("pcost");
			if(cost==null) {
				m.setPno(pno);
				boolean price = m.getProductPrice();
				if(price==true) {
					int pcost = m.getPcost();
					int tcost = pcost*qty;
					m.setCustid(cust);
					m.setPno(pno);
					m.setQty(qty);
					m.setTcost(tcost);
					boolean status = m.addCart();
					
					if(status==true) {
						RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
						rd.forward(request, response);
					}
					else {
						response.sendRedirect("ErrorCart.html");
					}
				}
			}
			
		}
	}

}
