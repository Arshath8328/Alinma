
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCompanyAddressInfoByCrResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompanyAddressInfoByCrResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyAddressInfoByCrResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}companyAddressInfoByCrResult" minOccurs="0"/>
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
		name = "getCompanyAddressInfoByCrResponse",
		propOrder = { "companyAddressInfoByCrResult" }
)
public class GetCompanyAddressInfoByCrResponse {

	@XmlElement(
			name = "CompanyAddressInfoByCrResult"
	)
	protected CompanyAddressInfoByCrResult companyAddressInfoByCrResult;

	/**
	 * Gets the value of the companyAddressInfoByCrResult property.
	 * 
	 * @return possible object is {@link CompanyAddressInfoByCrResult }
	 * 
	 */
	public CompanyAddressInfoByCrResult getCompanyAddressInfoByCrResult() {
		return companyAddressInfoByCrResult;
	}

	/**
	 * Sets the value of the companyAddressInfoByCrResult property.
	 * 
	 * @param value allowed object is {@link CompanyAddressInfoByCrResult }
	 * 
	 */
	public void setCompanyAddressInfoByCrResult(CompanyAddressInfoByCrResult value) {
		this.companyAddressInfoByCrResult = value;
	}

}
