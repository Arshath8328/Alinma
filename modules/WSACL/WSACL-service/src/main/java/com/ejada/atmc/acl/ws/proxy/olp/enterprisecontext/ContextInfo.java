
package com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Contains information about the context within which the request is executing.
 * 
 * <p>
 * Java class for ContextInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContextInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProcessContextId" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}ProcessContextId_Type"/&gt;
 *         &lt;element name="businessContextId" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}BusinessContextId_Type"/&gt;
 *         &lt;element name="applicationContextId" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}ApplicationContextId_Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(
	XmlAccessType.FIELD
)
@XmlType(
		name = "ContextInfo",
		propOrder = { "processContextId", "businessContextId", "applicationContextId" }
)
public class ContextInfo {

	@XmlElement(
			name = "ProcessContextId",
			required = true
	)
	protected String	processContextId;
	@XmlElement(
			required = true
	)
	protected String	businessContextId;
	protected int		applicationContextId;

	/**
	 * Gets the value of the processContextId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProcessContextId() {
		return processContextId;
	}

	/**
	 * Sets the value of the processContextId property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setProcessContextId(String value) {
		this.processContextId = value;
	}

	/**
	 * Gets the value of the businessContextId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBusinessContextId() {
		return businessContextId;
	}

	/**
	 * Sets the value of the businessContextId property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setBusinessContextId(String value) {
		this.businessContextId = value;
	}

	/**
	 * Gets the value of the applicationContextId property.
	 * 
	 */
	public int getApplicationContextId() {
		return applicationContextId;
	}

	/**
	 * Sets the value of the applicationContextId property.
	 * 
	 */
	public void setApplicationContextId(int value) {
		this.applicationContextId = value;
	}

}
