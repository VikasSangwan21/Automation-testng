package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class EmailUtils {


	public static void main(String... args) {
	} public static void sendMail(){
		
	Properties props = new Properties();

		//load a properties file from class path, inside static method
		String projectPath=System.getProperty("user.dir");
		try {
			props.load(new FileInputStream(projectPath+"/../qc-utilities/src/test/resources/configuration/emailList.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//get the property value and print it out
		final String fromEmail = props.getProperty("fromEmail");
		final String passwd =props.getProperty("passwd");
		String toEmail=props.getProperty("toEmail");
		String filename=props.getProperty("filename");
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
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
			msg.setFrom(new InternetAddress(fromEmail, "LYNX FLEET-AUTOMATION"));
			msg.setReplyTo(InternetAddress.parse(toEmail, false));
			msg.setSubject("Execution Results", "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			//Transport.send(msg);  
			// Second part is attachment
			// Create the message body part
	         BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setText("Hello Team, \n \n Please find the execution results.");
	         // Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();
	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);
	         messageBodyPart = new MimeBodyPart();
	         filename= System.getProperty("user.dir")+props.getProperty("filename");
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         // Send the complete message parts
	         msg.setContent(multipart);
			Transport.send(msg);
			

			//System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
