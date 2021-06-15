
package com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Contain enterprise specific information that is required on every request.
 * 
 * <p>
 * Java class for EnterpriseContext_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnterpriseContext_Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contextInfo" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}ContextInfo"/&gt;
 *         &lt;element name="requestOriginator" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}RequestOriginator"/&gt;
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
		name = "EnterpriseContext_Type",
		propOrder = { "contextInfo", "requestOriginator" }
)
public class EnterpriseContextType {

	@XmlElement(
			required = true
	)
	protected ContextInfo		contextInfo;
	@XmlElement(
			required = true
	)
	protected RequestOriginator	requestOriginator;

	/**
	 * Gets the value of the contextInfo property.
	 * 
	 * @return possible object is {@link ContextInfo }
	 * 
	 */
	public ContextInfo getContextInfo() {
		return contextInfo;
	}

	/**
	 * Sets the value of the contextInfo property.
	 * 
	 * @param value allowed object is {@link ContextInfo }
	 * 
	 */
	public void setContextInfo(ContextInfo value) {
		this.contextInfo = value;
	}

	/**
	 * Gets the value of the requestOriginator property.
	 * 
	 * @return possible object is {@link RequestOriginator }
	 * 
	 */
	public RequestOriginator getRequestOriginator() {
		return requestOriginator;
	}

	/**
	 * Sets the value of the requestOriginator property.
	 * 
	 * @param value allowed object is {@link RequestOriginator }
	 * 
	 */
	public void setRequestOriginator(RequestOriginator value) {
		this.requestOriginator = value;
	}

}
