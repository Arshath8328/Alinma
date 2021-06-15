
package com.ejada.atmc.acl.ws.proxy.ods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmlRequest" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="POLICY_ISSUANCE">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="POLICY">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PRODUCT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="POLICY_EFF_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PAYMENT_METHOD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PAYMENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                       &lt;element name="PAYMENT_REF_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="INSURED">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="INSURED_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="INSURED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                       &lt;element name="INSURED_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_MIDDLE_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ADDRESS_BLDG_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ADDRESS_UNIT_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ADDRESS_STREET" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ADDRESS_DISTRICT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ADDRESS_CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ADDRESS_ZIPCODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ADDRESS_ADD_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="INSURED_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_EMAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="INSURED_OCCUP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="VEHICLE">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="VEHICLE_INFO" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="VEHICLE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                                 &lt;element name="VEHICLE_PLATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="VEHICLE_PLATE_L1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_PLATE_L2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_PLATE_L3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="PURPOSE_OF_VEHICLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_MAKE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_MODEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_MFG_YEAR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="VEHICLE_COLOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_BODY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_CHASSIS_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_EST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="DEDUCTIBLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                                 &lt;element name="AGENCY_REPAIR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="VEHICLE_CAPACITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="VEHICLE_CYLINDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="VEHICLE_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="NCD_YEARS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="LOYALTY_DISCOUNT_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="NET_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="NCD_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="LOYALTY_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="NCD_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="LOYALTY_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="LOADING_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="POLICY_TAXES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="POLICY_FEES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="TOTAL_COVER_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="GROSS_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="ADD_DRIVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="ADD_COVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="EXIST_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="EXIST_COMP_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="EXIST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="ADD_DRIVER" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="DRIVER_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                           &lt;element name="DRIVER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                                           &lt;element name="DRIVER_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="DRIVER_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="DRIVER_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="DRIVER_NCD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="COVER" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="COVER_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="COVER_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                           &lt;element name="COVER_SI" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                                           &lt;element name="COVER_PREM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                           &lt;element name="COVER_EFF_FRM_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="COVER_EFF_TO_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
		name = "",
		propOrder = { "xmlRequest" }
)
@XmlRootElement(
		name = "PolicyIssuance"
)
public class PolicyIssuance {

	protected PolicyIssuance.XmlRequest xmlRequest;

	/**
	 * Gets the value of the xmlRequest property.
	 * 
	 * @return possible object is {@link PolicyIssuance.XmlRequest }
	 * 
	 */
	public PolicyIssuance.XmlRequest getXmlRequest() {
		return xmlRequest;
	}

	/**
	 * Sets the value of the xmlRequest property.
	 * 
	 * @param value allowed object is {@link PolicyIssuance.XmlRequest }
	 * 
	 */
	public void setXmlRequest(PolicyIssuance.XmlRequest value) {
		this.xmlRequest = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="POLICY_ISSUANCE">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="POLICY">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;sequence>
	 *                             &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="PRODUCT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="POLICY_EFF_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="PAYMENT_METHOD" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="PAYMENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                             &lt;element name="PAYMENT_REF_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                   &lt;element name="INSURED">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;sequence>
	 *                             &lt;element name="INSURED_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                             &lt;element name="INSURED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
	 *                             &lt;element name="INSURED_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_MIDDLE_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="ADDRESS_BLDG_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                             &lt;element name="ADDRESS_UNIT_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                             &lt;element name="ADDRESS_STREET" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="ADDRESS_DISTRICT" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="ADDRESS_CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="ADDRESS_ZIPCODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                             &lt;element name="ADDRESS_ADD_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                             &lt;element name="INSURED_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_EMAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                             &lt;element name="INSURED_OCCUP" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                   &lt;element name="VEHICLE">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;sequence>
	 *                             &lt;element name="VEHICLE_INFO" maxOccurs="unbounded">
	 *                               &lt;complexType>
	 *                                 &lt;complexContent>
	 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                     &lt;sequence>
	 *                                       &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="VEHICLE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
	 *                                       &lt;element name="VEHICLE_PLATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="VEHICLE_PLATE_L1" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_PLATE_L2" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_PLATE_L3" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="PURPOSE_OF_VEHICLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_MAKE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_MODEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_MFG_YEAR" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="VEHICLE_COLOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_BODY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_CHASSIS_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_EST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="DEDUCTIBLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}long"/>
	 *                                       &lt;element name="AGENCY_REPAIR" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="VEHICLE_CAPACITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="VEHICLE_CYLINDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="VEHICLE_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="NCD_YEARS" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="LOYALTY_DISCOUNT_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="NET_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="NCD_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="LOYALTY_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="NCD_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="LOYALTY_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="LOADING_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="POLICY_TAXES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="POLICY_FEES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="TOTAL_COVER_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="GROSS_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                       &lt;element name="ADD_DRIVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="ADD_COVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                       &lt;element name="EXIST_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="EXIST_COMP_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="EXIST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                       &lt;element name="ADD_DRIVER" maxOccurs="unbounded" minOccurs="0">
	 *                                         &lt;complexType>
	 *                                           &lt;complexContent>
	 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                               &lt;sequence>
	 *                                                 &lt;element name="DRIVER_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                                 &lt;element name="DRIVER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
	 *                                                 &lt;element name="DRIVER_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                                 &lt;element name="DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                                 &lt;element name="DRIVER_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                                 &lt;element name="DRIVER_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                                 &lt;element name="DRIVER_NCD" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *                                               &lt;/sequence>
	 *                                             &lt;/restriction>
	 *                                           &lt;/complexContent>
	 *                                         &lt;/complexType>
	 *                                       &lt;/element>
	 *                                       &lt;element name="COVER" maxOccurs="unbounded" minOccurs="0">
	 *                                         &lt;complexType>
	 *                                           &lt;complexContent>
	 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                               &lt;sequence>
	 *                                                 &lt;element name="COVER_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                                 &lt;element name="COVER_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                                 &lt;element name="COVER_SI" type="{http://www.w3.org/2001/XMLSchema}long"/>
	 *                                                 &lt;element name="COVER_PREM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
	 *                                                 &lt;element name="COVER_EFF_FRM_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                                 &lt;element name="COVER_EFF_TO_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                                               &lt;/sequence>
	 *                                             &lt;/restriction>
	 *                                           &lt;/complexContent>
	 *                                         &lt;/complexType>
	 *                                       &lt;/element>
	 *                                     &lt;/sequence>
	 *                                   &lt;/restriction>
	 *                                 &lt;/complexContent>
	 *                               &lt;/complexType>
	 *                             &lt;/element>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
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
			name = "",
			propOrder = { "policyissuance" }
	)
	public static class XmlRequest {

