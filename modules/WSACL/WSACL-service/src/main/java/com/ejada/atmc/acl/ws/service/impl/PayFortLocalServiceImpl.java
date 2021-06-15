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

import com.ejada.atmc.acl.ws.domain.payFort.PurchaseRequest;
import com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse;
import com.ejada.atmc.acl.ws.service.base.PayFortLocalServiceBaseImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The implementation of the pay fort local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.ws.service.PayFortLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    PayFortLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.ws.model.PayFort",
		service = AopService.class
)
public class PayFortLocalServiceImpl extends PayFortLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(PayFortLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.ws.service.PayFortLocalServiceUtil} to
	 * access the pay fort local service.
	 */
	public PurchaseResponse doPurchase(PurchaseRequest req) {
		ResponseEntity<String> response = null;
		PurchaseResponse purchaseResponse = new PurchaseResponse();
		try {
			String purchaseUrl = PropsUtil.get("com.ejada.atmc.payfort.purchase.url");// "https://sbpaymentservices.PayFort.com/FortAPI/paymentApi";
			RestTemplate restTempl = new RestTemplate();// getRestTemplate();

			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("Content-Type", "application/json");

			HttpEntity<PurchaseRequest> request = new HttpEntity<PurchaseRequest>(req, headers);
			_log.info("################ Payfort Purchase Response. Before Exchange");
			_log.info("PurchaseUrl:" + purchaseUrl);
			_log.info(" HttPEntity Request:" + request);
			response = restTempl.exchange(purchaseUrl, HttpMethod.POST, request, String.class);// postForEntity(purchaseUrl, new
																								// HttpEntity<Object>(headers),
																								// PurchaseResponse.class);//exchange(purchaseUrl,
																								// HttpMethod.POST, new HttpEntity<Object>(headers),
																								// PurchaseResponse.class, requestParams);
			_log.info("################ Payfort Purchase Response Returned");
			_log.info(response);

			if (response != null) {
				_log.info("Response status code:" + response.getStatusCode());
				_log.info("Response Body:" + response.getBody());
			} else {
				_log.info("Response is null");
			}

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (response != null && response.getStatusCode() != null && response.getStatusCode().equals(HttpStatus.OK)) {
				_log.info("Before Mapping");
				map = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
				});
				_log.info("After Mapping");
			}

			purchaseResponse.setAccessCode((map.get("access_code") != null) ? map.get("access_code").toString() : null);
			purchaseResponse.setAmount((map.get("amount") != null) ? Double.valueOf(map.get("amount").toString()) : 0.0);
			purchaseResponse.setAuthorizationCode((map.get("authorization_code") != null) ? map.get("authorization_code").toString() : null);
			purchaseResponse.setCardNumber((map.get("card_number") != null) ? map.get("card_number").toString() : "");
			purchaseResponse.setCommand((map.get("command") != null) ? map.get("command").toString() : "");
			purchaseResponse.setCurrency((map.get("currency") != null) ? map.get("currency").toString() : "");
			purchaseResponse.setCustomerEmail((map.get("customer_email") != null) ? map.get("customer_email").toString() : "");
			purchaseResponse.setCustomerIP((map.get("customer_ip") != null) ? map.get("customer_ip").toString() : "");
			purchaseResponse.setEci((map.get("eci") != null) ? map.get("eci").toString() : "");
			purchaseResponse.setExpiryDate((map.get("expiry_date") != null) ? map.get("expiry_date").toString() : "");
			purchaseResponse.setFortId((map.get("fort_id") != null) ? map.get("fort_id").toString() : "");
			purchaseResponse.setLanguage((map.get("language") != null) ? map.get("language").toString() : "");
			purchaseResponse.setMerchantIdentifier((map.get("merchant_identifier") != null) ? map.get("merchant_identifier").toString() : "");
			purchaseResponse.setMerchantReference((map.get("merchant_reference") != null) ? map.get("merchant_reference").toString() : "");
			purchaseResponse.setPaymentOption((map.get("payment_option") != null) ? map.get("payment_option").toString() : "");
			purchaseResponse.setResponseCode((map.get("response_code") != null) ? map.get("response_code").toString() : "");
			purchaseResponse.setResponseMessage((map.get("response_message") != null) ? map.get("response_message").toString() : "");
			purchaseResponse.setSignature((map.get("signature") != null) ? map.get("signature").toString() : "");
			purchaseResponse.setStatus((map.get("status") != null) ? map.get("status").toString() : "");
			purchaseResponse.setThreeDsUrl((map.get("3ds_url") != null) ? map.get("3ds_url").toString() : "");
			purchaseResponse.setTokenName((map.get("token_name") != null) ? map.get("token_name").toString() : "");

			_log.info("Finished Response Setters");

			return purchaseResponse;
		} catch (Exception e) {
			_log.info("Exception in PayFortLocalServiceImpl.doPurchase");
			_log.info(e.getMessage());
			_log.info(e.getCause());
			e.printStackTrace();
			return null;
		}

	}
}