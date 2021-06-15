
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCitizenCarInfoBySequence complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCitizenCarInfoBySequence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CitizenCarInfoBySequenceRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}citizenCarInfoBySequenceRequest" minOccurs="0"/>
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
		name = "getCitizenCarInfoBySequence",
		propOrder = { "citizenCarInfoBySequenceRequest" }
)
public class GetCitizenCarInfoBySequence {

	@XmlElement(
			name = "CitizenCarInfoBySequenceRequest"
	)
	protected CitizenCarInfoBySequenceRequest citizenCarInfoBySequenceRequest;

	/**
	 * Gets the value of the citizenCarInfoBySequenceRequest property.
	 * 
	 * @return possible object is {@link CitizenCarInfoBySequenceRequest }
	 * 
	 */
	public CitizenCarInfoBySequenceRequest getCitizenCarInfoBySequenceRequest() {
		return citizenCarInfoBySequenceRequest;
	}

	/**
	 * Sets the value of the citizenCarInfoBySequenceRequest property.
	 * 
	 * @param value allowed object is {@link CitizenCarInfoBySequenceRequest }
	 * 
	 */
	public void setCitizenCarInfoBySequenceRequest(CitizenCarInfoBySequenceRequest value) {
		this.citizenCarInfoBySequenceRequest = value;
	}

}
