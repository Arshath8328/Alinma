
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienLegalStatusInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienLegalStatusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienLegalStatusInfoRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienLegalStatusInfoRequest" minOccurs="0"/>
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
		name = "getAlienLegalStatusInfo",
		propOrder = { "alienLegalStatusInfoRequest" }
)
public class GetAlienLegalStatusInfo {

	@XmlElement(
			name = "AlienLegalStatusInfoRequest"
	)
	protected AlienLegalStatusInfoRequest alienLegalStatusInfoRequest;

	/**
	 * Gets the value of the alienLegalStatusInfoRequest property.
	 * 
	 * @return possible object is {@link AlienLegalStatusInfoRequest }
	 * 
	 */
	public AlienLegalStatusInfoRequest getAlienLegalStatusInfoRequest() {
		return alienLegalStatusInfoRequest;
	}

	/**
	 * Sets the value of the alienLegalStatusInfoRequest property.
	 * 
	 * @param value allowed object is {@link AlienLegalStatusInfoRequest }
	 * 
	 */
	public void setAlienLegalStatusInfoRequest(AlienLegalStatusInfoRequest value) {
		this.alienLegalStatusInfoRequest = value;
	}

}
