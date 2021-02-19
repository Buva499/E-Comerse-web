package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.ImageDao;



@WebServlet("/ImageDownloader")
public class ImageDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		ImageDao imageDao = null;
		ServletOutputStream outputStream = null;
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		
		imageDao = new ImageDao();
		byte[] image = imageDao.getImage(pno);
		outputStream = responce.getOutputStream();
		outputStream.write(image);
		outputStream.close();
		
	}
}
