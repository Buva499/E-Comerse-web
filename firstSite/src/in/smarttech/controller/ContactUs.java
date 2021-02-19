package in.smarttech.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.smarttech.model.Send;



@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		
		//Code for sending mails to admin
		final String username = "email";
        final String password = "pass";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("perfectsublimations@gmail.com")
            );
            message.setSubject("Regarding Contact Request");
            message.setText("Dear Sir,\nBelow is my personal details for contacting to me.\nName: "+first_name+" "+last_name+"\n"+"Phone Number: "+
            phone+"\n"+"Subject: "+subject+"\n\n Regards,\n"+first_name+" "+last_name);

            Transport.send(message);
            
            //Code for sending messages to contact person
            Send.sendSms("Thank you for contacting us..\nOur team will contact you soon.", phone);
            
            RequestDispatcher rd = request.getRequestDispatcher("ImageViewerController");
            rd.forward(request, response);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

	}

}
