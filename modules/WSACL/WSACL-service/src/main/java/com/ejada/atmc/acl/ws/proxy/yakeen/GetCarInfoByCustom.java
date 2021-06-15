
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCarInfoByCustom complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCarInfoByCustom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarInfoByCustomRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}carInfoByCustomRequest" minOccurs="0"/>
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
		name = "getCarInfoByCustom",
		propOrder = { "carInfoByCustomRequest" }
)
public class GetCarInfoByCustom {

	@XmlElement(
			name = "CarInfoByCustomRequest"
	)
	protected CarInfoByCustomRequest carInfoByCustomRequest;

	/**
	 * Gets the value of the carInfoByCustomRequest property.
	 * 
	 * @return possible object is {@link CarInfoByCustomRequest }
	 * 
	 */
	public CarInfoByCustomRequest getCarInfoByCustomRequest() {
		return carInfoByCustomRequest;
	}

	/**
	 * Sets the value of the carInfoByCustomRequest property.
	 * 
	 * @param value allowed object is {@link CarInfoByCustomRequest }
	 * 
	 */
	public void setCarInfoByCustomRequest(CarInfoByCustomRequest value) {
		this.carInfoByCustomRequest = value;
	}

}
