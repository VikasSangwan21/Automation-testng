package utilities;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	public static void sendMail(){
		final String fromEmail = "pandeypawan304@gmail.com"; //requires valid gmail id
		final String passwd = "piiufknjravdiwpf"; // correct password for gmail id
	       String toEmail = "pandeypawan304@yahoo.com"; // can be any email id
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port


		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, passwd);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);
		try
		{
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse(toEmail, false));

			msg.setSubject("Test", "UTF-8");

			msg.setText(" Test 1 Execution Completed successfully.", "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);  

			System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
