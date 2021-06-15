/**
 * 
 */
package com.ejada.atmc.acl.ws.marshal.olp;

import com.ejada.atmc.acl.ws.domain.InitiateOLPPayment;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsReply;

import javax.xml.soap.SOAPException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Basel A.Aziz
 * 
 */
public class InitiateOLPPaymentUnmarshaller {
	public static InitiateOLPPayment unmarshal(InitiatePaymentDetailsReply response) throws SOAPException {
//		//InitiateOLPPaymentRespImpl initPayment = new InitiateOLPPaymentRespImpl();
//		SOAPBody soapBody = response.getSOAPBody();
//		
//		Node initiatePaymentDetailsResponse = getFirstChildElement(soapBody);
//		Node initiatePaymentDetailsReply = getFirstChildElement(initiatePaymentDetailsResponse);
//		Node responseCode = getFirstChildElement(initiatePaymentDetailsReply, "responseCode");
//		
//		//initPayment.setOutputCode(responseCode.getTextContent());
//		
//		if(responseCode.getTextContent().equals("00"))
//		{
//			
//			
//			Node pymtTransDetails = getFirstChildElement(initiatePaymentDetailsReply, "initiatePaymentTransactionDetails");
//			
//			//InitiateOLPPaymentResp olpResponse = new InitiateOLPPaymentResp();
//			
//			initPayment.setAbRefNum(getFirstChildElement(pymtTransDetails, "abRefNum").getTextContent());
//			initPayment.setMerchantRefNum(getFirstChildElement(pymtTransDetails, "merchantRefNum").getTextContent());
//			initPayment.setIbURL(getFirstChildElement(pymtTransDetails, "ibURL").getTextContent());
//			
//			//initPayment.setOutputObject(olpResponse);
//		}

		InitiateOLPPayment payment = new InitiateOLPPayment();
		payment.setResponseCode(response.getResponseCode());
		if (response.getResponseCode().equals("00")) {

			payment.setAbRefNum(response.getInitiatePaymentTransactionDetails().getAbRefNum());
			payment.setMerchantRefNum(response.getInitiatePaymentTransactionDetails().getMerchantRefNum());
			payment.setIbURL(response.getInitiatePaymentTransactionDetails().getIbURL());
		} else {
			payment.setErrorCode(response.getBankBusinessException().getErrorCode());
			payment.setErrorMessage(response.getBankBusinessException().getErrorMessage());
		}

		return payment;
	}

	/**
	 * 
	 * This function is used to get the first child element(which is Element Node type) for the passed node
	 * 
	 * @param  node
	 * @return      First Child Element Or Null if not exist
	 * @see
	 */
	private static Node getFirstChildElement(Node node) {
		Node firstChildElement = null;
		if (node != null && node.hasChildNodes()) {
			NodeList nodeChilds = node.getChildNodes();
			for (int childIndex = 0; childIndex < nodeChilds.getLength(); childIndex++) {
				Node child = nodeChilds.item(childIndex);
				if (child instanceof Element && child.getNodeType() == Node.ELEMENT_NODE) {
					firstChildElement = child;
					break;
				}
			}
		}
		return firstChildElement;
	}

	/**
	 * 
	 * This function is used to get the first child element(which is Element Node type) for the passed node
	 * 
	 * @param  node
	 * @return      First Child Element Or Null if not exist
	 * @see
	 */
	private static Node getFirstChildElement(Node node, String childName) {
		Node firstChildElement = null;
		if (node != null && node.hasChildNodes()) {
			NodeList nodeChilds = node.getChildNodes();
			for (int childIndex = 0; childIndex < nodeChilds.getLength(); childIndex++) {
				Node child = nodeChilds.item(childIndex);
				if (child instanceof Element && child.getNodeType() == Node.ELEMENT_NODE) {
					Element childElement = (Element) child;
					if (childElement.getNodeName().equals(childName)) {
						firstChildElement = childElement;
						break;
					}

				}
			}
		}
		return firstChildElement;
	}

	/**
	 * 
	 * This function is used to get the first child element(which is Element Node type) for the passed node
	 * 
	 * @param  node
	 * @return      First Child Element Or Null if not exist
	 * @see
	 */
	private static Node getChildElement(Node parentElement, String childTagName) {
		Node child = getFirstChildElement(parentElement);
		if (child != null) {
			child = (Element) child;
			if (child.getNodeName().equals(childTagName)) {
				return child;
			} else {
				getChildElement(child, childTagName);
			}
		}
		return null;
	}

}
