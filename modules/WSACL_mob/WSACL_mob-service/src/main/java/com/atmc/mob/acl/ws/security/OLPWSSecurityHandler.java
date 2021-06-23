/**
 * 
 */
package com.atmc.mob.acl.ws.security;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author Basel A.Aziz
 *
 */
public class OLPWSSecurityHandler extends WSLogHandler
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	public Set<QName> getHeaders()
	{
		QName securityHeader = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
		HashSet<QName> headers = new HashSet<QName>();
		headers.add(securityHeader);
		return headers;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleMessage(SOAPMessageContext smc)
	{
		log(smc);
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		 
        if (outboundProperty.booleanValue()) {
 
            //SOAPMessage message = smc.getMessage();
 
            try {
 
            	SOAPMessage signedRequest = OLPWSSecurityUtils.sign(smc.getMessage());
            	smc.setMessage(signedRequest);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        } else {
            try {
                
                //This handler does nothing with the response from the Web Service so
                //we just print out the SOAP message.
                SOAPMessage message = smc.getMessage();
                message.writeTo(System.out);
               // OLPWSSecurityUtils.verify(message);
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }

		return true;
	}
	

}
