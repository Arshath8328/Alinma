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

package com.atmc.acl.rest.service.impl;

import com.atmc.acl.rest.service.base.FirebaseLocalServiceBaseImpl;
import com.ejada.atmc.acl.rest.domain.MessageData;
import com.ejada.atmc.acl.rest.domain.Notification;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The implementation of the firebase local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.atmc.acl.rest.service.FirebaseLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    FirebaseLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.atmc.acl.rest.model.Firebase",
		service = AopService.class
)
public class FirebaseLocalServiceImpl extends FirebaseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.rest.service.FirebaseLocalServiceUtil} to
	 * access the firebase local service.
	 */

	private static final String	AUTH_HEADER			= "Authorization";
	private static final String	KEY					= "key=";
	private static final String	CONTENT_TYPE		= "Content-Type";
	private static final String	CONTENT_TYPE_VAL	= "application/json";
//	private String FCM_URL = "https://fcm.googleapis.com/fcm/send";
//	private String SERVER_KEY = "AAAAzlhwSBY:APA91bEYUHtHO3ioeivh1vWF8hWo2qPIx5EDYWjbe3hKnJ7DVz6lbcDAOHsYunsBkBi6czwhTqIBr4tgxbEcO2PgyP1PIqsaELi0htsI5Qk0EGmpLtLzwNLqdQ_aJ3YTSZZgCzr5GOIJ";
	// private String FCM_URL = "http://localhost:8087/FortAPI/paymentPage";
	private String				SERVER_KEY			= PropsUtil.get("firebase.server.key");
	private String				FCM_URL				= PropsUtil.get("firebase.url");

	private String				serverKey;
	private String				fcmUrl;

	public void sendNotification(String tokenId, String title, String message) {

	// TODO get these values from service properties
	fcmUrl = FCM_URL;
	serverKey = SERVER_KEY;

	RestTemplate restTemplate = new RestTemplate();
	MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
	headers.add(AUTH_HEADER, KEY + serverKey);
	headers.add(CONTENT_TYPE, CONTENT_TYPE_VAL);

	MessageData msg = new MessageData();
	msg.setBody(message);
	msg.setTitle(title);

	Notification notification = new Notification();
	notification.setTo(tokenId.trim());
	notification.setNotification(msg);
	HttpEntity<Notification> request = new HttpEntity<Notification>(notification, headers);

	ResponseEntity<String> response = restTemplate.postForEntity(fcmUrl, request, String.class);
	int status = response.getStatusCode().value();
	if (status != 0) {
		if (status == 200) {

			// SUCCESS message
//					BufferedReader reader = new BufferedReader(
//							new InputStreamReader(conn.getInputStream()));
//					logger.info("Android Notification Response : "
//							+ reader.readLine());

			_log.info("success");
		} else if (status == 401) {
			_log.info("401");
			// client side error
//					logger.error("Notification Response : TokenId : "
//							+ tokenId + " Error occurred :");
		} else if (status == 501) {
			_log.info("501");
			// server side error
//					logger.error("Notification Response : [ errorCode=ServerError ] TokenId : "
//									+ tokenId);

		} else if (status == 503) {
			_log.info("503");

			// server side error

//					logger.error("Notification Response : FCM Service is Unavailable  TokenId : "
//									+ tokenId);

		}
	}
	}

	/**
	 * @return the serverKey
	 */
	public String getServerKey() {
	return serverKey;
	}

	/**
	 * @param serverKey the serverKey to set
	 */
	public void setServerKey(String serverKey) {
	this.serverKey = serverKey;
	}

	/**
	 * @return the fcmUrl
	 */
	public String getFcmUrl() {
	return fcmUrl;
	}

	/**
	 * @param fcmUrl the fcmUrl to set
	 */
	public void setFcmUrl(String fcmUrl) {
	this.fcmUrl = fcmUrl;
	}

	Log _log = LogFactoryUtil.getLog(this.getClass());
	
}