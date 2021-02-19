package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConfirmOtp")
public class ConfirmOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tp = request.getParameter("eotp");
		int eotp = Integer.parseInt(tp);
		HttpSession session = request.getSession();
		int otp = (int) session.getAttribute("otp");
		if(eotp==otp) {
			response.sendRedirect("ChangePassPage.html");
		}
		else {
			response.sendRedirect("index.html");
		}
	}

}
