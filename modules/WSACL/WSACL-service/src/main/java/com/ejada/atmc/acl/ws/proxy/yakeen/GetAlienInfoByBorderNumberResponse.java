
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getAlienInfoByBorderNumberResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienInfoByBorderNumberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienInfoByBorderNumberResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienInfoByBorderNumberResult" minOccurs="0"/>
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
		name = "getAlienInfoByBorderNumberResponse",
		propOrder = { "alienInfoByBorderNumberResult" }
)
public class GetAlienInfoByBorderNumberResponse {

	@XmlElement(
			name = "AlienInfoByBorderNumberResult"
	)
	protected AlienInfoByBorderNumberResult alienInfoByBorderNumberResult;

	/**
	 * Gets the value of the alienInfoByBorderNumberResult property.
	 * 
	 * @return possible object is {@link AlienInfoByBorderNumberResult }
	 * 
	 */
	public AlienInfoByBorderNumberResult getAlienInfoByBorderNumberResult() {
		return alienInfoByBorderNumberResult;
	}

	/**
	 * Sets the value of the alienInfoByBorderNumberResult property.
	 * 
	 * @param value allowed object is {@link AlienInfoByBorderNumberResult }
	 * 
	 */
	public void setAlienInfoByBorderNumberResult(AlienInfoByBorderNumberResult value) {
		this.alienInfoByBorderNumberResult = value;
	}

}
