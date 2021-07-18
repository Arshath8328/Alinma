package com.ejada.atmc.acl.rest.domain;

/**
 * @author Basel
 *
 */
public class Notification {
	
	private String to = "";
	private MessageData notification;
	
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the notification
	 */
	public MessageData getNotification() {
		return notification;
	}
	/**
	 * @param notification the notification to set
	 */
	public void setNotification(MessageData notification) {
		this.notification = notification;
	}

	
}
