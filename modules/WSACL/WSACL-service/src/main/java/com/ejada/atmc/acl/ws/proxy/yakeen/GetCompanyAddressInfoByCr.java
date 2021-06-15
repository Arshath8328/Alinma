
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCompanyAddressInfoByCr complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompanyAddressInfoByCr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyAddressInfoByCrRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}companyAddressInfoByCrRequest" minOccurs="0"/>
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
		name = "getCompanyAddressInfoByCr",
		propOrder = { "companyAddressInfoByCrRequest" }
)
public class GetCompanyAddressInfoByCr {

	@XmlElement(
			name = "CompanyAddressInfoByCrRequest"
	)
	protected CompanyAddressInfoByCrRequest companyAddressInfoByCrRequest;

	/**
	 * Gets the value of the companyAddressInfoByCrRequest property.
	 * 
	 * @return possible object is {@link CompanyAddressInfoByCrRequest }
	 * 
	 */
	public CompanyAddressInfoByCrRequest getCompanyAddressInfoByCrRequest() {
		return companyAddressInfoByCrRequest;
	}

	/**
	 * Sets the value of the companyAddressInfoByCrRequest property.
	 * 
	 * @param value allowed object is {@link CompanyAddressInfoByCrRequest }
	 * 
	 */
	public void setCompanyAddressInfoByCrRequest(CompanyAddressInfoByCrRequest value) {
		this.companyAddressInfoByCrRequest = value;
	}

}
