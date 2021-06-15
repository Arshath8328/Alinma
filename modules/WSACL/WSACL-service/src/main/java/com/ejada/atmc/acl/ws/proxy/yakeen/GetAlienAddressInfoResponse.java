
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienAddressInfoResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienAddressInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienAddressInfoResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienAddressInfoResult" minOccurs="0"/>
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
		name = "getAlienAddressInfoResponse",
		propOrder = { "alienAddressInfoResult" }
)
public class GetAlienAddressInfoResponse {

	@XmlElement(
			name = "AlienAddressInfoResult"
	)
	protected AlienAddressInfoResult alienAddressInfoResult;

	/**
	 * Gets the value of the alienAddressInfoResult property.
	 * 
	 * @return possible object is {@link AlienAddressInfoResult }
	 * 
	 */
	public AlienAddressInfoResult getAlienAddressInfoResult() {
		return alienAddressInfoResult;
	}

	/**
	 * Sets the value of the alienAddressInfoResult property.
	 * 
	 * @param value allowed object is {@link AlienAddressInfoResult }
	 * 
	 */
	public void setAlienAddressInfoResult(AlienAddressInfoResult value) {
		this.alienAddressInfoResult = value;
	}

}
