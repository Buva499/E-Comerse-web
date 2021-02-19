package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;
import in.smarttech.model.Send;

@WebServlet("/CustomerForgetPass")
public class CustomerForgetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cemail = request.getParameter("cemail");
		HttpSession session = request.getSession(true);
		try {
			Model m = new Model();
			m.setCemail(cemail);
			session.setAttribute("femail", cemail);
			boolean status = m.forgetPassCustomer();
			
			if(status==true) {
				String pnone = m.getCphone();
				int otp = Send.otpGenerate();
				session.setAttribute("otp", otp);
				Send.sendSms("Do not share your otp with anyone. Password Change otp is: "+otp, pnone);
				
				response.sendRedirect("OtpValidation.html");
			}
			else {
				response.sendRedirect("index.html");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