		@XmlElement(
				name = "POLICY_ISSUANCE",
				required = true
		)
		protected PolicyIssuance.XmlRequest.POLICYISSUANCE policyissuance;

		/**
		 * Gets the value of the policyissuance property.
		 * 
		 * @return possible object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE }
		 * 
		 */
		public PolicyIssuance.XmlRequest.POLICYISSUANCE getPOLICYISSUANCE() {
			return policyissuance;
		}

		/**
		 * Sets the value of the policyissuance property.
		 * 
		 * @param value allowed object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE }
		 * 
		 */
		public void setPOLICYISSUANCE(PolicyIssuance.XmlRequest.POLICYISSUANCE value) {
			this.policyissuance = value;
		}

		/**
		 * <p>
		 * Java class for anonymous complex type.
		 * 
		 * <p>
		 * The following schema fragment specifies the expected content contained within this class.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="POLICY">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;sequence>
		 *                   &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="PRODUCT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="POLICY_EFF_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="PAYMENT_METHOD" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="PAYMENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                   &lt;element name="PAYMENT_REF_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
		 *         &lt;element name="INSURED">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;sequence>
		 *                   &lt;element name="INSURED_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                   &lt;element name="INSURED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
		 *                   &lt;element name="INSURED_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_MIDDLE_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="ADDRESS_BLDG_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                   &lt;element name="ADDRESS_UNIT_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                   &lt;element name="ADDRESS_STREET" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="ADDRESS_DISTRICT" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="ADDRESS_CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="ADDRESS_ZIPCODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                   &lt;element name="ADDRESS_ADD_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                   &lt;element name="INSURED_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_EMAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                   &lt;element name="INSURED_OCCUP" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
		 *         &lt;element name="VEHICLE">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;sequence>
		 *                   &lt;element name="VEHICLE_INFO" maxOccurs="unbounded">
		 *                     &lt;complexType>
		 *                       &lt;complexContent>
		 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                           &lt;sequence>
		 *                             &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="VEHICLE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
		 *                             &lt;element name="VEHICLE_PLATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="VEHICLE_PLATE_L1" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_PLATE_L2" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_PLATE_L3" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="PURPOSE_OF_VEHICLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_MAKE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_MODEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_MFG_YEAR" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="VEHICLE_COLOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_BODY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_CHASSIS_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_EST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="DEDUCTIBLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}long"/>
		 *                             &lt;element name="AGENCY_REPAIR" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="VEHICLE_CAPACITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="VEHICLE_CYLINDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="VEHICLE_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="NCD_YEARS" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="LOYALTY_DISCOUNT_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="NET_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="NCD_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="LOYALTY_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="NCD_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="LOYALTY_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="LOADING_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="POLICY_TAXES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="POLICY_FEES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="TOTAL_COVER_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="GROSS_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                             &lt;element name="ADD_DRIVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="ADD_COVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                             &lt;element name="EXIST_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="EXIST_COMP_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="EXIST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                             &lt;element name="ADD_DRIVER" maxOccurs="unbounded" minOccurs="0">
		 *                               &lt;complexType>
		 *                                 &lt;complexContent>
		 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                                     &lt;sequence>
		 *                                       &lt;element name="DRIVER_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                                       &lt;element name="DRIVER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
		 *                                       &lt;element name="DRIVER_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                       &lt;element name="DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                       &lt;element name="DRIVER_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                       &lt;element name="DRIVER_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                       &lt;element name="DRIVER_NCD" type="{http://www.w3.org/2001/XMLSchema}int"/>
		 *                                     &lt;/sequence>
		 *                                   &lt;/restriction>
		 *                                 &lt;/complexContent>
		 *                               &lt;/complexType>
		 *                             &lt;/element>
		 *                             &lt;element name="COVER" maxOccurs="unbounded" minOccurs="0">
		 *                               &lt;complexType>
		 *                                 &lt;complexContent>
		 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                                     &lt;sequence>
		 *                                       &lt;element name="COVER_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                       &lt;element name="COVER_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                                       &lt;element name="COVER_SI" type="{http://www.w3.org/2001/XMLSchema}long"/>
		 *                                       &lt;element name="COVER_PREM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
		 *                                       &lt;element name="COVER_EFF_FRM_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                       &lt;element name="COVER_EFF_TO_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *                                     &lt;/sequence>
		 *                                   &lt;/restriction>
		 *                                 &lt;/complexContent>
		 *                               &lt;/complexType>
		 *                             &lt;/element>
		 *                           &lt;/sequence>
		 *                         &lt;/restriction>
		 *                       &lt;/complexContent>
		 *                     &lt;/complexType>
		 *                   &lt;/element>
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
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
				name = "",
				propOrder = { "policy", "insured", "vehicle" }
		)
		public static class POLICYISSUANCE {

			@XmlElement(
					name = "POLICY",
					required = true
			)
			protected PolicyIssuance.XmlRequest.POLICYISSUANCE.POLICY	policy;
			@XmlElement(
					name = "INSURED",
					required = true
			)
			protected PolicyIssuance.XmlRequest.POLICYISSUANCE.INSURED	insured;
			@XmlElement(
					name = "VEHICLE",
					required = true
			)
			protected PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE	vehicle;

			/**
			 * Gets the value of the policy property.
			 * 
			 * @return possible object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.POLICY }
			 * 
			 */
			public PolicyIssuance.XmlRequest.POLICYISSUANCE.POLICY getPOLICY() {
				return policy;
			}

