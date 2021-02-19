package in.smarttech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.ImageDao;
import in.smarttech.model.ImageDto;



@WebServlet("/ImageViewerAdmin")
public class ImageViewerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		ImageDao imageDao = new ImageDao();
		List<ImageDto> list = imageDao.getData();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProduct.jsp");
		dispatcher.forward(request, responce);
	}

}
