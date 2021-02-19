package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import in.smarttech.model.ViewCartDao;

@WebServlet("/DownloadCartProduct")
public class DownloadCartProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViewCartDao yd = null;
		ServletOutputStream outputStream = null;
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		yd = new ViewCartDao();
		byte[] oimage = yd.getImage(pno);
		
		outputStream = response.getOutputStream();
		outputStream.write(oimage);
		outputStream.close();
		
	}
}
