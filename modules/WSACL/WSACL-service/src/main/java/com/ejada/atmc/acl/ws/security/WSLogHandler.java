/**
 * 
 */
package com.ejada.atmc.acl.ws.security;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author Basel A.Aziz
 * 
 */
public class WSLogHandler implements SOAPHandler<SOAPMessageContext> {
	private static final Log	_log	= LogFactoryUtil.getLog(WSLogHandler.class);
	// change this to redirect output if desired
	private static PrintStream	out		= System.out;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	public void close(MessageContext arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleFault(SOAPMessageContext smc) {
		log(smc);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleMessage(SOAPMessageContext smc) {
		log(smc);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	public Set<QName> getHeaders() {
		return null;
	}

	/*
	 * Check the MESSAGE_OUTBOUND_PROPERTY in the context to see if this is an outgoing or incoming message. Write a brief
	 * message to the print stream and output the message. The writeTo() method can throw SOAPException or IOException
	 */
	protected void log(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			_log.info("Outbound message:");

		} else {
			_log.info("Inbound message:");
		}

		SOAPMessage message = smc.getMessage();
		try {
			ByteArrayOutputStream st = new ByteArrayOutputStream();
			message.writeTo(st);
			String s = new String(st.toByteArray());
			_log.info(s);
		} catch (Exception e) {
			_log.info("Exception in handler: " + e);
		}
	}

}
