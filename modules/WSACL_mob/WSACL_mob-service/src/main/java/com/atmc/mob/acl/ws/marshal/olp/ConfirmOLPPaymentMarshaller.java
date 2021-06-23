/**
 * 
 */
package com.atmc.mob.acl.ws.marshal.olp;

import com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetails;
import com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsRequest;
import com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager.ObjectFactory;

import javax.xml.soap.SOAPException;

/**
 * @author Basel A.Aziz
 * 
 */
public class ConfirmOLPPaymentMarshaller extends OLPMarshaller
{
	
	
	
	public static ConfirmPaymentDetailsRequest marshal(String transactionIdEnc) throws SOAPException
	{
		
		
		ObjectFactory fac = new ObjectFactory();
		ConfirmPaymentDetails pymtDetails = fac.createConfirmPaymentDetails();
		
		ConfirmPaymentDetailsRequest reqParams = fac.createConfirmPaymentDetailsRequest();
		
		reqParams.setTransactionIdEnc(transactionIdEnc);
		reqParams.setMerchantRefNum(MERCHANT_REF_NUM);
		reqParams.setMerchantId(MERCHANT_ID);
		
		pymtDetails.setConfirmPaymentDetailsRequest(reqParams);
		
		return reqParams;
		
	}
	

}
