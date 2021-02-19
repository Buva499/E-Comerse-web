package in.smarttech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.ViewCartDao;
import in.smarttech.model.ViewCartDto;

@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Object cus = session.getAttribute("custid");
    	if(cus==null) {
    		responce.sendRedirect("CustomerLogin.html");
    	}
    	else {
    		int custid = (int) session.getAttribute("custid");
    		ViewCartDao viewCart = new ViewCartDao();
    		
    		List<ViewCartDto> list = viewCart.getData(custid);
    		request.setAttribute("lst", list);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("MyCart.jsp");
    		dispatcher.forward(request, responce);
    	}
		
		
		
    }

}
