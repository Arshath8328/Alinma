
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienInfoByIqama complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienInfoByIqama">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienInfoByIqamaRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienInfoByIqamaRequest" minOccurs="0"/>
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
		name = "getAlienInfoByIqama",
		propOrder = { "alienInfoByIqamaRequest" }
)
public class GetAlienInfoByIqama {

	@XmlElement(
			name = "AlienInfoByIqamaRequest"
	)
	protected AlienInfoByIqamaRequest alienInfoByIqamaRequest;

	/**
	 * Gets the value of the alienInfoByIqamaRequest property.
	 * 
	 * @return possible object is {@link AlienInfoByIqamaRequest }
	 * 
	 */
	public AlienInfoByIqamaRequest getAlienInfoByIqamaRequest() {
		return alienInfoByIqamaRequest;
	}

	/**
	 * Sets the value of the alienInfoByIqamaRequest property.
	 * 
	 * @param value allowed object is {@link AlienInfoByIqamaRequest }
	 * 
	 */
	public void setAlienInfoByIqamaRequest(AlienInfoByIqamaRequest value) {
		this.alienInfoByIqamaRequest = value;
	}

}