			/**
			 * Sets the value of the policy property.
			 * 
			 * @param value allowed object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.POLICY }
			 * 
			 */
			public void setPOLICY(PolicyIssuance.XmlRequest.POLICYISSUANCE.POLICY value) {
				this.policy = value;
			}

			/**
			 * Gets the value of the insured property.
			 * 
			 * @return possible object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.INSURED }
			 * 
			 */
			public PolicyIssuance.XmlRequest.POLICYISSUANCE.INSURED getINSURED() {
				return insured;
			}

			/**
			 * Sets the value of the insured property.
			 * 
			 * @param value allowed object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.INSURED }
			 * 
			 */
			public void setINSURED(PolicyIssuance.XmlRequest.POLICYISSUANCE.INSURED value) {
				this.insured = value;
			}

			/**
			 * Gets the value of the vehicle property.
			 * 
			 * @return possible object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE }
			 * 
			 */
			public PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE getVEHICLE() {
				return vehicle;
			}

			/**
			 * Sets the value of the vehicle property.
			 * 
			 * @param value allowed object is {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE }
			 * 
			 */
			public void setVEHICLE(PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE value) {
				this.vehicle = value;
			}

			/**
			 * <p>
			 * Java class for anonymous complex type.
			 * 
			 * <p>
			 * The following schema fragment specifies the expected content contained within this class.
			 * 
			 * <pre>
			 * &lt;complexType>
			 *   &lt;complexContent>
			 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *       &lt;sequence>
			 *         &lt;element name="INSURED_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *         &lt;element name="INSURED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
			 *         &lt;element name="INSURED_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_MIDDLE_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="ADDRESS_BLDG_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *         &lt;element name="ADDRESS_UNIT_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *         &lt;element name="ADDRESS_STREET" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="ADDRESS_DISTRICT" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="ADDRESS_CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="ADDRESS_ZIPCODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *         &lt;element name="ADDRESS_ADD_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *         &lt;element name="INSURED_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_EMAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="INSURED_OCCUP" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
					name = "",
					propOrder = { "insuredidtype", "insuredid", "insureddob", "insuredgender", "insuredfirstname", "insuredmiddlename", "insuredlastname", "insurednationality", "addressbldgno",
							"addressunitno", "addressstreet", "addressdistrict", "addresscity", "addresszipcode", "addressaddnumber", "insuredmobile", "insuredemail", "insurediban", "insuredoccup" }
			)
			public static class INSURED {

				@XmlElement(
						name = "INSURED_ID_TYPE"
				)
				protected int		insuredidtype;
				@XmlElement(
						name = "INSURED_ID"
				)
				protected long		insuredid;
				@XmlElement(
						name = "INSURED_DOB",
						required = true
				)
				protected String	insureddob;
				@XmlElement(
						name = "INSURED_GENDER",
						required = true
				)
				protected String	insuredgender;
				@XmlElement(
						name = "INSURED_FIRST_NAME",
						required = true
				)
				protected String	insuredfirstname;
				@XmlElement(
						name = "INSURED_MIDDLE_NAME",
						required = true
				)
				protected String	insuredmiddlename;
				@XmlElement(
						name = "INSURED_LAST_NAME",
						required = true
				)
				protected String	insuredlastname;
				@XmlElement(
						name = "INSURED_NATIONALITY",
						required = true
				)
				protected String	insurednationality;
				@XmlElement(
						name = "ADDRESS_BLDG_NO"
				)
				protected int		addressbldgno;
				@XmlElement(
						name = "ADDRESS_UNIT_NO"
				)
				protected int		addressunitno;
				@XmlElement(
						name = "ADDRESS_STREET",
						required = true
				)
				protected String	addressstreet;
				@XmlElement(
						name = "ADDRESS_DISTRICT",
						required = true
				)
				protected String	addressdistrict;
				@XmlElement(
						name = "ADDRESS_CITY",
						required = true
				)
				protected String	addresscity;
				@XmlElement(
						name = "ADDRESS_ZIPCODE"
				)
				protected int		addresszipcode;
				@XmlElement(
						name = "ADDRESS_ADD_NUMBER"
				)
				protected int		addressaddnumber;
				@XmlElement(
						name = "INSURED_MOBILE",
						required = true
				)
				protected String	insuredmobile;
				@XmlElement(
						name = "INSURED_EMAIL",
						required = true
				)
				protected String	insuredemail;
				@XmlElement(
						name = "INSURED_IBAN",
						required = true
				)
				protected String	insurediban;
				@XmlElement(
						name = "INSURED_OCCUP",
						required = true
				)
				protected String	insuredoccup;

				/**
				 * Gets the value of the insuredidtype property.
				 * 
				 */
				public int getINSUREDIDTYPE() {
					return insuredidtype;
				}

