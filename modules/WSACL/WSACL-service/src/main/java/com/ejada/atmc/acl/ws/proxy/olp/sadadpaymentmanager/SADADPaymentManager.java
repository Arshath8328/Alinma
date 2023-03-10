package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.1 2017-11-21T13:49:39.917+02:00 Generated source version: 3.2.1
 * 
 */
@WebService(
		targetNamespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
		name = "SADADPaymentManager"
)
@XmlSeeAlso(
	{ com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.ObjectFactory.class, ObjectFactory.class }
)
public interface SADADPaymentManager {

	/**
	 * Initiate Payment Details - Operation name, input wrapper, output wrapper and fault wrapper.
	 * 
	 */
	@WebMethod(
			operationName = "InitiatePaymentDetails",
			action = "InitiatePaymentDetails"
	)
	@Action(
			input = "InitiatePaymentDetails",
			output = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1/SADADPaymentManager/InitiatePaymentDetailsResponse",
			fault = { @FaultAction(
					className = Fault_Exception.class,
					value = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1/SADADPaymentManager/InitiatePaymentDetails/Fault/Fault"
			) }
	)
	@RequestWrapper(
			localName = "InitiatePaymentDetails",
			targetNamespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			className = "com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetails"
	)
	@ResponseWrapper(
			localName = "InitiatePaymentDetailsResponse",
			targetNamespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			className = "com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsResponse"
	)
	@WebResult(
			name = "InitiatePaymentDetailsReply",
			targetNamespace = ""
	)
	public com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsReply initiatePaymentDetails(@WebParam(
			name = "InitiatePaymentDetailsRequest",
			targetNamespace = ""
	)
	com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsRequest initiatePaymentDetailsRequest, @WebParam(
			name = "enterpriseContext",
			targetNamespace = "http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext",
			header = true
	)
	com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.EnterpriseContextType enterpriseHeader) throws Fault_Exception;

	/**
	 * Confirm Payment Details - Operation name, input wrapper, output wrapper and fault wrapper.
	 * 
	 */
	@WebMethod(
			operationName = "ConfirmPaymentDetails",
			action = "ConfirmPaymentDetails"
	)
	@Action(
			input = "ConfirmPaymentDetails",
			output = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1/SADADPaymentManager/ConfirmPaymentDetailsResponse",
			fault = { @FaultAction(
					className = Fault_Exception.class,
					value = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1/SADADPaymentManager/ConfirmPaymentDetails/Fault/Fault"
			) }
	)
	@RequestWrapper(
			localName = "ConfirmPaymentDetails",
			targetNamespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			className = "com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetails"
	)
	@ResponseWrapper(
			localName = "ConfirmPaymentDetailsResponse",
			targetNamespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			className = "com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsResponse"
	)
	@WebResult(
			name = "ConfirmPaymentDetailsReply",
			targetNamespace = ""
	)
	public com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsReply confirmPaymentDetails(@WebParam(
			name = "ConfirmPaymentDetailsRequest",
			targetNamespace = ""
	)
	com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsRequest confirmPaymentDetailsRequest, @WebParam(
			name = "enterpriseContext",
			targetNamespace = "http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext",
			header = true
	)
	com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.EnterpriseContextType enterpriseHeader) throws Fault_Exception;
}
