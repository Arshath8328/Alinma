/*
 * PurchaseRequest.java Mar 4, 2018  
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

/**
 * @author Ghada Shawkat
 *
 */
public class PurchaseRequest {
	private String	access_code;
	private String	amount;
	private String	command;
	private String	currency;
	private String	customer_email;
	private String	language;
	private String	merchant_identifier;
	private String	merchant_reference;
	private String	token_name;
	private String	payment_option;
	private String	customer_ip;
	// private String eci;
	// private String card_security_code;
	private String	signature;
	private String	return_url;

	// private String orderDescription;
	// private String customerIp;
	/**
	 * @return the accessCode
	 */
	/**
	 * @return the access_code
	 */
	public String getAccess_code() {
		return access_code;
	}

	/**
	 * @param access_code the access_code to set
	 */
	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
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
	 * @return the customer_email
	 */
	public String getCustomer_email() {
		return customer_email;
	}

	/**
	 * @param customer_email the customer_email to set
	 */
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
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
	 * @return the merchant_identifier
	 */
	public String getMerchant_identifier() {
		return merchant_identifier;
	}

	/**
	 * @param merchant_identifier the merchant_identifier to set
	 */
	public void setMerchant_identifier(String merchant_identifier) {
		this.merchant_identifier = merchant_identifier;
	}

	/**
	 * @return the merchant_reference
	 */
	public String getMerchant_reference() {
		return merchant_reference;
	}

	/**
	 * @param merchant_reference the merchant_reference to set
	 */
	public void setMerchant_reference(String merchant_reference) {
		this.merchant_reference = merchant_reference;
	}

	/**
	 * @return the token_name
	 */
	public String getToken_name() {
		return token_name;
	}

	/**
	 * @param token_name the token_name to set
	 */
	public void setToken_name(String token_name) {
		this.token_name = token_name;
	}

	/**
	 * @return the payment_option
	 */
	public String getPayment_option() {
		return payment_option;
	}

	/**
	 * @param payment_option the payment_option to set
	 */
	public void setPayment_option(String payment_option) {
		this.payment_option = payment_option;
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
	 * @return the customer_ip
	 */
	public String getCustomer_ip() {
		return customer_ip;
	}

	/**
	 * @param customer_ip the customer_ip to set
	 */
	public void setCustomer_ip(String customer_ip) {
		this.customer_ip = customer_ip;
	}

	/**
	 * @return the return_url
	 */
	public String getReturn_url() {
		return return_url;
	}

	/**
	 * @param return_url the return_url to set
	 */
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	/*	*//**
			 * @return the card_security_code
			 */

	/*
	 * public String getCard_security_code() { return card_security_code; }
	 *//**
		 * @param card_security_code the card_security_code to set
		 *//*
			 * public void setCard_security_code(String card_security_code) { this.card_security_code = card_security_code; }
			 */

	public String log() {
		String logs = "";
		if (access_code != null)
			logs += "access_code = " + access_code + "\n";
		else
			logs += "access_code = null";

		if (amount != null)
			logs += "amount = " + amount + "\n";
		else
			logs += "amount = null" + "\n";

		/*
		 * if(card_security_code != null) logs += "card_security_code = "+card_security_code + "\n"; else logs +=
		 * "card_security_code = null" + "\n";
		 */
		if (command != null)
			logs += "command = " + command + "\n";
		else
			logs += "command = null" + "\n";

		if (currency != null)
			logs += "currency = " + currency + "\n";
		else
			logs += "currency = null" + "\n";

		if (customer_email != null)
			logs += "customer_email = " + customer_email + "\n";
		else
			logs += "customer_email = null" + "\n";

		if (customer_ip != null)
			logs += "customer_ip = " + customer_ip + "\n";
		else
			logs += "customer_ip = null" + "\n";

		if (language != null)
			logs += "language = " + language + "\n";
		else
			logs += "language = null" + "\n";

		if (merchant_identifier != null)
			logs += "merchant_identifier = " + merchant_identifier + "\n";
		else
			logs += "merchant_identifier = null" + "\n";

		if (merchant_reference != null)
			logs += "merchant_reference = " + merchant_reference + "\n";
		else
			logs += "merchant_reference = null" + "\n";

		if (payment_option != null)
			logs += "payment_option = " + payment_option + "\n";
		else
			logs += "payment_option = null" + "\n";

		if (return_url != null)
			logs += "return_url = " + return_url + "\n";
		else
			logs += "return_url = null" + "\n";

		if (signature != null)
			logs += "signature = " + signature + "\n";
		else
			logs += "signature = null" + "\n";

		if (token_name != null)
			logs += "token_name = " + token_name + "\n";
		else
			logs += "token_name = null" + "\n";

		return logs;
	}
}
