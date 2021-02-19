package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CustomerProfile")
public class CustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int custid = (int) session.getAttribute("custid");
    	if(custid!=0) {
    		//System.out.println(session.getAttribute("cname"));
    		//System.out.println(session.getAttribute("cphone"));
    		//System.out.println(session.getAttribute("cemail"));
    		response.sendRedirect("CustomerProfile.jsp");
    	}
    	else {
    		RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
			rd.forward(request, response);
    	}
    }

}
