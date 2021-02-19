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

@WebServlet("/OrderProductDetails")
public class OrderProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		HttpSession hs = request.getSession();
		int custid = (int) hs.getAttribute("custid");
		Model m = new Model();
		m.setPno(pno);
		m.setCustid(custid);
		boolean detail = m.getOrderedProductDetails();
		
		if(detail==true) {
			boolean b = m.getProductPrice();
			if(b==true) {
				int pcost = m.getPcost();
				int tcost = m.getTcost();
				
				hs.setAttribute("tcost", tcost);
				hs.setAttribute("pno", pno);
				hs.setAttribute("pcost", pcost);
				response.sendRedirect("OrderedProductDetail.jsp");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
				rd.forward(request, response);
			}
			
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
			rd.forward(request, response);
		}
	}

}
