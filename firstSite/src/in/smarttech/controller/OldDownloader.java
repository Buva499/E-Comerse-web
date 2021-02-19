package in.smarttech.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.YourOrderDao;

@WebServlet("/OldDownloader")
public class OldDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	YourOrderDao yd = null;
		ServletOutputStream outputStream = null;
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		HttpSession session = request.getSession();
		int custid = (int) session.getAttribute("custid");
		yd = new YourOrderDao();
		byte[] oimage = yd.getImageOld(pno, custid);
		
		if(oimage==null) {
			RequestDispatcher rd = request.getRequestDispatcher("NewDownloader");
			rd.forward(request, response);
			
		}
		else {
			outputStream = response.getOutputStream();
			outputStream.write(oimage);
			outputStream.close();
		}
    }

}