				/**
				 * Sets the value of the insuredidtype property.
				 * 
				 */
				public void setINSUREDIDTYPE(int value) {
					this.insuredidtype = value;
				}

				/**
				 * Gets the value of the insuredid property.
				 * 
				 */
				public long getINSUREDID() {
					return insuredid;
				}

				/**
				 * Sets the value of the insuredid property.
				 * 
				 */
				public void setINSUREDID(long value) {
					this.insuredid = value;
				}

				/**
				 * Gets the value of the insureddob property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDDOB() {
					return insureddob;
				}

				/**
				 * Sets the value of the insureddob property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDDOB(String value) {
					this.insureddob = value;
				}

				/**
				 * Gets the value of the insuredgender property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDGENDER() {
					return insuredgender;
				}

				/**
				 * Sets the value of the insuredgender property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDGENDER(String value) {
					this.insuredgender = value;
				}

				/**
				 * Gets the value of the insuredfirstname property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDFIRSTNAME() {
					return insuredfirstname;
				}

				/**
				 * Sets the value of the insuredfirstname property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDFIRSTNAME(String value) {
					this.insuredfirstname = value;
				}

				/**
				 * Gets the value of the insuredmiddlename property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDMIDDLENAME() {
					return insuredmiddlename;
				}

				/**
				 * Sets the value of the insuredmiddlename property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDMIDDLENAME(String value) {
					this.insuredmiddlename = value;
				}

				/**
				 * Gets the value of the insuredlastname property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDLASTNAME() {
					return insuredlastname;
				}

				/**
				 * Sets the value of the insuredlastname property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDLASTNAME(String value) {
					this.insuredlastname = value;
				}

				/**
				 * Gets the value of the insurednationality property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDNATIONALITY() {
					return insurednationality;
				}

				/**
				 * Sets the value of the insurednationality property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDNATIONALITY(String value) {
					this.insurednationality = value;
				}

				/**
				 * Gets the value of the addressbldgno property.
				 * 
				 */
				public int getADDRESSBLDGNO() {
					return addressbldgno;
				}

				/**
				 * Sets the value of the addressbldgno property.
				 * 
				 */
				public void setADDRESSBLDGNO(int value) {
					this.addressbldgno = value;
				}

				/**
				 * Gets the value of the addressunitno property.
				 * 
				 */
				public int getADDRESSUNITNO() {
					return addressunitno;
				}

				/**
				 * Sets the value of the addressunitno property.
				 * 
				 */
				public void setADDRESSUNITNO(int value) {
					this.addressunitno = value;
				}

				/**
				 * Gets the value of the addressstreet property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getADDRESSSTREET() {
					return addressstreet;
				}

				/**
				 * Sets the value of the addressstreet property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setADDRESSSTREET(String value) {
					this.addressstreet = value;
				}

				/**
				 * Gets the value of the addressdistrict property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getADDRESSDISTRICT() {
					return addressdistrict;
				}

				/**
				 * Sets the value of the addressdistrict property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setADDRESSDISTRICT(String value) {
					this.addressdistrict = value;
				}

				/**
				 * Gets the value of the addresscity property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getADDRESSCITY() {
					return addresscity;
				}

				/**
				 * Sets the value of the addresscity property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setADDRESSCITY(String value) {
					this.addresscity = value;
				}

				/**
				 * Gets the value of the addresszipcode property.
				 * 
				 */
				public int getADDRESSZIPCODE() {
					return addresszipcode;
				}

				/**
				 * Sets the value of the addresszipcode property.
				 * 
				 */
				public void setADDRESSZIPCODE(int value) {
					this.addresszipcode = value;
				}

				/**
				 * Gets the value of the addressaddnumber property.
				 * 
				 */
				public int getADDRESSADDNUMBER() {
					return addressaddnumber;
				}

				/**
				 * Sets the value of the addressaddnumber property.
				 * 
				 */
				public void setADDRESSADDNUMBER(int value) {
					this.addressaddnumber = value;
				}

