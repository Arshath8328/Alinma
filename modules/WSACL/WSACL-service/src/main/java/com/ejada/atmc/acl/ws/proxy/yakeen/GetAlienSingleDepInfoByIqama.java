
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienSingleDepInfoByIqama complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienSingleDepInfoByIqama">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienSingleDepInfoByIqamaRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienSingleDepInfoByIqamaRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(
	XmlAccessType.FIELD
)
@XmlType(
		name = "getAlienSingleDepInfoByIqama",
		propOrder = { "alienSingleDepInfoByIqamaRequest" }
)
public class GetAlienSingleDepInfoByIqama {

	@XmlElement(
			name = "AlienSingleDepInfoByIqamaRequest"
	)
	protected AlienSingleDepInfoByIqamaRequest alienSingleDepInfoByIqamaRequest;

	/**
	 * Gets the value of the alienSingleDepInfoByIqamaRequest property.
	 * 
	 * @return possible object is {@link AlienSingleDepInfoByIqamaRequest }
	 * 
	 */
	public AlienSingleDepInfoByIqamaRequest getAlienSingleDepInfoByIqamaRequest() {
		return alienSingleDepInfoByIqamaRequest;
	}

	/**
	 * Sets the value of the alienSingleDepInfoByIqamaRequest property.
	 * 
	 * @param value allowed object is {@link AlienSingleDepInfoByIqamaRequest }
	 * 
	 */
	public void setAlienSingleDepInfoByIqamaRequest(AlienSingleDepInfoByIqamaRequest value) {
		this.alienSingleDepInfoByIqamaRequest = value;
	}

}
