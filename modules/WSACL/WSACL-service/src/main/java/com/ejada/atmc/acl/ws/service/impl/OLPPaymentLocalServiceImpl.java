/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.atmc.acl.ws.service.impl;

import com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment;
import com.ejada.atmc.acl.ws.domain.InitiateOLPPayment;
import com.ejada.atmc.acl.ws.marshal.olp.ConfirmOLPPaymentMarshaller;
import com.ejada.atmc.acl.ws.marshal.olp.ConfirmOLPPaymentUnmarshaller;
import com.ejada.atmc.acl.ws.marshal.olp.InitiateOLPPaymentMarshaller;
import com.ejada.atmc.acl.ws.marshal.olp.InitiateOLPPaymentUnmarshaller;
import com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.EnterpriseContextType;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsReply;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.ConfirmPaymentDetailsRequest;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsReply;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsRequest;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.SADADPaymentManager;
import com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.SADADPaymentManager_Service;
import com.ejada.atmc.acl.ws.security.OLPWSSecurityHandler;
import com.ejada.atmc.acl.ws.service.base.OLPPaymentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the olp payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.ws.service.OLPPaymentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    OLPPaymentLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.ws.model.OLPPayment",
		service = AopService.class
)
public class OLPPaymentLocalServiceImpl extends OLPPaymentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.ws.service.OLPPaymentLocalServiceUtil} to
	 * access the olp payment local service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(OLPPaymentLocalServiceImpl.class);

	public InitiateOLPPayment initiatePayment(String olpAlias, double amount, String currency, String merchantLandingURL, String merchantFailureURL) {

		try {

			//
			// // Qnames for service as defined in wsdl.
			// QName serviceName = new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			// "SADADPaymentManager");
			// //QName for Port As defined in wsdl.
			// QName portName = new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			// "SADADPaymentManager");
			// //Endpoint Address
			// String endpointAddress = "http://10.0.0.182:8095/SADADPaymentManagement/01_00/SADADPaymentManager";
			// //String endpointAddress = "http://localhost:9080/ErsalWeb/SADADPaymentManager";
			//
			// // Create a dynamic Service instance
			// Service service = Service.create(serviceName);
			//
			//
			// //SADADPaymentManager_Service service = new SADADPaymentManager_Service();
			//
			// // Add a port to the Service
			// service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, endpointAddress);
			//
			// //Create a dispatch instance
			// Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
			//
			// List<Handler> handlerList = dispatch.getBinding().getHandlerChain();
			// if (handlerList == null)
			// handlerList = new ArrayList<Handler>();
			//
			// handlerList.add(new WSSecurityHandler());
			//
			// dispatch.getBinding().setHandlerChain(handlerList);
			//
			// // marshal the header and body
			// SOAPMessage soapRequest = InitiateOLPPaymentMarshaller.marshal(olpAlias, amount, currency, merchantLandingURL,
			// merchantFailureURL);
			//
			// SOAPMessage signedRequest = WSSigner.sign(soapRequest);
			// SOAPMessage soapResponse = dispatch.invoke(signedRequest);
			// System.out.println("response:" + soapResponse);
			//
			//
			//
			// InitiateOLPPaymentUnmarshaller.unmarshal(soapResponse, payment);

			// URL wsdlURL = SADADPaymentManager_Service.WSDL_LOCATION;
			// SADADPaymentManager_Service ss = new SADADPaymentManager_Service(wsdlURL, SERVICE_NAME);
			// QName serviceName = new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			// "SADADPaymentManager");
			// SADADPaymentManager_Service service = new
			// SADADPaymentManager_Service(SADADPaymentManager_Service.WSDL_LOCATION,SERVICE_NAME);

			// marshal request header and body
			EnterpriseContextType requestHeader = InitiateOLPPaymentMarshaller.marshalHeader();
			InitiatePaymentDetailsRequest requestBody = InitiateOLPPaymentMarshaller.marshal(olpAlias, amount, currency, merchantLandingURL, merchantFailureURL);
			// call the service
			InitiatePaymentDetailsReply reply = getPort().initiatePaymentDetails(requestBody, requestHeader);

			// unmarshal the reply
			return InitiateOLPPaymentUnmarshaller.unmarshal(reply);

		} catch (Exception e) {
			e.printStackTrace();
			_log.error("Exception:" + e);
			InitiateOLPPayment payment = new InitiateOLPPayment();
			payment.setResponseCode("9999");
			return payment;
		}

	}

	public ConfirmOLPPayment confirmPayment(String transactionIdEnc) {

		try {

			// marshal request header and body
			EnterpriseContextType requestHeader = InitiateOLPPaymentMarshaller.marshalHeader();
			ConfirmPaymentDetailsRequest requestBody = ConfirmOLPPaymentMarshaller.marshal(transactionIdEnc);

			// call the service
			ConfirmPaymentDetailsReply reply = getPort().confirmPaymentDetails(requestBody, requestHeader);

			// unmarshal the reply
			return ConfirmOLPPaymentUnmarshaller.unmarshal(reply);

		} catch (Exception e) {
			e.printStackTrace();
			_log.error("Exception:" + e);
			ConfirmOLPPayment payment = new ConfirmOLPPayment();
			payment.setResponseCode("9999");
			return payment;
		}

	}

	private SADADPaymentManager getPort() {
		System.setProperty("javax.xml.soap.MessageFactory", "com.sun.xml.internal.messaging.saaj.soap.ver1_2.SOAPMessageFactory1_2Impl");
		System.setProperty("javax.xml.bind.JAXBContext", "com.sun.xml.internal.bind.v2.ContextFactory");

		SADADPaymentManager_Service service = new SADADPaymentManager_Service();
		SADADPaymentManager port = service.getSADADPaymentManager();

		String endpointAddress = PropsUtil.get("ws.olpservice.url");

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);

		List<Handler> handlerList = bp.getBinding().getHandlerChain();
		if (handlerList == null)
			handlerList = new ArrayList<>();

		handlerList.add(new OLPWSSecurityHandler());

		bp.getBinding().setHandlerChain(handlerList);

		return port;

	}

}