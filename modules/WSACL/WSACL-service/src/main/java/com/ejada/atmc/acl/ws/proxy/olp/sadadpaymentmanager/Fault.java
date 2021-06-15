
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for Fault complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fault"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faultCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="faultString" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
		name = "Fault",
		propOrder = { "faultCode", "faultString", "timeStamp" }
)
public class Fault {

	@XmlElement(
			required = true
	)
	protected String				faultCode;
	@XmlElement(
			required = true
	)
	protected String				faultString;
	@XmlElement(
			required = true
	)
	@XmlSchemaType(
			name = "dateTime"
	)
	protected XMLGregorianCalendar	timeStamp;

	/**
	 * Gets the value of the faultCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * Sets the value of the faultCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFaultCode(String value) {
		this.faultCode = value;
	}

	/**
	 * Gets the value of the faultString property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFaultString() {
		return faultString;
	}

	/**
	 * Sets the value of the faultString property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFaultString(String value) {
		this.faultString = value;
	}

	/**
	 * Gets the value of the timeStamp property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the value of the timeStamp property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTimeStamp(XMLGregorianCalendar value) {
		this.timeStamp = value;
	}

}