				/**
				 * Gets the value of the insuredmobile property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDMOBILE() {
					return insuredmobile;
				}

				/**
				 * Sets the value of the insuredmobile property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDMOBILE(String value) {
					this.insuredmobile = value;
				}

				/**
				 * Gets the value of the insuredemail property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDEMAIL() {
					return insuredemail;
				}

				/**
				 * Sets the value of the insuredemail property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDEMAIL(String value) {
					this.insuredemail = value;
				}

				/**
				 * Gets the value of the insurediban property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDIBAN() {
					return insurediban;
				}

				/**
				 * Sets the value of the insurediban property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDIBAN(String value) {
					this.insurediban = value;
				}

				/**
				 * Gets the value of the insuredoccup property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getINSUREDOCCUP() {
					return insuredoccup;
				}

				/**
				 * Sets the value of the insuredoccup property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setINSUREDOCCUP(String value) {
					this.insuredoccup = value;
				}

			}

			/**
			 * <p>
			 * Java class for anonymous complex type.
			 * 
			 * <p>
			 * The following schema fragment specifies the expected content contained within this class.
			 * 
			 * <pre>
			 * &lt;complexType>
			 *   &lt;complexContent>
			 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *       &lt;sequence>
			 *         &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="PRODUCT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="POLICY_EFF_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="PAYMENT_METHOD" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *         &lt;element name="PAYMENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *         &lt;element name="PAYMENT_REF_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
					name = "",
					propOrder = { "referenceno", "source", "transaction", "productcode", "policyeffdate", "paymentmethod", "paymentamount", "paymentrefno" }
			)
			public static class POLICY {

				@XmlElement(
						name = "REFERENCE_NO",
						required = true
				)
				protected String		referenceno;
				@XmlElement(
						name = "SOURCE",
						required = true
				)
				protected String		source;
				@XmlElement(
						name = "TRANSACTION",
						required = true
				)
				protected String		transaction;
				@XmlElement(
						name = "PRODUCT_CODE",
						required = true
				)
				protected String		productcode;
				@XmlElement(
						name = "POLICY_EFF_DATE",
						required = true
				)
				protected String		policyeffdate;
				@XmlElement(
						name = "PAYMENT_METHOD",
						required = true
				)
				protected String		paymentmethod;
				@XmlElement(
						name = "PAYMENT_AMOUNT",
						required = true
				)
				protected BigDecimal	paymentamount;
				@XmlElement(
						name = "PAYMENT_REF_NO",
						required = true
				)
				protected String		paymentrefno;

				/**
				 * Gets the value of the referenceno property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getREFERENCENO() {
					return referenceno;
				}

				/**
				 * Sets the value of the referenceno property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setREFERENCENO(String value) {
					this.referenceno = value;
				}

				/**
				 * Gets the value of the source property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getSOURCE() {
					return source;
				}

				/**
				 * Sets the value of the source property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setSOURCE(String value) {
					this.source = value;
				}

				/**
				 * Gets the value of the transaction property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getTRANSACTION() {
					return transaction;
				}

				/**
				 * Sets the value of the transaction property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setTRANSACTION(String value) {
					this.transaction = value;
				}

				/**
				 * Gets the value of the productcode property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getPRODUCTCODE() {
					return productcode;
				}

				/**
				 * Sets the value of the productcode property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setPRODUCTCODE(String value) {
					this.productcode = value;
				}

				/**
				 * Gets the value of the policyeffdate property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getPOLICYEFFDATE() {
					return policyeffdate;
				}

				/**
				 * Sets the value of the policyeffdate property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setPOLICYEFFDATE(String value) {
					this.policyeffdate = value;
				}

				/**
				 * Gets the value of the paymentmethod property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getPAYMENTMETHOD() {
					return paymentmethod;
				}

				/**
				 * Sets the value of the paymentmethod property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setPAYMENTMETHOD(String value) {
					this.paymentmethod = value;
				}

				/**
				 * Gets the value of the paymentamount property.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getPAYMENTAMOUNT() {
					return paymentamount;
				}

				/**
				 * Sets the value of the paymentamount property.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setPAYMENTAMOUNT(BigDecimal value) {
					this.paymentamount = value;
				}

				/**
				 * Gets the value of the paymentrefno property.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getPAYMENTREFNO() {
					return paymentrefno;
				}

				/**
				 * Sets the value of the paymentrefno property.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setPAYMENTREFNO(String value) {
					this.paymentrefno = value;
				}

			}

			/**
			 * <p>
			 * Java class for anonymous complex type.
			 * 
			 * <p>
			 * The following schema fragment specifies the expected content contained within this class.
			 * 
			 * <pre>
			 * &lt;complexType>
			 *   &lt;complexContent>
			 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *       &lt;sequence>
			 *         &lt;element name="VEHICLE_INFO" maxOccurs="unbounded">
			 *           &lt;complexType>
			 *             &lt;complexContent>
			 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                 &lt;sequence>
			 *                   &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="VEHICLE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
			 *                   &lt;element name="VEHICLE_PLATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="VEHICLE_PLATE_L1" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_PLATE_L2" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_PLATE_L3" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="PURPOSE_OF_VEHICLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_MAKE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_MODEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_MFG_YEAR" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="VEHICLE_COLOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_BODY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_CHASSIS_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_EST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="DEDUCTIBLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}long"/>
			 *                   &lt;element name="AGENCY_REPAIR" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="VEHICLE_CAPACITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="VEHICLE_CYLINDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="VEHICLE_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="NCD_YEARS" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="LOYALTY_DISCOUNT_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="NET_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="NCD_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="LOYALTY_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="NCD_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="LOYALTY_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="LOADING_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="POLICY_TAXES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="POLICY_FEES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="TOTAL_COVER_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="GROSS_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                   &lt;element name="ADD_DRIVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="ADD_COVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                   &lt;element name="EXIST_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="EXIST_COMP_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="EXIST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                   &lt;element name="ADD_DRIVER" maxOccurs="unbounded" minOccurs="0">
			 *                     &lt;complexType>
			 *                       &lt;complexContent>
			 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                           &lt;sequence>
			 *                             &lt;element name="DRIVER_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                             &lt;element name="DRIVER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
			 *                             &lt;element name="DRIVER_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                             &lt;element name="DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                             &lt;element name="DRIVER_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                             &lt;element name="DRIVER_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                             &lt;element name="DRIVER_NCD" type="{http://www.w3.org/2001/XMLSchema}int"/>
			 *                           &lt;/sequence>
			 *                         &lt;/restriction>
			 *                       &lt;/complexContent>
			 *                     &lt;/complexType>
			 *                   &lt;/element>
			 *                   &lt;element name="COVER" maxOccurs="unbounded" minOccurs="0">
			 *                     &lt;complexType>
			 *                       &lt;complexContent>
			 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                           &lt;sequence>
			 *                             &lt;element name="COVER_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                             &lt;element name="COVER_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                             &lt;element name="COVER_SI" type="{http://www.w3.org/2001/XMLSchema}long"/>
			 *                             &lt;element name="COVER_PREM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
			 *                             &lt;element name="COVER_EFF_FRM_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                             &lt;element name="COVER_EFF_TO_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
			 *                           &lt;/sequence>
			 *                         &lt;/restriction>
			 *                       &lt;/complexContent>
			 *                     &lt;/complexType>
			 *                   &lt;/element>
			 *                 &lt;/sequence>
			 *               &lt;/restriction>
			 *             &lt;/complexContent>
			 *           &lt;/complexType>
			 *         &lt;/element>
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
					name = "",
					propOrder = { "vehicleinfo" }
			)
			public static class VEHICLE {

				@XmlElement(
						name = "VEHICLE_INFO",
						required = true
				)
				protected List<PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO> vehicleinfo;

				/**
				 * Gets the value of the vehicleinfo property.
				 * 
				 * <p>
				 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
				 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
				 * vehicleinfo property.
				 * 
				 * <p>
				 * For example, to add a new item, do as follows:
				 * 
				 * <pre>
				 * getVEHICLEINFO().add(newItem);
				 * </pre>
				 * 
				 * 
				 * <p>
				 * Objects of the following type(s) are allowed in the list
				 * {@link PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO }
				 * 
				 * 
				 */
				public List<PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO> getVEHICLEINFO() {
					if (vehicleinfo == null) {
						vehicleinfo = new ArrayList<PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO>();
					}
					return this.vehicleinfo;
				}

