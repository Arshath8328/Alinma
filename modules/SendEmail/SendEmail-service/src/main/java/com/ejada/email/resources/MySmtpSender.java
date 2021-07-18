package com.ejada.email.resources;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.smtp.SMTPTransport;

/**
 * The smtp mail sender !!! if you faced certificate truststore errors on WAS
 * import Smtp server certs using retrieve from port method
 * https://www.ibm.com/support
 * /knowledgecenter/en/SSAW57_8.5.5/com.ibm.websphere.
 * nd.doc/ae/tsec_sslretrievesignersport.html
 * 
 * @author Gasser
 * 
 */

public class MySmtpSender {
	private String smtpHost;
	private String smtpAuth;
	private String smtpUser;
	private String smtpPassword;
	private String mailFrom;
	private String transportProtocol;
	final private String xMailer = "STC - ejada - voting system";

	/**
	 * Sends an SMTP mail
	 * 
	 * @param mailTo
	 *            The message To, it could be multiple recipients
	 * @param mailSubject
	 *            The mail subject
	 * @param mailText
	 *            the mail body
	 * @throws MessagingException
	 * 
	 * @returns true on success
	 */
	
	public MySmtpSender(){
		
		smtpHost = "smtp.gmail.com";
		smtpAuth = "true";
		smtpUser = "your_email@gmail.com";
		smtpPassword = "*******";
		mailFrom = "your_email@gmail.com";
		transportProtocol = "smtps";
	}
	public boolean sendMail(String mailTo, String mailSubject, String mailText) {
		Properties props = System.getProperties();
		props.put("mail.smtps.host", smtpHost);
		props.put("mail.smtps.auth", smtpAuth);
		
		props.put("mail.smtp.ssl.enable", true);
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(mailFrom));

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailTo, false));
			msg.setSubject(mailSubject);
			msg.setText(mailText);
			msg.setHeader("X-Mailer", xMailer);
			msg.setSentDate(new Date());
			SMTPTransport t = (SMTPTransport) session
					.getTransport(transportProtocol);
			t.connect(smtpHost, smtpUser, smtpPassword);
			t.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Response: " + t.getLastServerResponse());
			t.close();
			
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;

	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}
}
