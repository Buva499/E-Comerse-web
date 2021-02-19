package in.smarttech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.smarttech.model.Model;

@WebServlet("/DownloadOrderedProduct")
public class DownloadOrderedProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs= req.getSession();
		int pno = (int) hs.getAttribute("pno");
		int custid = (int) hs.getAttribute("custid");
		ServletOutputStream os=null;
		
		Model m = new Model();
		m.setPno(pno);
		m.setCustid(custid);
		boolean result=m.getOrderedImage();
		if(result==true)
		{
			if(m.getPimg()!=null) {
				byte[] img1=m.getPimg();
				os=res.getOutputStream();//Printwriter p=arg1.getWriter();
				os.write(img1);//p.print();	
			}
			else {
				byte[] imgs = m.getImgs();
				os = res.getOutputStream();
				os.write(imgs);
			}
		}
		else
		{
			res.sendRedirect("error.html");
		}
	}
}