				/**
				 * <p>
				 * Java class for anonymous complex type.
				 * 
				 * <p>
				 * The following schema fragment specifies the expected content contained within this class.
				 * 
				 * <pre>
				 * &lt;complexType>
				 *   &lt;complexContent>
				 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
				 *       &lt;sequence>
				 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="VEHICLE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
				 *         &lt;element name="VEHICLE_PLATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="VEHICLE_PLATE_L1" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_PLATE_L2" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_PLATE_L3" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="PURPOSE_OF_VEHICLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_MAKE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_MODEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_MFG_YEAR" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="VEHICLE_COLOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_BODY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_CHASSIS_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_EST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="DEDUCTIBLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_VALUE" type="{http://www.w3.org/2001/XMLSchema}long"/>
				 *         &lt;element name="AGENCY_REPAIR" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="VEHICLE_CAPACITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="VEHICLE_CYLINDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="VEHICLE_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="NCD_YEARS" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="LOYALTY_DISCOUNT_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="NET_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="NCD_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="LOYALTY_DISCOUNT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="NCD_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="LOYALTY_DISCOUNT_PER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="LOADING_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="POLICY_TAXES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="POLICY_FEES" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="TOTAL_COVER_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="GROSS_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *         &lt;element name="ADD_DRIVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="ADD_COVER_COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *         &lt;element name="EXIST_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="EXIST_COMP_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="EXIST_EXP_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *         &lt;element name="ADD_DRIVER" maxOccurs="unbounded" minOccurs="0">
				 *           &lt;complexType>
				 *             &lt;complexContent>
				 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
				 *                 &lt;sequence>
				 *                   &lt;element name="DRIVER_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *                   &lt;element name="DRIVER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
				 *                   &lt;element name="DRIVER_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                   &lt;element name="DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                   &lt;element name="DRIVER_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                   &lt;element name="DRIVER_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                   &lt;element name="DRIVER_NCD" type="{http://www.w3.org/2001/XMLSchema}int"/>
				 *                 &lt;/sequence>
				 *               &lt;/restriction>
				 *             &lt;/complexContent>
				 *           &lt;/complexType>
				 *         &lt;/element>
				 *         &lt;element name="COVER" maxOccurs="unbounded" minOccurs="0">
				 *           &lt;complexType>
				 *             &lt;complexContent>
				 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
				 *                 &lt;sequence>
				 *                   &lt;element name="COVER_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                   &lt;element name="COVER_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *                   &lt;element name="COVER_SI" type="{http://www.w3.org/2001/XMLSchema}long"/>
				 *                   &lt;element name="COVER_PREM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
				 *                   &lt;element name="COVER_EFF_FRM_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                   &lt;element name="COVER_EFF_TO_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
				 *                 &lt;/sequence>
				 *               &lt;/restriction>
				 *             &lt;/complexContent>
				 *           &lt;/complexType>
				 *         &lt;/element>
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
						name = "",
						propOrder = { "content" }
				)
				public static class VEHICLEINFO {

					@XmlElementRefs(
						{ @XmlElementRef(
								name = "NCD_YEARS",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "LOYALTY_DISCOUNT_FLAG",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "POLICY_FEES",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "EXIST_EXP_DATE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "ADD_DRIVER_COUNT",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "NET_PREMIUM",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_PLATE_TYPE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "AGENCY_REPAIR",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_CYLINDER",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "DEDUCTIBLE_VALUE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_BODY_TYPE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_COLOR",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "GROSS_PREMIUM",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_PLATE_NO",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "ADD_DRIVER",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "LOYALTY_DISCOUNT_PER",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "LOADING_AMOUNT",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_CHASSIS_NO",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "EXIST_POL_NO",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "EXIST_COMP_NAME",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "CITY",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "COVER",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_ID_TYPE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_EST_EXP_DATE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_VALUE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "PURPOSE_OF_VEHICLE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "ADD_COVER_COUNT",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_MAKE",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_PLATE_L2",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_MODEL",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_PLATE_L1",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "NCD_DISCOUNT_PER",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_PLATE_L3",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "POLICY_TAXES",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_ID",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_CAPACITY",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_WEIGHT",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "TOTAL_COVER_PREMIUM",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "VEHICLE_MFG_YEAR",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "NCD_DISCOUNT_AMOUNT",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						), @XmlElementRef(
								name = "LOYALTY_DISCOUNT_AMOUNT",
								namespace = "http://tempuri.org/",
								type = JAXBElement.class
						) }
					)
					@XmlMixed
					protected List<Serializable> content;

					/**
					 * Gets the value of the content property.
					 * 
					 * <p>
					 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
					 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
					 * content property.
					 * 
					 * <p>
					 * For example, to add a new item, do as follows:
					 * 
					 * <pre>
					 * getContent().add(newItem);
					 * </pre>
					 * 
					 * 
					 * <p>
					 * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
					 * {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link Integer }{@code >}
					 * {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement
					 * }{@code <}{@link PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO.ADDDRIVER }{@code >} {@link JAXBElement
					 * }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement
					 * }{@code <}{@link String }{@code >} {@link String } {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
					 * {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement
					 * }{@code <}{@link PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO.COVER }{@code >} {@link JAXBElement
					 * }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement
					 * }{@code <}{@link Long }{@code >} {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement
					 * }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement
					 * }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement
					 * }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement
					 * }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link Long }{@code >} {@link JAXBElement
					 * }{@code <}{@link Integer }{@code >} {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement
					 * }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link Integer }{@code >} {@link JAXBElement
					 * }{@code <}{@link BigDecimal }{@code >} {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
					 * 
					 * 
					 */
					public List<Serializable> getContent() {
						if (content == null) {
							content = new ArrayList<Serializable>();
						}
						return this.content;
					}

