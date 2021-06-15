/**
 * 
 */
package com.ejada.atmc.acl.ws.security;

import com.liferay.portal.kernel.util.PropsUtil;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author Basel A.Aziz
 * 
 */
public class NajmWSSecurityHandler extends WSLogHandler {
	private static final String	NAJM_USERNAME	= PropsUtil.get("com.ejada.atmc.najm.username");
	private static final String	NAJM_PASSWORD	= PropsUtil.get("com.ejada.atmc.najm.password");
	// change this to redirect output if desired
	private static PrintStream	out				= System.out;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleMessage(SOAPMessageContext smc) {
		log(smc);
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {

			SOAPMessage message = smc.getMessage();

			try {

				SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if (header == null)
					header = envelope.addHeader();

				SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

				SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
				usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

				SOAPElement username = usernameToken.addChildElement("Username", "wsse");
				username.addTextNode(NAJM_USERNAME);

				SOAPElement password = usernameToken.addChildElement("Password", "wsse");
				password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
				password.addTextNode(NAJM_PASSWORD);

				// Print out the outbound SOAP message to System.out
				message.writeTo(System.out);
				System.out.println("");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			try {

				// This handler does nothing with the response from the Web Service so
				// we just print out the SOAP message.
				SOAPMessage message = smc.getMessage();
				message.writeTo(System.out);
				System.out.println("");

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return outboundProperty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	public Set<QName> getHeaders() {
		QName securityHeader = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
		HashSet<QName> headers = new HashSet<QName>();
		headers.add(securityHeader);
		return headers;
	}

}
