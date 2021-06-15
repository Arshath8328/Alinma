
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCitizenCarInfoBySequenceResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCitizenCarInfoBySequenceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CitizenCarInfoBySequenceResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}citizenCarInfoBySequenceResult" minOccurs="0"/>
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
		name = "getCitizenCarInfoBySequenceResponse",
		propOrder = { "citizenCarInfoBySequenceResult" }
)
public class GetCitizenCarInfoBySequenceResponse {

	@XmlElement(
			name = "CitizenCarInfoBySequenceResult"
	)
	protected CitizenCarInfoBySequenceResult citizenCarInfoBySequenceResult;

	/**
	 * Gets the value of the citizenCarInfoBySequenceResult property.
	 * 
	 * @return possible object is {@link CitizenCarInfoBySequenceResult }
	 * 
	 */
	public CitizenCarInfoBySequenceResult getCitizenCarInfoBySequenceResult() {
		return citizenCarInfoBySequenceResult;
	}

	/**
	 * Sets the value of the citizenCarInfoBySequenceResult property.
	 * 
	 * @param value allowed object is {@link CitizenCarInfoBySequenceResult }
	 * 
	 */
	public void setCitizenCarInfoBySequenceResult(CitizenCarInfoBySequenceResult value) {
		this.citizenCarInfoBySequenceResult = value;
	}

}
