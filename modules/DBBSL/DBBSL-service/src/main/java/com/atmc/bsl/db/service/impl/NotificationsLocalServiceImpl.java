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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.base.NotificationsLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.service.SMSLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the notifications local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.NotificationsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationsLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.Notifications", service = AopService.class)
public class NotificationsLocalServiceImpl extends NotificationsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.NotificationsLocalServiceUtil} to access the
	 * notifications local service.
	 */
	static Map<String, String[]> map = new HashMap<String, String[]>();
	static {
		String[] QE_NP_typeInfo = { "QUOTATION_EXPIRY_AND_NOT_PAID_SMS", null, "QUOTATION_EXPIRY_AND_NOT_PAID_TITLE",
				"QUOTATION_EXPIRY_AND_NOT_PAID_WEB" };
		String[] QPF_typeInfo = { null, "QUOTATION_PAYMENT_FAILED", "QUOTATION_PAYMENT_FAILED_TITLE",
				"QUOTATION_PAYMENT_FAILED_WEB" };
		String[] QG_OD_PS_typeInfo = { "QUOTATION_GENERATION_OD_PENDING_SURVEY_SMS",
				"QUOTATION_GENERATION_OD_PENDING_SURVEY", "QUOTATION_GENERATION_OD_PENDING_SURVEY_TITLE",
				"QUOTATION_GENERATION_OD_PENDING_SURVEY_WEB" };
		String[] QG_OD_PP_typeInfo = { "QUOTATION_GENERATION_OD_PENDING_PAYMENT_SMS",
				"QUOTATION_GENERATION_OD_PENDING_PAYMENT", "QUOTATION_GENERATION_OD_PENDING_PAYMENT_TITLE",
				"QUOTATION_GENERATION_OD_PENDING_PAYMENT_WEB" };
		String[] QG_TPL_typeInfo = { "QUOTATION_GENERATION_TPL_SMS", "QUOTATION_GENERATION_TPL",
				"QUOTATION_GENERATION_TPL_TITLE", "QUOTATION_GENERATION_TPL_WEB" };
		String[] TP_QF_typeInfo2 = { null, "TEMP_PASSWORD_QUOTATION_FLOW", "TEMP_PASSWORD_QUOTATION_FLOW_TITLE",
				"TEMP_PASSWORD_QUOTATION_FLOW_WEB" };
		String[] PIE_typeInfo = { "POLICY_ISSUANCE_EMAIL_SMS", "POLICY_ISSUANCE_EMAIL", "POLICY_ISSUANCE_EMAIL_TITLE",
				"POLICY_ISSUANCE_EMAIL_WEB" };
		String[] PCI_typeInfo = { "POST_CLAIM_INTIMATION_SMS", "POST_CLAIM_INTIMATION", "POST_CLAIM_INTIMATION_TITLE",
				"POST_CLAIM_INTIMATION_WEB" };
		String[] SRC_typeInfo = { "SERVICE_REQUEST_COMPLAINT_SMS", "SERVICE_REQUEST_COMPLAINT",
				"SERVICE_REQUEST_COMPLAINT_TITLE", "SERVICE_REQUEST_COMPLAINT_WEB" };
		String[] SRI_typeInfo = { null, "SERVICE_REQUEST_INQUIRY", "SERVICE_REQUEST_INQUIRY_TITLE",
				"SERVICE_REQUEST_INQUIRY_WEB" };
		String[] SRS_typeInfo = { null, "SERVICE_REQUEST_SUGGESTION", "SERVICE_REQUEST_SUGGESTION_TITLE",
				"SERVICE_REQUEST_SUGGESTION_WEB" };
		String[] CSRC_typeInfo = { "CLOSURE_SERVICE_REQUEST_COMPLAINT_SMS", null,
				"CLOSURE_SERVICE_REQUEST_COMPLAINT_TITLE", "CLOSURE_SERVICE_REQUEST_COMPLAINT_WEB" };
		String[] CSRI_typeInfo = { null, "CLOSURE_SERVICE_REQUEST_INQUIRY", "CLOSURE_SERVICE_REQUEST_INQUIRY_TITLE",
				"CLOSURE_SERVICE_REQUEST_INQUIRY_WEB" };
		String[] CR_MD_typeInfo = { "CLAIM_REQUEST_MISSING_DOCUMENTS_SMS", "CLAIM_REQUEST_MISSING_DOCUMENTS",
				"CLAIM_REQUEST_MISSING_DOCUMENTS_TITLE", "CLAIM_REQUEST_MISSING_DOCUMENTS_WEB" };
		String[] ENDOR_RCVD_typeInfo = { "POILCY_ENDORSEMENT_RECIEVED_SMS", "POILCY_ENDORSEMENT_RECIEVED_EMAIL",
				"POILCY_ENDORSEMENT_RECIEVED_TITLE", "POILCY_ENDORSEMENT_RECIEVED_EMAIL_WEB" };
		String[] ENDOR_RJCT_typeInfo = { "POILCY_ENDORSEMENT_REJECTED_SMS", "POILCY_ENDORSEMENT_REJECTED_EMAIL",
				"POILCY_ENDORSEMENT_REJECTED_TITLE", "POILCY_ENDORSEMENT_REJECTED_EMAIL_WEB" };
		String[] ENDOR_WP_typeInfo = { "POILCY_ENDORSEMENT_WP_SMS", "POILCY_ENDORSEMENT_WP_EMAIL",
				"POILCY_ENDORSEMENT_WP_TITLE", "POILCY_ENDORSEMENT_WP_EMAIL_WEB" };
		String[] ENDOR_SUCC_typeInfo = { "POILCY_ENDORSEMENT_SUCCESS_SMS", "POILCY_ENDORSEMENT_SUCCESS_EMAIL",
				"POILCY_ENDORSEMENT_SUCCESS_TITLE", "POILCY_ENDORSEMENT_SUCCESS_EMAIL_WEB" };
		String[] ENDOR_req_email_srvc_typeInfo = { null, "NEW_REQUEST_CANCELLATION__CUSTOMER_SERVICE_WEB", null, null };
		String[] ENDOR_req_Other__email_srvc_typeInfo = { null, "NEW_REQUEST_ENDORSMENT__CUSTOMER_SERVICE_WEB", null,
				null };
		String[] policy_Rejet_srvc_typeInfo = { null, "POLICY_REJECTION_SERVICE_WEB", null, null };
		String[] QE_pre_expire = { "QUOTATION_PRE_EXPIRY", null, null, null };
		String[] QE_post_expire = { "QUOTATION_POST_EXPIRY", null, null, null };

		map.put("QUOTATION_PRE_EXPIRY", QE_pre_expire);
		map.put("QUOTATION_POST_EXPIRY", QE_post_expire);
		map.put("QUOTATION_EXPIRY_AND_NOT_PAID", QE_NP_typeInfo);
		map.put("QUOTATION_PAYMENT_FAILED", QPF_typeInfo);
		map.put("QUOTATION_GENERATION_OD_PENDING_SURVEY", QG_OD_PS_typeInfo);
		map.put("QUOTATION_GENERATION_OD_PENDING_PAYMENT", QG_OD_PP_typeInfo);
		map.put("QUOTATION_GENERATION_TPL", QG_TPL_typeInfo);
		map.put("TEMP_PASSWORD_QUOTATION_FLOW", TP_QF_typeInfo2);
		map.put("POLICY_ISSUANCE_EMAIL", PIE_typeInfo);
		map.put("POST_CLAIM_INTIMATION", PCI_typeInfo);
		map.put("SERVICE_REQUEST_COMPLAINT", SRC_typeInfo);
		map.put("SERVICE_REQUEST_INQUIRY", SRI_typeInfo);
		map.put("SERVICE_REQUEST_SUGGESTION", SRS_typeInfo);
		map.put("CLOSURE_SERVICE_REQUEST_COMPLAINT", CSRC_typeInfo);
		map.put("CLOSURE_SERVICE_REQUEST_INQUIRY", CSRI_typeInfo);
		map.put("CLAIM_REQUEST_MISSING_DOCUMENTS", CR_MD_typeInfo);
		map.put("POILCY_ENDORSEMENT_RECIEVED", ENDOR_RCVD_typeInfo);
		map.put("POILCY_ENDORSEMENT_REJECTED", ENDOR_RJCT_typeInfo);
		map.put("POILCY_ENDORSEMENT_WP", ENDOR_WP_typeInfo);
		map.put("POILCY_ENDORSEMENT_SUCCESS", ENDOR_SUCC_typeInfo);
		map.put("POILCY_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL", ENDOR_req_email_srvc_typeInfo);
		map.put("POILCY_OTHER_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL", ENDOR_req_Other__email_srvc_typeInfo);
		map.put("POILCY_REJECTED_EMAIL", policy_Rejet_srvc_typeInfo);

	}

	public static final int DELIVERY_TYPE_WEBSITE = UserNotificationDeliveryConstants.TYPE_WEBSITE;
	public static final String MODE_ALL = "all";
	public static final String MODE_READ = "read";

	public long getAllNotificationsCount(long userId, boolean actionRequired) throws PortalException {

		long allNotificationsCount = UserNotificationEventLocalServiceUtil
				.getDeliveredUserNotificationEventsCount(userId, DELIVERY_TYPE_WEBSITE, true, actionRequired);

		return allNotificationsCount;
	}

	public long getUnreadNotificationsCount(long userId) throws PortalException {

		long unreadNotificationsCount = 0;

		List<UserNotificationEvent> notifications = getAllNotifications(userId, false);
		for (UserNotificationEvent userNotificationEvent : notifications) {
			if (!userNotificationEvent.getArchived())
				unreadNotificationsCount++;
		}

		return unreadNotificationsCount;
	}

	public List<UserNotificationEvent> getNotifications(long userId, boolean actionRequired, String mode, int start,
			int end) throws PortalException {

		if (mode.equals(MODE_ALL)) {

			return UserNotificationEventLocalServiceUtil.getDeliveredUserNotificationEvents(userId,
					DELIVERY_TYPE_WEBSITE, true, actionRequired, start, end);
		} else {

			boolean archived = false;

			if (mode.equals(MODE_READ)) {
				archived = true;
			}

			return UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEvents(userId,
					DELIVERY_TYPE_WEBSITE, actionRequired, archived, start, end);
		}
	}

	public void markAllNotificationsAsRead(long userId) throws PortalException {

		List<UserNotificationEvent> notifications = getAllNotifications(userId, false);
		for (UserNotificationEvent userNotificationEvent : notifications) {
			userNotificationEvent.setArchived(true);
			UserNotificationEventLocalServiceUtil.updateUserNotificationEvent(userNotificationEvent);
		}

	}

	public List<UserNotificationEvent> getAllNotifications(long userId, boolean actionRequired) throws PortalException {

		return UserNotificationEventLocalServiceUtil.getDeliveredUserNotificationEvents(userId, DELIVERY_TYPE_WEBSITE,
				true, actionRequired, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public void addNotification(long userId, String msgKey, String[] params, String notificationType, long companyId) {
		JSONObject payload = JSONFactoryUtil.createJSONObject();

		payload.put("notificationParams", params);
		payload.put("userId", userId);
		payload.put("msgKey", msgKey);

		UserNotificationEvent notification = UserNotificationEventLocalServiceUtil
				.createUserNotificationEvent(CounterLocalServiceUtil.increment());

		notification.setCompanyId(companyId);
		notification.setUserId(userId);
		notification.setPayload(payload.toString());
		notification.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
		notification.setDeliverBy(userId);
		notification.setTimestamp(new Date().getTime());
		notification.setArchived(false);
		notification.setDelivered(true);
		notification.setType(notificationType);

		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(notification);

	}

	public void deleteAllNotifications(long[] userNotificationEventIds) throws PortalException {
		for (long userNotificationEventId : userNotificationEventIds) {
			UserNotificationEventLocalServiceUtil.deleteUserNotificationEvent(userNotificationEventId);
		}
	}

	public void deleteUserNotificationEvent(long userNotificationEventId) throws PortalException {
		UserNotificationEventLocalServiceUtil.deleteUserNotificationEvent(userNotificationEventId);
	}

	public void markNotificationAsRead(long userNotificationEventId) throws PortalException {

		updateArchived(userNotificationEventId, true);
	}

	public void markNotificationAsUnread(long userNotificationEventId) throws PortalException {

		updateArchived(userNotificationEventId, false);
	}

	public void markNotificationsAsRead(long[] userNotificationEventIds) throws PortalException {

		for (long userNotificationEventId : userNotificationEventIds) {
			updateArchived(userNotificationEventId, true);
		}
	}

	public void markNotificationsAsUnread(long[] userNotificationEventIds) throws PortalException {

		for (long userNotificationEventId : userNotificationEventIds) {
			updateArchived(userNotificationEventId, false);
		}

	}

	protected void updateArchived(long userNotificationEventId, boolean archived) throws PortalException {

		UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil
				.fetchUserNotificationEvent(userNotificationEventId);

		if (userNotificationEvent == null) {
			return;
		}

		userNotificationEvent.setArchived(archived);

		UserNotificationEventLocalServiceUtil.updateUserNotificationEvent(userNotificationEvent);
	}

	public void notifyUser(Locale locale, String notificationType, String mailTo, String mobileNo, String[] mailParams,
			String[] smsParams, List<File> attachedFiles, List<String> filesName, String[] portalNotificationParams,
			long userId, long companyId) throws PortalException {
		logger.info("Notify User. Notification Type:" + notificationType + "...mailTo:" + mailTo + "...mobileNo:"
				+ mobileNo + "...Locale:" + locale.toString());

		String smsMsg = "";
		String mailMsg = "";
		String mailSubject = "";

		if (notificationType != null && !notificationType.equals("")) {
			String[] typeInfo = map.get(notificationType);
			String smsMsgKey = typeInfo[0];
			String mailMsgKey = typeInfo[1];
			String mailSubjectKey = typeInfo[2];
			String webMsgKey = typeInfo[3];
			mailSubject = LanguageUtil.get(locale, mailSubjectKey);
			if (smsMsgKey != null) {
				smsMsg = LanguageUtil.format(locale, smsMsgKey, smsParams);
			}

			if (mailMsgKey != null) {
				mailMsg = LanguageUtil.format(locale, mailMsgKey, mailParams);
			}

			logger.info("smsMsgKey = " + smsMsgKey);
			logger.info("mailMsgKey = " + mailMsgKey);
			logger.info("smsMsg = " + smsMsg);
			logger.info("mailMsg = " + mailMsg);

			if (mailTo != null && !mailTo.equals("") && mailMsgKey != null) {
				logger.info("Sending Email to: " + mailTo + "...mailSubject:" + mailSubject);

				boolean mailFlag = SendEmailServiceUtil.sendEmail(mailTo, mailSubject, mailMsg, filesName,
						attachedFiles);

				if (mailFlag) {
					logger.info("Email sent Successfully");
				} else {
					logger.error("Failed to send Email for notificationtType_" + notificationType);
				}
			}

			logger.info("mobileNo = " + mobileNo);

			if (mobileNo != null && !mobileNo.equals("") && smsMsgKey != null) {
				try {
					logger.info("Sending SMS");

					if (!mobileNo.startsWith("0")) {
						mobileNo = "0" + mobileNo;
					}

					logger.info("Final Mobile Notified:" + mobileNo);
					SMSLocalServiceUtil.sendSms(smsMsg, mobileNo);
					logger.info("sms send successfully ");
				} catch (PortalException | SQLException e) {
					logger.error("Failed to send SMS for notificationtType_" + notificationType);
					e.printStackTrace();
				}
			}

			if (webMsgKey != null && portalNotificationParams != null && portalNotificationParams.length > 0
					&& userId != 0 && companyId != 0) {
				addNotification(userId, webMsgKey, portalNotificationParams, notificationType, companyId);
			}
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(NotificationsLocalServiceImpl.class);
}