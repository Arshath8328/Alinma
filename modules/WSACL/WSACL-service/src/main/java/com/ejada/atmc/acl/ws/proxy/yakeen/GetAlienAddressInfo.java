
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienAddressInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienAddressInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienAddressInfoRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienAddressInfoRequest" minOccurs="0"/>
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
		name = "getAlienAddressInfo",
		propOrder = { "alienAddressInfoRequest" }
)
public class GetAlienAddressInfo {

	@XmlElement(
			name = "AlienAddressInfoRequest"
	)
	protected AlienAddressInfoRequest alienAddressInfoRequest;

	/**
	 * Gets the value of the alienAddressInfoRequest property.
	 * 
	 * @return possible object is {@link AlienAddressInfoRequest }
	 * 
	 */
	public AlienAddressInfoRequest getAlienAddressInfoRequest() {
		return alienAddressInfoRequest;
	}

	/**
	 * Sets the value of the alienAddressInfoRequest property.
	 * 
	 * @param value allowed object is {@link AlienAddressInfoRequest }
	 * 
	 */
	public void setAlienAddressInfoRequest(AlienAddressInfoRequest value) {
		this.alienAddressInfoRequest = value;
	}

}