					/**
					 * <p>
					 * Java class for anonymous complex type.
					 * 
					 * <p>
					 * The following schema fragment specifies the expected content contained within this class.
					 * 
					 * <pre>
					 * &lt;complexType>
					 *   &lt;complexContent>
					 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
					 *       &lt;sequence>
					 *         &lt;element name="DRIVER_ID_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
					 *         &lt;element name="DRIVER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
					 *         &lt;element name="DRIVER_DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
					 *         &lt;element name="DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
					 *         &lt;element name="DRIVER_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
					 *         &lt;element name="DRIVER_GENDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
					 *         &lt;element name="DRIVER_NCD" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
							name = "",
							propOrder = { "driveridtype", "driverid", "driverdob", "drivername", "drivernationality", "drivergender", "driverncd" }
					)
					public static class ADDDRIVER {

						@XmlElement(
								name = "DRIVER_ID_TYPE"
						)
						protected int		driveridtype;
						@XmlElement(
								name = "DRIVER_ID"
						)
						protected long		driverid;
						@XmlElement(
								name = "DRIVER_DOB",
								required = true
						)
						protected String	driverdob;
						@XmlElement(
								name = "DRIVER_NAME",
								required = true
						)
						protected String	drivername;
						@XmlElement(
								name = "DRIVER_NATIONALITY",
								required = true
						)
						protected String	drivernationality;
						@XmlElement(
								name = "DRIVER_GENDER",
								required = true
						)
						protected String	drivergender;
						@XmlElement(
								name = "DRIVER_NCD"
						)
						protected int		driverncd;

						/**
						 * Gets the value of the driveridtype property.
						 * 
						 */
						public int getDRIVERIDTYPE() {
							return driveridtype;
						}

