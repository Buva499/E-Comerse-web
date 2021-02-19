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


import in.smarttech.model.YourOrderDao;
import in.smarttech.model.YourOrderDto;


@WebServlet("/YourOrder")
public class YourOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int custid = (int) session.getAttribute("custid");
		
		
		YourOrderDao yourOrderDao = new YourOrderDao();
		
		List<YourOrderDto> list = yourOrderDao.getData(custid);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("YourOrder.jsp");
		dispatcher.forward(request, responce);
	}
	
}
