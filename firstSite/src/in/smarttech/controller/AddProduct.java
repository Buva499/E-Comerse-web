package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.smarttech.model.Model;

@WebServlet("/AddProduct")
@MultipartConfig(maxFileSize=16177216)
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("pno");
		int pno = Integer.parseInt(no);
		String pname = request.getParameter("pname");
		String catagory = request.getParameter("catagory");
		String pdetails = request.getParameter("pdetails");
		String cost = request.getParameter("pcost");
		int pcost = Integer.parseInt(cost);
		Part pimg = request.getPart("pimg");
		
		try {
			Model m = new Model();
			m.setPno(pno);
			m.setPname(pname);
			m.setCatagory(catagory);
			m.setPdetails(pdetails);
			m.setPcost(pcost);
			m.setImg(pimg);
			
			boolean status = m.addProduct();
			
			if(status==true) {
				RequestDispatcher rd = request.getRequestDispatcher("ImageViewerAdmin");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("AdminPanal.html");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
