
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienAllDepInfoByIqama complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienAllDepInfoByIqama">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienAllDepInfoByIqamaRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienAllDepInfoByIqamaRequest" minOccurs="0"/>
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
		name = "getAlienAllDepInfoByIqama",
		propOrder = { "alienAllDepInfoByIqamaRequest" }
)
public class GetAlienAllDepInfoByIqama {

	@XmlElement(
			name = "AlienAllDepInfoByIqamaRequest"
	)
	protected AlienAllDepInfoByIqamaRequest alienAllDepInfoByIqamaRequest;

	/**
	 * Gets the value of the alienAllDepInfoByIqamaRequest property.
	 * 
	 * @return possible object is {@link AlienAllDepInfoByIqamaRequest }
	 * 
	 */
	public AlienAllDepInfoByIqamaRequest getAlienAllDepInfoByIqamaRequest() {
		return alienAllDepInfoByIqamaRequest;
	}

	/**
	 * Sets the value of the alienAllDepInfoByIqamaRequest property.
	 * 
	 * @param value allowed object is {@link AlienAllDepInfoByIqamaRequest }
	 * 
	 */
	public void setAlienAllDepInfoByIqamaRequest(AlienAllDepInfoByIqamaRequest value) {
		this.alienAllDepInfoByIqamaRequest = value;
	}

}
