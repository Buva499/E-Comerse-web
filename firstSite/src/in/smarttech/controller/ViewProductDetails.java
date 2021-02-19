package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/ViewProductDetails")
public class ViewProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		Model m = new Model();
		m.setPno(pno);
		
		boolean detail = m.getProductDetails();
		HttpSession hs = request.getSession();
		if(detail==true) {
			hs.setAttribute("pno", pno);
			response.sendRedirect("SingleProductDetail.jsp");
		}
		else {
			response.sendRedirect("ProductDetailError.html");
		}
	}

}
