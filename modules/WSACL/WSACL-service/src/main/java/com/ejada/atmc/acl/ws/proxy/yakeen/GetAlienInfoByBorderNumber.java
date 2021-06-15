
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienInfoByBorderNumber complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienInfoByBorderNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienInfoByBorderNumberRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienInfoByBorderNumberRequest" minOccurs="0"/>
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
		name = "getAlienInfoByBorderNumber",
		propOrder = { "alienInfoByBorderNumberRequest" }
)
public class GetAlienInfoByBorderNumber {

	@XmlElement(
			name = "AlienInfoByBorderNumberRequest"
	)
	protected AlienInfoByBorderNumberRequest alienInfoByBorderNumberRequest;

	/**
	 * Gets the value of the alienInfoByBorderNumberRequest property.
	 * 
	 * @return possible object is {@link AlienInfoByBorderNumberRequest }
	 * 
	 */
	public AlienInfoByBorderNumberRequest getAlienInfoByBorderNumberRequest() {
		return alienInfoByBorderNumberRequest;
	}

	/**
	 * Sets the value of the alienInfoByBorderNumberRequest property.
	 * 
	 * @param value allowed object is {@link AlienInfoByBorderNumberRequest }
	 * 
	 */
	public void setAlienInfoByBorderNumberRequest(AlienInfoByBorderNumberRequest value) {
		this.alienInfoByBorderNumberRequest = value;
	}

}
