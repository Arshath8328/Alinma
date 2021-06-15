
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getCompanyInfoBySponseredIqama complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompanyInfoBySponseredIqama">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyInfoBySponseredIqamaRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}companyInfoBySponseredIqamaRequest" minOccurs="0"/>
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
		name = "getCompanyInfoBySponseredIqama",
		propOrder = { "companyInfoBySponseredIqamaRequest" }
)
public class GetCompanyInfoBySponseredIqama {

	@XmlElement(
			name = "CompanyInfoBySponseredIqamaRequest"
	)
	protected CompanyInfoBySponseredIqamaRequest companyInfoBySponseredIqamaRequest;

	/**
	 * Gets the value of the companyInfoBySponseredIqamaRequest property.
	 * 
	 * @return possible object is {@link CompanyInfoBySponseredIqamaRequest }
	 * 
	 */
	public CompanyInfoBySponseredIqamaRequest getCompanyInfoBySponseredIqamaRequest() {
		return companyInfoBySponseredIqamaRequest;
	}

	/**
	 * Sets the value of the companyInfoBySponseredIqamaRequest property.
	 * 
	 * @param value allowed object is {@link CompanyInfoBySponseredIqamaRequest }
	 * 
	 */
	public void setCompanyInfoBySponseredIqamaRequest(CompanyInfoBySponseredIqamaRequest value) {
		this.companyInfoBySponseredIqamaRequest = value;
	}

}
