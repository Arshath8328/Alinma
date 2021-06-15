
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCompanyCarInfoBySequence complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompanyCarInfoBySequence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyCarInfoBySequenceRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}companyCarInfoBySequenceRequest" minOccurs="0"/>
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
		name = "getCompanyCarInfoBySequence",
		propOrder = { "companyCarInfoBySequenceRequest" }
)
public class GetCompanyCarInfoBySequence {

	@XmlElement(
			name = "CompanyCarInfoBySequenceRequest"
	)
	protected CompanyCarInfoBySequenceRequest companyCarInfoBySequenceRequest;

	/**
	 * Gets the value of the companyCarInfoBySequenceRequest property.
	 * 
	 * @return possible object is {@link CompanyCarInfoBySequenceRequest }
	 * 
	 */
	public CompanyCarInfoBySequenceRequest getCompanyCarInfoBySequenceRequest() {
		return companyCarInfoBySequenceRequest;
	}

	/**
	 * Sets the value of the companyCarInfoBySequenceRequest property.
	 * 
	 * @param value allowed object is {@link CompanyCarInfoBySequenceRequest }
	 * 
	 */
	public void setCompanyCarInfoBySequenceRequest(CompanyCarInfoBySequenceRequest value) {
		this.companyCarInfoBySequenceRequest = value;
	}

}
