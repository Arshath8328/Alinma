
package com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Contains information about where and when the request was originated.
 * 
 * <p>
 * Java class for RequestOriginator complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestOriginator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requesterCode" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}RequesterCode_Type"/&gt;
 *         &lt;element name="machineIPAddress" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}MachineIPAddress_Type"/&gt;
 *         &lt;element name="userPrincipleName" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}UserPrincipleName_Type"/&gt;
 *         &lt;element name="requestedTimestamp" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}RequestedTimestamp_Type"/&gt;
 *         &lt;element name="channelId" type="{http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext}ChannelId_Type"/&gt;
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
		name = "RequestOriginator",
		propOrder = { "requesterCode", "machineIPAddress", "userPrincipleName", "requestedTimestamp", "channelId" }
)
public class RequestOriginator {

	@XmlElement(
			required = true
	)
	protected String				requesterCode;
	@XmlElement(
			required = true
	)
	protected String				machineIPAddress;
	@XmlElement(
			required = true
	)
	protected String				userPrincipleName;
	@XmlElement(
			required = true
	)
	@XmlSchemaType(
			name = "dateTime"
	)
	protected XMLGregorianCalendar	requestedTimestamp;
	protected int					channelId;

	/**
	 * Gets the value of the requesterCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequesterCode() {
		return requesterCode;
	}

	/**
	 * Sets the value of the requesterCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setRequesterCode(String value) {
		this.requesterCode = value;
	}

	/**
	 * Gets the value of the machineIPAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMachineIPAddress() {
		return machineIPAddress;
	}

	/**
	 * Sets the value of the machineIPAddress property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMachineIPAddress(String value) {
		this.machineIPAddress = value;
	}

	/**
	 * Gets the value of the userPrincipleName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserPrincipleName() {
		return userPrincipleName;
	}

	/**
	 * Sets the value of the userPrincipleName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setUserPrincipleName(String value) {
		this.userPrincipleName = value;
	}

	/**
	 * Gets the value of the requestedTimestamp property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getRequestedTimestamp() {
		return requestedTimestamp;
	}

	/**
	 * Sets the value of the requestedTimestamp property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setRequestedTimestamp(XMLGregorianCalendar value) {
		this.requestedTimestamp = value;
	}

	/**
	 * Gets the value of the channelId property.
	 * 
	 */
	public int getChannelId() {
		return channelId;
	}

	/**
	 * Sets the value of the channelId property.
	 * 
	 */
	public void setChannelId(int value) {
		this.channelId = value;
	}

}
