package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/FindCheckoutCatagory")
public class FindCheckoutCatagory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		Model m = new Model();
		m.setPno(pno);
		
		String cato = m.getCheckoutCatagory();
		
		HttpSession session = request.getSession();
		session.setAttribute("cost", m.getPcost());
		if(cato.equalsIgnoreCase("mobile")) {
			response.sendRedirect("MobileCatagory.html");
		}
		else if(cato.equalsIgnoreCase("t shirts")) {
			response.sendRedirect("TshirtsCatogary.html");
		}
		
		else if(cato.equalsIgnoreCase("mug")) {
			response.sendRedirect("OtherCatagory.html");
		}
		else if(cato.equalsIgnoreCase("pillow cover")){
			response.sendRedirect("OtherCatagory.html");
		}
		else {
			response.sendRedirect("OtherCatagory.html");
		}
	}

}
