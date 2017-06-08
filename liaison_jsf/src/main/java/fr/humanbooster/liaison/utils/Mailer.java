package fr.humanbooster.liaison.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class Mailer {
	
	private final String VRECASENS_HB_MAIL = "vrecasens@humanbooster.com";
	private final String VRECASENS_HB_MDP = "boostercdi0809";
	
	public boolean sendSimpleMail(String emailDestinataire, String sujet, String contenu){
		
		boolean check = false;
		Email email = new SimpleEmail();
		email.setHostName("ns0.ovh.net");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(VRECASENS_HB_MAIL, VRECASENS_HB_MDP));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(VRECASENS_HB_MAIL);
			email.setSubject("TestMail");
			email.setMsg(contenu);
			email.addTo(emailDestinataire);
			email.send();
			
			check = true;
			return check;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean sendJoinedMail(String emailDestinataire){
		
		boolean check = false;
		EmailAttachment attachment = new EmailAttachment();
		 

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("ns0.ovh.net");
		  email.setSmtpPort(587);
		  email.setAuthenticator(new DefaultAuthenticator(VRECASENS_HB_MAIL, VRECASENS_HB_MDP));
		  email.setSSLOnConnect(true);
		  try {
			  attachment.setURL(new URL("https://www.clelia.fr/MementoJava.pdf"));
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription("Picture of Lilith");
			  attachment.setName("Lilith");
			  
			  email.addTo(emailDestinataire);
			  email.setFrom(VRECASENS_HB_MAIL);
			  email.setSubject("The picture");
			  email.setMsg("Here is the picture you wanted");

			  // add the attachment
			  email.attach(attachment);

			  // send the email
			  email.send();
				
				check = true;
				return check;
		} catch (EmailException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

}
