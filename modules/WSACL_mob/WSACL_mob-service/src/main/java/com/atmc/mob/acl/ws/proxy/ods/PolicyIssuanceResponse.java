
package com.atmc.mob.acl.ws.proxy.ods;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PolicyIssuanceResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PI_RESPONSE">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="STATUS_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="POLICY_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="POLICY_EFFECTIVE_FROM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="POLICY_EFFECTIVE_TO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="POLICY_ISSUE_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="POLICY_AMOUNT_OR_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="POLICY_FEATURES" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="MAX_LIABILITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="ADDITIONAL_DETAILS_IF_ANY" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "policyIssuanceResult"
})
@XmlRootElement(name = "PolicyIssuanceResponse")
public class PolicyIssuanceResponse {

    @XmlElement(name = "PolicyIssuanceResult")
    protected PolicyIssuanceResponse.PolicyIssuanceResult policyIssuanceResult;

    /**
     * Gets the value of the policyIssuanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link PolicyIssuanceResponse.PolicyIssuanceResult }
     *     
     */
    public PolicyIssuanceResponse.PolicyIssuanceResult getPolicyIssuanceResult() {
        return policyIssuanceResult;
    }

    /**
     * Sets the value of the policyIssuanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyIssuanceResponse.PolicyIssuanceResult }
     *     
     */
    public void setPolicyIssuanceResult(PolicyIssuanceResponse.PolicyIssuanceResult value) {
        this.policyIssuanceResult = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PI_RESPONSE">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="STATUS_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="POLICY_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="POLICY_EFFECTIVE_FROM" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="POLICY_EFFECTIVE_TO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="POLICY_ISSUE_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="POLICY_AMOUNT_OR_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="POLICY_FEATURES" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="MAX_LIABILITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="ADDITIONAL_DETAILS_IF_ANY" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "piresponse"
    })
    public static class PolicyIssuanceResult {

        @XmlElement(name = "PI_RESPONSE", required = true)
        protected PolicyIssuanceResponse.PolicyIssuanceResult.PIRESPONSE piresponse;

        /**
         * Gets the value of the piresponse property.
         * 
         * @return
         *     possible object is
         *     {@link PolicyIssuanceResponse.PolicyIssuanceResult.PIRESPONSE }
         *     
         */
        public PolicyIssuanceResponse.PolicyIssuanceResult.PIRESPONSE getPIRESPONSE() {
            return piresponse;
        }

        /**
         * Sets the value of the piresponse property.
         * 
         * @param value
         *     allowed object is
         *     {@link PolicyIssuanceResponse.PolicyIssuanceResult.PIRESPONSE }
         *     
         */
        public void setPIRESPONSE(PolicyIssuanceResponse.PolicyIssuanceResult.PIRESPONSE value) {
            this.piresponse = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="STATUS_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="POLICY_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="POLICY_EFFECTIVE_FROM" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="POLICY_EFFECTIVE_TO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="POLICY_ISSUE_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="POLICY_AMOUNT_OR_PREMIUM" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="POLICY_FEATURES" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="MAX_LIABILITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="ADDITIONAL_DETAILS_IF_ANY" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "referenceno",
            "statuscode",
            "message",
            "policyno",
            "policyeffectivefrom",
            "policyeffectiveto",
            "policyissuedate",
            "policyamountorpremium",
            "policyfeatures",
            "maxliability",
            "additionaldetailsifany"
        })
        public static class PIRESPONSE {

            @XmlElement(name = "REFERENCE_NO", required = true)
            protected String referenceno;
            @XmlElement(name = "STATUS_CODE", required = true)
            protected String statuscode;
            @XmlElement(name = "MESSAGE", required = true)
            protected String message;
            @XmlElement(name = "POLICY_NO", required = true)
            protected String policyno;
            @XmlElement(name = "POLICY_EFFECTIVE_FROM", required = true)
            protected String policyeffectivefrom;
            @XmlElement(name = "POLICY_EFFECTIVE_TO", required = true)
            protected String policyeffectiveto;
            @XmlElement(name = "POLICY_ISSUE_DATE", required = true)
            protected String policyissuedate;
            @XmlElement(name = "POLICY_AMOUNT_OR_PREMIUM", required = true)
            protected BigDecimal policyamountorpremium;
            @XmlElement(name = "POLICY_FEATURES", required = true)
            protected String policyfeatures;
            @XmlElement(name = "MAX_LIABILITY")
            protected int maxliability;
            @XmlElement(name = "ADDITIONAL_DETAILS_IF_ANY", required = true)
            protected String additionaldetailsifany;

            /**
             * Gets the value of the referenceno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREFERENCENO() {
                return referenceno;
            }

            /**
             * Sets the value of the referenceno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREFERENCENO(String value) {
                this.referenceno = value;
            }

            /**
             * Gets the value of the statuscode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSTATUSCODE() {
                return statuscode;
            }

            /**
             * Sets the value of the statuscode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSTATUSCODE(String value) {
                this.statuscode = value;
            }

            /**
             * Gets the value of the message property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMESSAGE() {
                return message;
            }

            /**
             * Sets the value of the message property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMESSAGE(String value) {
                this.message = value;
            }

            /**
             * Gets the value of the policyno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOLICYNO() {
                return policyno;
            }

            /**
             * Sets the value of the policyno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOLICYNO(String value) {
                this.policyno = value;
            }

            /**
             * Gets the value of the policyeffectivefrom property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOLICYEFFECTIVEFROM() {
                return policyeffectivefrom;
            }

            /**
             * Sets the value of the policyeffectivefrom property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOLICYEFFECTIVEFROM(String value) {
                this.policyeffectivefrom = value;
            }

            /**
             * Gets the value of the policyeffectiveto property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOLICYEFFECTIVETO() {
                return policyeffectiveto;
            }

            /**
             * Sets the value of the policyeffectiveto property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOLICYEFFECTIVETO(String value) {
                this.policyeffectiveto = value;
            }

            /**
             * Gets the value of the policyissuedate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOLICYISSUEDATE() {
                return policyissuedate;
            }

            /**
             * Sets the value of the policyissuedate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOLICYISSUEDATE(String value) {
                this.policyissuedate = value;
            }

            /**
             * Gets the value of the policyamountorpremium property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPOLICYAMOUNTORPREMIUM() {
                return policyamountorpremium;
            }

            /**
             * Sets the value of the policyamountorpremium property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPOLICYAMOUNTORPREMIUM(BigDecimal value) {
                this.policyamountorpremium = value;
            }

            /**
             * Gets the value of the policyfeatures property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOLICYFEATURES() {
                return policyfeatures;
            }

            /**
             * Sets the value of the policyfeatures property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOLICYFEATURES(String value) {
                this.policyfeatures = value;
            }

            /**
             * Gets the value of the maxliability property.
             * 
             */
            public int getMAXLIABILITY() {
                return maxliability;
            }

            /**
             * Sets the value of the maxliability property.
             * 
             */
            public void setMAXLIABILITY(int value) {
                this.maxliability = value;
            }

            /**
             * Gets the value of the additionaldetailsifany property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getADDITIONALDETAILSIFANY() {
                return additionaldetailsifany;
            }

            /**
             * Sets the value of the additionaldetailsifany property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setADDITIONALDETAILSIFANY(String value) {
                this.additionaldetailsifany = value;
            }

        }

    }

}
