/**
 * 
 */
package com.ejada.atmc.acl.ws.marshal.olp;

import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsRequest;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.Merchant;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ObjectFactory;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

/**
 * @author Basel A.Aziz
 * 
 */
public class InitiateOLPPaymentMarshaller extends OLPMarshaller {

	public static InitiatePaymentDetailsRequest marshal(String olpAlias, double amount, String currency, String merchantLandingURL, String merchantFailureURL) throws SOAPException {
//		MessageFactory fac = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
//		SOAPMessage soapPmtDetailsRequest = fac.createMessage();
//		
//		SOAPHeader soapMsgHeader = soapPmtDetailsRequest.getSOAPHeader();
//		if (soapMsgHeader == null)
//		{
//			soapMsgHeader = soapPmtDetailsRequest.getSOAPPart().getEnvelope().addHeader();
//		}
//		soapMsgHeader.addChildElement(marshalHeader());
//		
//		
//		SOAPElement initiatePaymentDetails = soapFactory.createElement("InitiatePaymentDetails", "", "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1");
//		SOAPElement initiatePaymentDetailsRequest = initiatePaymentDetails.addChildElement("InitiatePaymentDetailsRequest");
//		initiatePaymentDetailsRequest.addChildElement("transactionAmount").addTextNode(String.valueOf(amount));
//		initiatePaymentDetailsRequest.addChildElement("olpIdAlias").addTextNode(olpAlias);
//		initiatePaymentDetailsRequest.addChildElement("merchantRefNum").addTextNode(MERCHANT_REF_NUM);
//		
//		SOAPElement merchants = initiatePaymentDetailsRequest.addChildElement("merchants");
//		merchants.addChildElement("merchantId").addTextNode(String.valueOf(MERCHANT_ID));
//		merchants.addChildElement("merchantRefNum").addTextNode(MERCHANT_REF_NUM);
//		merchants.addChildElement("paymentAmount").addTextNode(String.valueOf(amount));
//		merchants.addChildElement("paymentCurrency").addTextNode(currency);
//		merchants.addChildElement("merchantType").addTextNode(String.valueOf(MERCHANT_TYPE));
//		
//		initiatePaymentDetailsRequest.addChildElement("dynamicMerchantLandingURL").addTextNode(merchantLandingURL);
//		initiatePaymentDetailsRequest.addChildElement("dynamicMerchantFailureURL").addTextNode(merchantFailureURL);
//		initiatePaymentDetailsRequest.addChildElement("merchantId").addTextNode(String.valueOf(MERCHANT_ID));
//
//		soapPmtDetailsRequest.getSOAPBody().addChildElement(initiatePaymentDetails);
//		
//		return soapPmtDetailsRequest;

		ObjectFactory fac = new ObjectFactory();
		// InitiatePaymentDetails pymtDetails = fac.createInitiatePaymentDetails();
		InitiatePaymentDetailsRequest pymDetailsRequest = fac.createInitiatePaymentDetailsRequest();

		pymDetailsRequest.setTransactionAmount(amount);
		pymDetailsRequest.setOlpIdAlias(olpAlias);
		;
		pymDetailsRequest.setMerchantRefNum(MERCHANT_REF_NUM);
		;

		Merchant mrch = fac.createMerchant();
		mrch.setMerchantId(MERCHANT_ID);
		mrch.setMerchantRefNum(MERCHANT_REF_NUM);
		mrch.setMerchantType(MERCHANT_TYPE);
		mrch.setPaymentAmount(amount);
		mrch.setPaymentCurrency(currency);

		pymDetailsRequest.getMerchants().add(mrch);

		pymDetailsRequest.setDynamicMerchantLandingURL(merchantLandingURL);
		pymDetailsRequest.setDynamicMerchantFailureURL(merchantFailureURL);
		pymDetailsRequest.setMerchantId(MERCHANT_ID);

		// pymtDetails.setInitiatePaymentDetailsRequest(pymDetailsRequest);

		return pymDetailsRequest;

	}

	public static SOAPMessage marshalSecurityHeader(SOAPMessage soapRequest, SOAPHeaderElement securityElement) throws SOAPException {
		soapRequest.getSOAPHeader().addChildElement(securityElement);
		return soapRequest;
	}

}
