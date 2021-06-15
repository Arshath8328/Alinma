/*
 * PurchaseResponse.java Mar 4, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.acl.ws.domain.payFort;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Ghada Shawkat
 *
 */
@JsonIgnoreProperties(
		ignoreUnknown = true
)
public class PurchaseResponse {
	private String				accessCode;
	private double				amount;
	private String				command;
	private String				currency;
	private String				customerEmail;
	private String				language;
	private String				merchantIdentifier;
	private String				merchantReference;
	private String				tokenName;
	private String				paymentOption;
	private String				eci;
	// private String cardSecurityCode;
	private String				signature;
	// private String returnUrl;
	// private String orderDescription;
	private String				customerIP;
	private String				fortId;
	private String				status;
	private String				responseCode;
	private String				responseMessage;
	private String				cardNumber;
	private String				expiryDate;
	private String				authorizationCode;
	private String				threeDsUrl;

	private static final Log	_log	= LogFactoryUtil.getLog(PurchaseResponse.class);

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the eci
	 */
	public String getEci() {
		return eci;
	}

	/**
	 * @param eci the eci to set
	 */
	public void setEci(String eci) {
		this.eci = eci;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the threeDsUrl
	 */
	public String getThreeDsUrl() {
		return threeDsUrl;
	}

	/**
	 * @param threeDsUrl the threeDsUrl to set
	 */
	public void setThreeDsUrl(String threeDsUrl) {
		this.threeDsUrl = threeDsUrl;
	}

	/**
	 * @return the accessCode
	 */
	public String getAccessCode() {
		return accessCode;
	}

	/**
	 * @param accessCode the accessCode to set
	 */
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the merchantIdentifier
	 */
	public String getMerchantIdentifier() {
		return merchantIdentifier;
	}

	/**
	 * @param merchantIdentifier the merchantIdentifier to set
	 */
	public void setMerchantIdentifier(String merchantIdentifier) {
		this.merchantIdentifier = merchantIdentifier;
	}

	/**
	 * @return the merchantReference
	 */
	public String getMerchantReference() {
		return merchantReference;
	}

	/**
	 * @param merchantReference the merchantReference to set
	 */
	public void setMerchantReference(String merchantReference) {
		this.merchantReference = merchantReference;
	}

	/**
	 * @return the tokenName
	 */
	public String getTokenName() {
		return tokenName;
	}

	/**
	 * @param tokenName the tokenName to set
	 */
	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	/**
	 * @return the paymentOption
	 */
	public String getPaymentOption() {
		return paymentOption;
	}

	/**
	 * @param paymentOption the paymentOption to set
	 */
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	/**
	 * @return the customerIP
	 */
	public String getCustomerIP() {
		return customerIP;
	}

	/**
	 * @param customerIP the customerIP to set
	 */
	public void setCustomerIP(String customerIP) {
		this.customerIP = customerIP;
	}

	/**
	 * @return the fortId
	 */
	public String getFortId() {
		return fortId;
	}

	/**
	 * @param fortId the fortId to set
	 */
	public void setFortId(String fortId) {
		this.fortId = fortId;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the authorizationCode
	 */
	public String getAuthorizationCode() {
		return authorizationCode;
	}

	/**
	 * @param authorizationCode the authorizationCode to set
	 */
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String log() {
		_log.info("Logging PurchaseResponse");

		String logs = "";

		try {
			if (accessCode != null)
				logs += "access_code = " + accessCode + "\n";
			else
				logs += "access_code = null";

			logs += "amount = " + amount + "\n";

			if (authorizationCode != null)
				logs += "authorization_code = " + authorizationCode + "\n";
			else
				logs += "authorization_code = null" + "\n";

			if (cardNumber != null)
				logs += "card_number = " + cardNumber + "\n";
			else
				logs += "card_number = null" + "\n";

			if (command != null)
				logs += "command = " + command + "\n";
			else
				logs += "command = null" + "\n";

			if (currency != null)
				logs += "currency = " + currency + "\n";
			else
				logs += "currency = null" + "\n";

			if (customerEmail != null)
				logs += "customer_email = " + customerEmail + "\n";
			else
				logs += "customer_email = null" + "\n";

			if (customerIP != null)
				logs += "customer_ip = " + customerIP + "\n";
			else
				logs += "customer_ip = null" + "\n";

			if (eci != null)
				logs += "eci = " + eci + "\n";
			else
				logs += "eci = null" + "\n";

			if (expiryDate != null)
				logs += "expiryDate = " + expiryDate + "\n";
			else
				logs += "expiryDate = null" + "\n";

			if (fortId != null)
				logs += "fortId = " + fortId + "\n";
			else
				logs += "fortId = null" + "\n";

			if (language != null)
				logs += "language = " + language + "\n";
			else
				logs += "language = null" + "\n";

			if (merchantIdentifier != null)
				logs += "merchant_identifier = " + merchantIdentifier + "\n";
			else
				logs += "merchant_identifier = null" + "\n";

			if (merchantReference != null)
				logs += "merchant_reference = " + merchantReference + "\n";
			else
				logs += "merchant_reference = null" + "\n";

			if (paymentOption != null)
				logs += "payment_option = " + paymentOption + "\n";
			else
				logs += "payment_option = null" + "\n";

			if (responseCode != null)
				logs += "response_code = " + responseCode + "\n";
			else
				logs += "response_code = null" + "\n";

			if (responseMessage != null)
				logs += "response_message = " + responseMessage + "\n";
			else
				logs += "response_message = null" + "\n";

			if (signature != null)
				logs += "signature = " + signature + "\n";
			else
				logs += "signature = null" + "\n";

			if (status != null)
				logs += "status = " + status + "\n";
			else
				logs += "status = null" + "\n";

			if (threeDsUrl != null)
				logs += "threeDsUrl = " + threeDsUrl + "\n";
			else
				logs += "threeDsUrl = null" + "\n";

			if (tokenName != null)
				logs += "token_name = " + tokenName + "\n";
			else
				logs += "token_name = null" + "\n";
		} catch (Throwable e) {
			_log.info("Caught Exception in PurchaseResponse.log");
			e.printStackTrace();
			_log.info(e.getMessage());
			_log.info(e.getCause());
		}

		return logs;
	}
}