						/**
						 * Sets the value of the driveridtype property.
						 * 
						 */
						public void setDRIVERIDTYPE(int value) {
							this.driveridtype = value;
						}

						/**
						 * Gets the value of the driverid property.
						 * 
						 */
						public long getDRIVERID() {
							return driverid;
						}

						/**
						 * Sets the value of the driverid property.
						 * 
						 */
						public void setDRIVERID(long value) {
							this.driverid = value;
						}

						/**
						 * Gets the value of the driverdob property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getDRIVERDOB() {
							return driverdob;
						}

						/**
						 * Sets the value of the driverdob property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setDRIVERDOB(String value) {
							this.driverdob = value;
						}

						/**
						 * Gets the value of the drivername property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getDRIVERNAME() {
							return drivername;
						}

						/**
						 * Sets the value of the drivername property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setDRIVERNAME(String value) {
							this.drivername = value;
						}

						/**
						 * Gets the value of the drivernationality property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getDRIVERNATIONALITY() {
							return drivernationality;
						}

						/**
						 * Sets the value of the drivernationality property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setDRIVERNATIONALITY(String value) {
							this.drivernationality = value;
						}

						/**
						 * Gets the value of the drivergender property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getDRIVERGENDER() {
							return drivergender;
						}

						/**
						 * Sets the value of the drivergender property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setDRIVERGENDER(String value) {
							this.drivergender = value;
						}

						/**
						 * Gets the value of the driverncd property.
						 * 
						 */
						public int getDRIVERNCD() {
							return driverncd;
						}

						/**
						 * Sets the value of the driverncd property.
						 * 
						 */
						public void setDRIVERNCD(int value) {
							this.driverncd = value;
						}

					}

					/**
					 * <p>
					 * Java class for anonymous complex type.
					 * 
					 * <p>
					 * The following schema fragment specifies the expected content contained within this class.
					 * 
					 * <pre>
					 * &lt;complexType>
					 *   &lt;complexContent>
					 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
					 *       &lt;sequence>
					 *         &lt;element name="COVER_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
					 *         &lt;element name="COVER_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
					 *         &lt;element name="COVER_SI" type="{http://www.w3.org/2001/XMLSchema}long"/>
					 *         &lt;element name="COVER_PREM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
					 *         &lt;element name="COVER_EFF_FRM_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
					 *         &lt;element name="COVER_EFF_TO_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
							name = "",
							propOrder = { "covercode", "coverrate", "coversi", "coverprem", "coverefffrmdate", "coverefftodate" }
					)
					public static class COVER {

						@XmlElement(
								name = "COVER_CODE",
								required = true
						)
						protected String		covercode;
						@XmlElement(
								name = "COVER_RATE",
								required = true
						)
						protected BigDecimal	coverrate;
						@XmlElement(
								name = "COVER_SI"
						)
						protected long			coversi;
						@XmlElement(
								name = "COVER_PREM",
								required = true
						)
						protected BigDecimal	coverprem;
						@XmlElement(
								name = "COVER_EFF_FRM_DATE",
								required = true
						)
						protected String		coverefffrmdate;
						@XmlElement(
								name = "COVER_EFF_TO_DATE",
								required = true
						)
						protected String		coverefftodate;

						/**
						 * Gets the value of the covercode property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getCOVERCODE() {
							return covercode;
						}

						/**
						 * Sets the value of the covercode property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setCOVERCODE(String value) {
							this.covercode = value;
						}

						/**
						 * Gets the value of the coverrate property.
						 * 
						 * @return possible object is {@link BigDecimal }
						 * 
						 */
						public BigDecimal getCOVERRATE() {
							return coverrate;
						}

						/**
						 * Sets the value of the coverrate property.
						 * 
						 * @param value allowed object is {@link BigDecimal }
						 * 
						 */
						public void setCOVERRATE(BigDecimal value) {
							this.coverrate = value;
						}

						/**
						 * Gets the value of the coversi property.
						 * 
						 */
						public long getCOVERSI() {
							return coversi;
						}

						/**
						 * Sets the value of the coversi property.
						 * 
						 */
						public void setCOVERSI(long value) {
							this.coversi = value;
						}

						/**
						 * Gets the value of the coverprem property.
						 * 
						 * @return possible object is {@link BigDecimal }
						 * 
						 */
						public BigDecimal getCOVERPREM() {
							return coverprem;
						}

						/**
						 * Sets the value of the coverprem property.
						 * 
						 * @param value allowed object is {@link BigDecimal }
						 * 
						 */
						public void setCOVERPREM(BigDecimal value) {
							this.coverprem = value;
						}

						/**
						 * Gets the value of the coverefffrmdate property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getCOVEREFFFRMDATE() {
							return coverefffrmdate;
						}

						/**
						 * Sets the value of the coverefffrmdate property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setCOVEREFFFRMDATE(String value) {
							this.coverefffrmdate = value;
						}

						/**
						 * Gets the value of the coverefftodate property.
						 * 
						 * @return possible object is {@link String }
						 * 
						 */
						public String getCOVEREFFTODATE() {
							return coverefftodate;
						}

						/**
						 * Sets the value of the coverefftodate property.
						 * 
						 * @param value allowed object is {@link String }
						 * 
						 */
						public void setCOVEREFFTODATE(String value) {
							this.coverefftodate = value;
						}

					}

				}

			}

		}

	}

}
