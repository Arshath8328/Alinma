package com.ejada.atmc.acl.ws.security;

import com.ejada.atmc.acl.ws.utils.SOAPUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import javax.xml.soap.SOAPMessage;

import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.util.XMLUtils;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSConfig;
import org.apache.wss4j.dom.engine.WSSecurityEngine;
import org.apache.wss4j.dom.handler.WSHandlerResult;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.w3c.dom.Document;

/**
 * @author Basel A.Aziz
 * 
 */
public class OLPWSSecurityUtils {

	private static final Log		_log			= LogFactoryUtil.getLog(OLPWSSecurityUtils.class);
	public static final String		CERT_ALIAS		= PropsUtil.get("ws.olpservice.cert.alias");
	public static final String		CERT_PASSWORD	= PropsUtil.get("ws.olpservice.cert.pass");
	public static final String		CRYPTO_PROPS	= "olp-crypto.properties";

	private static WSSecurityEngine	secEngine		= new WSSecurityEngine();

	public static SOAPMessage sign(SOAPMessage message) throws Exception {
		WSSConfig.init();
		Crypto crypto = CryptoFactory.getInstance(CRYPTO_PROPS);

		WSSecHeader secHeader = new WSSecHeader(message.getSOAPPart());
		secHeader.insertSecurityHeader();

		WSSecSignature builder = new WSSecSignature(secHeader);
		builder.setUserInfo(CERT_ALIAS, CERT_PASSWORD);
		builder.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
		builder.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
		builder.setDigestAlgo("http://www.w3.org/2001/04/xmlenc#sha256");
		_log.info("Before Signing ....");

		Document signedDoc = builder.build(crypto);

		_log.info("Signed message with Binary Security Token:");
		String outputString = XMLUtils.prettyDocumentToString(signedDoc);
		_log.info(outputString);
		_log.info("After Signing ....");
		return SOAPUtils.toSOAPMessage(signedDoc);
	}

	/**
	 * Verifies the soap envelope. This method verifies all the signature generated.
	 *
	 * @param  env soap envelope
	 * @throws     java.lang.Exception Thrown when there is a problem in verification
	 */
	public static WSHandlerResult verify(SOAPMessage message) throws Exception {
		Crypto crypto = CryptoFactory.getInstance(CRYPTO_PROPS);

		return secEngine.processSecurityHeader(message.getSOAPPart(), null, null, crypto);
	}

}
