package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.YourOrderDao;

@WebServlet("/NewDownloader")
public class NewDownloader extends HttpServlet {
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
		byte[] nimage = yd.getImageNew(pno, custid);
		outputStream = response.getOutputStream();
		outputStream.write(nimage);
		outputStream.close();
	}

}
