package in.smarttech.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.Model;


@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		int custid = random.nextInt(10000);
		String cname = request.getParameter("cname");
		String cphone = request.getParameter("cphone");
		String cemail = request.getParameter("cemail");
		String cpassword = request.getParameter("cpassword");
		
		try {
			Model m = new Model();
			m.setCustid(custid);
			m.setCname(cname);
			m.setCphone(cphone);
			m.setCemail(cemail);
			m.setCpassword(cpassword);
			
			boolean status = m.RegisterCustomer();
			
			if(status==true) {
				response.sendRedirect("./ImageViewerController");
			}
			else {
				response.sendRedirect("CustomerRegister.html");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
