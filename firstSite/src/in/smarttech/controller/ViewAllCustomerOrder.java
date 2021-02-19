package in.smarttech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.AdminOrderDao;
import in.smarttech.model.YourOrderDto;



@WebServlet("/ViewAllCustomerOrder")
public class ViewAllCustomerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminOrderDao adminOrderDao = new AdminOrderDao();
		List<YourOrderDto> list = adminOrderDao.getData();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminOrder.jsp");
		dispatcher.forward(request, response);
	}
}
