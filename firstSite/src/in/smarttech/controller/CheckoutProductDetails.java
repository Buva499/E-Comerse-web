package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/CheckoutProductDetails")
public class CheckoutProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int pno = (int) session.getAttribute("pno");
		Model m = new Model();
		m.setPno(pno);
		
		boolean detail = m.getProductDetails();
		HttpSession hs = request.getSession();
		if(detail==true) {
			hs.setAttribute("pno", pno);
			response.sendRedirect("CheckoutProductDetail.jsp");
		}
		else {
			response.sendRedirect("ProductDetailError.html");
		}
	}

}
