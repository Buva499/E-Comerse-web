package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.AdminOrderDao;

@WebServlet("/NewAdminDownloade")
public class NewAdminDownloade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminOrderDao yd = null;
		ServletOutputStream outputStream = null;
		String no = request.getParameter("pno");
		String[] split = no.split(",");
		String ppno = split[0];
		String ccustid = split[1];
		int pno = Integer.parseInt(ppno);
		int custid = Integer.parseInt(ccustid);
		yd = new AdminOrderDao();
		byte[] nimage = yd.getImageNew(pno, custid);
		outputStream = response.getOutputStream();
		outputStream.write(nimage);
		outputStream.close();
	}

}
