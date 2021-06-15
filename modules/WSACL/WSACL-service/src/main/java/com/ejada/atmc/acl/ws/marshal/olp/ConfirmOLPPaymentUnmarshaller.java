/**
 * 
 */
package com.ejada.atmc.acl.ws.marshal.olp;

import com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsReply;

import javax.xml.soap.SOAPException;

/**
 * @author Basel A.Aziz
 * 
 */
public class ConfirmOLPPaymentUnmarshaller {
	public static ConfirmOLPPayment unmarshal(ConfirmPaymentDetailsReply response) throws SOAPException {

		ConfirmOLPPayment payment = new ConfirmOLPPayment();

		payment.setResponseCode(response.getResponseCode());
		if (response.getResponseCode().equals("00")) {

			payment.setAbRefNum(response.getConfirmPaymentTransactionDetails().getAbRefNum());
			payment.setMerchantRefNum(response.getConfirmPaymentTransactionDetails().getMerchantRefNum());
			payment.setPaymentStatus(String.valueOf(response.getConfirmPaymentTransactionDetails().getPaymentStatus()));
			payment.setTransactionId(response.getConfirmPaymentTransactionDetails().getTransactionId());

		} else {
			payment.setErrorCode(response.getBankBusinessException().getErrorCode());
			payment.setErrorMessage(response.getBankBusinessException().getErrorMessage());
		}

		return payment;
	}

}
