package in.smarttech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.smarttech.model.Model;
import in.smarttech.model.Send;

@WebServlet("/Tshirt")
@MultipartConfig(maxFileSize=16177216)
public class Tshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Taking customer id and ordered product number from session to insert into table
				HttpSession session = request.getSession();
				int pno = (int) session.getAttribute("pno");
				int custid = (int) session.getAttribute("custid");
				
				//Getting all the values from MobileCatagory
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String qt = request.getParameter("qty");
				int qty = Integer.parseInt(qt);
				String size = request.getParameter("size");
				Part cimg = request.getPart("cimg"); //if it is zero then add old image
				String paymode = request.getParameter("paymode");
				
				Model m = new Model();
				m.setFname(fname);
				m.setLname(lname);
				m.setPhone(phone);
				m.setAddress(address);
				m.setQty(qty);
				m.setSize(size);
				m.setCimg(cimg);
				m.setPaymode(paymode);
				m.setCustid(custid);
				m.setPno(pno);
				if(cimg.getSize()==0) {
					boolean image = m.getImage();
					if(image==true) {
						byte[] pimg = m.getPimg();
						int pcost = m.getPcost();
						int tcost = 0;
						//Delivery Charges apply process
						String low = address.toLowerCase();
						
						if(low.contains("kagal") || low.contains("mangue") || low.contains("talandge")
								|| low.contains("yalgud") || low.contains("ingali") || low.contains("rendal")
								|| low.contains("hupari") || low.contains("rui") || low.contains("ichalkaranji")
								|| low.contains("rangoli") || low.contains("mankapur") || low.contains("uchagaon")
								|| low.contains("vadgaon") || low.contains("hatkanangle") || low.contains("yadrav")
								|| low.contains("dhonewadi") || low.contains("vasagde") || low.contains("kodoli")
								|| low.contains("sabgav") || low.contains("jangamvadi") || low.contains("boragav")
								|| low.contains("mangav") || low.contains("sangavde") || low.contains("alatvadi")) {
							tcost = (pcost*qty);
							m.setPimg(pimg);
							m.setTcost(tcost);
						}
						
						else {
							tcost = (pcost*qty)+50;
							
							m.setPimg(pimg);
							m.setTcost(tcost);
						}
						boolean status = m.placeProductTshirt();
						
						if(status==true) {
							
							Send.sendSms("Your order placed successfully of rs."+pcost 
									+" with delivery charges"+ (tcost-(pcost*qty))+" Your total amout is "+tcost+" Thank your for being part of us. Regards Perfect Sublimation", phone);
							RequestDispatcher rd = request.getRequestDispatcher("YourOrder");
							rd.forward(request, response);
						}
						else {
							RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
							rd.forward(request, response);
						}
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
						rd.forward(request, response);
					}
					
				}
				else {
					boolean getPrice = m.getProductPrice();
					if(getPrice==true) {
						int pcost = m.getPcost();
						String low = address.toLowerCase();
						int tcost = 0;
						if(low.contains("kagal") || low.contains("mangue") || low.contains("talandge")
								|| low.contains("yalgud") || low.contains("ingali") || low.contains("rendal")
								|| low.contains("hupari") || low.contains("rui") || low.contains("ichalkaranji")
								|| low.contains("rangoli") || low.contains("mankapur") || low.contains("uchagaon")
								|| low.contains("vadgaon") || low.contains("hatkanangle") || low.contains("yadrav")
								|| low.contains("dhonewadi") || low.contains("vasagde") || low.contains("kodoli")
								|| low.contains("sabgav") || low.contains("jangamvadi") || low.contains("boragav")
								|| low.contains("mangav") || low.contains("sangavde") || low.contains("alatvadi")) {
							tcost = (pcost*qty);
						
							m.setTcost(tcost);
						}
						
						else {
							tcost = (pcost*qty)+50;
							
							m.setTcost(tcost);
						}
						
						boolean status = m.placeProductTshirt();
						
						if(status==true) {
							
							Send.sendSms("Your order placed successfully of rs."+pcost 
									+" with delivery charges"+ (tcost-(pcost*qty))+" Your total amout is "+tcost+" Thank your for being part of us. Regards Perfect Sublimation", phone);
							RequestDispatcher rd = request.getRequestDispatcher("YourOrder");
							rd.forward(request, response);
						}
						else {
							RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
							rd.forward(request, response);
						}
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("CustomerImageViewerController");
						rd.forward(request, response);
					}
				}
	}

}
