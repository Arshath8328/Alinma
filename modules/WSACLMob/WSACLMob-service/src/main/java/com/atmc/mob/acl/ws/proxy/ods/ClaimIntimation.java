
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
 *         &lt;element name="xmlRequest" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CLAIM_INTIMATION">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="POLICY_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="REPORT_MODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="REPORT_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="VEH_IDENTI_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="VEH_IDENTI_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="LOSS_NATURE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="LOSS_CAUSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="LOSS_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="LOSS_REMARKS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="FAULT_PERCENT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="LOSS_LOCATION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_DOB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="TP_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_VEH_IDENTI_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_VEH_IDENTI_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_INS_CO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TP_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="DAMAGE_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="MOBILE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "xmlRequest"
})
@XmlRootElement(name = "Claim_Intimation")
public class ClaimIntimation {

    protected ClaimIntimation.XmlRequest xmlRequest;

    /**
     * Gets the value of the xmlRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ClaimIntimation.XmlRequest }
     *     
     */
    public ClaimIntimation.XmlRequest getXmlRequest() {
        return xmlRequest;
    }

    /**
     * Sets the value of the xmlRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimIntimation.XmlRequest }
     *     
     */
    public void setXmlRequest(ClaimIntimation.XmlRequest value) {
        this.xmlRequest = value;
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
     *         &lt;element name="CLAIM_INTIMATION">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="REFERENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="POLICY_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="REPORT_MODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="REPORT_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="VEH_IDENTI_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="VEH_IDENTI_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="LOSS_NATURE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="LOSS_CAUSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="LOSS_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="LOSS_REMARKS" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="FAULT_PERCENT" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="LOSS_LOCATION" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_DOB" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="TP_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_VEH_IDENTI_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_VEH_IDENTI_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_INS_CO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TP_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="DAMAGE_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="MOBILE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "claimintimation"
    })
    public static class XmlRequest {

        @XmlElement(name = "CLAIM_INTIMATION", required = true)
        protected ClaimIntimation.XmlRequest.CLAIMINTIMATION claimintimation;

        /**
         * Gets the value of the claimintimation property.
         * 
         * @return
         *     possible object is
         *     {@link ClaimIntimation.XmlRequest.CLAIMINTIMATION }
         *     
         */
        public ClaimIntimation.XmlRequest.CLAIMINTIMATION getCLAIMINTIMATION() {
            return claimintimation;
        }

        /**
         * Sets the value of the claimintimation property.
         * 
         * @param value
         *     allowed object is
         *     {@link ClaimIntimation.XmlRequest.CLAIMINTIMATION }
         *     
         */
        public void setCLAIMINTIMATION(ClaimIntimation.XmlRequest.CLAIMINTIMATION value) {
            this.claimintimation = value;
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
         *         &lt;element name="SOURCE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TRANSACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="POLICY_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="REPORT_MODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="REPORT_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="VEH_IDENTI_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="VEH_IDENTI_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="LOSS_NATURE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="LOSS_CAUSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="LOSS_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="LOSS_REMARKS" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="FAULT_PERCENT" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="LOSS_LOCATION" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_DRIVER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_DOB" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="TP_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_VEH_IDENTI_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_VEH_IDENTI_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_PLATE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_INS_CO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_MOBILE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_IBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TP_POL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="DAMAGE_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="MOBILE_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "source",
            "transaction",
            "policyno",
            "reportmode",
            "reportno",
            "vehidentitype",
            "vehidentivalue",
            "lossnature",
            "losscause",
            "lossdate",
            "lossremarks",
            "faultpercent",
            "losslocation",
            "tpdrivername",
            "tpdob",
            "tpid",
            "tpvehidentitype",
            "tpvehidentivalue",
            "tpplateno",
            "tpinsco",
            "tpmobile",
            "tpiban",
            "tpnationality",
            "tppolno",
            "amount",
            "damageflag",
            "mobileno"
        })
        public static class CLAIMINTIMATION {

            @XmlElement(name = "REFERENCE_NO", required = true)
            protected String referenceno;
            @XmlElement(name = "SOURCE", required = true)
            protected String source;
            @XmlElement(name = "TRANSACTION", required = true)
            protected String transaction;
            @XmlElement(name = "POLICY_NO", required = true)
            protected String policyno;
            @XmlElement(name = "REPORT_MODE", required = true)
            protected String reportmode;
            @XmlElement(name = "REPORT_NO", required = true)
            protected String reportno;
            @XmlElement(name = "VEH_IDENTI_TYPE", required = true)
            protected String vehidentitype;
            @XmlElement(name = "VEH_IDENTI_VALUE", required = true)
            protected String vehidentivalue;
            @XmlElement(name = "LOSS_NATURE", required = true)
            protected String lossnature;
            @XmlElement(name = "LOSS_CAUSE", required = true)
            protected String losscause;
            @XmlElement(name = "LOSS_DATE", required = true)
            protected String lossdate;
            @XmlElement(name = "LOSS_REMARKS", required = true)
            protected String lossremarks;
            @XmlElement(name = "FAULT_PERCENT")
            protected int faultpercent;
            @XmlElement(name = "LOSS_LOCATION", required = true)
            protected String losslocation;
            @XmlElement(name = "TP_DRIVER_NAME", required = true)
            protected String tpdrivername;
            @XmlElement(name = "TP_DOB")
            protected int tpdob;
            @XmlElement(name = "TP_ID", required = true)
            protected String tpid;
            @XmlElement(name = "TP_VEH_IDENTI_TYPE", required = true)
            protected String tpvehidentitype;
            @XmlElement(name = "TP_VEH_IDENTI_VALUE", required = true)
            protected String tpvehidentivalue;
            @XmlElement(name = "TP_PLATE_NO", required = true)
            protected String tpplateno;
            @XmlElement(name = "TP_INS_CO", required = true)
            protected String tpinsco;
            @XmlElement(name = "TP_MOBILE", required = true)
            protected String tpmobile;
            @XmlElement(name = "TP_IBAN", required = true)
            protected String tpiban;
            @XmlElement(name = "TP_NATIONALITY", required = true)
            protected String tpnationality;
            @XmlElement(name = "TP_POL_NO", required = true)
            protected String tppolno;
            @XmlElement(name = "AMOUNT", required = true)
            protected BigDecimal amount;
            @XmlElement(name = "DAMAGE_FLAG", required = true)
            protected String damageflag;
            @XmlElement(name = "MOBILE_NO", required = true)
            protected String mobileno;

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
             * Gets the value of the source property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSOURCE() {
                return source;
            }

            /**
             * Sets the value of the source property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSOURCE(String value) {
                this.source = value;
            }

            /**
             * Gets the value of the transaction property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTRANSACTION() {
                return transaction;
            }

            /**
             * Sets the value of the transaction property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTRANSACTION(String value) {
                this.transaction = value;
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
             * Gets the value of the reportmode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREPORTMODE() {
                return reportmode;
            }

            /**
             * Sets the value of the reportmode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREPORTMODE(String value) {
                this.reportmode = value;
            }

            /**
             * Gets the value of the reportno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREPORTNO() {
                return reportno;
            }

            /**
             * Sets the value of the reportno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREPORTNO(String value) {
                this.reportno = value;
            }

            /**
             * Gets the value of the vehidentitype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVEHIDENTITYPE() {
                return vehidentitype;
            }

            /**
             * Sets the value of the vehidentitype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVEHIDENTITYPE(String value) {
                this.vehidentitype = value;
            }

            /**
             * Gets the value of the vehidentivalue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVEHIDENTIVALUE() {
                return vehidentivalue;
            }

            /**
             * Sets the value of the vehidentivalue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVEHIDENTIVALUE(String value) {
                this.vehidentivalue = value;
            }

            /**
             * Gets the value of the lossnature property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOSSNATURE() {
                return lossnature;
            }

            /**
             * Sets the value of the lossnature property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOSSNATURE(String value) {
                this.lossnature = value;
            }

            /**
             * Gets the value of the losscause property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOSSCAUSE() {
                return losscause;
            }

            /**
             * Sets the value of the losscause property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOSSCAUSE(String value) {
                this.losscause = value;
            }

            /**
             * Gets the value of the lossdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOSSDATE() {
                return lossdate;
            }

            /**
             * Sets the value of the lossdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOSSDATE(String value) {
                this.lossdate = value;
            }

            /**
             * Gets the value of the lossremarks property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOSSREMARKS() {
                return lossremarks;
            }

            /**
             * Sets the value of the lossremarks property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOSSREMARKS(String value) {
                this.lossremarks = value;
            }

            /**
             * Gets the value of the faultpercent property.
             * 
             */
            public int getFAULTPERCENT() {
                return faultpercent;
            }

            /**
             * Sets the value of the faultpercent property.
             * 
             */
            public void setFAULTPERCENT(int value) {
                this.faultpercent = value;
            }

            /**
             * Gets the value of the losslocation property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOSSLOCATION() {
                return losslocation;
            }

            /**
             * Sets the value of the losslocation property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOSSLOCATION(String value) {
                this.losslocation = value;
            }

            /**
             * Gets the value of the tpdrivername property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPDRIVERNAME() {
                return tpdrivername;
            }

            /**
             * Sets the value of the tpdrivername property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPDRIVERNAME(String value) {
                this.tpdrivername = value;
            }

            /**
             * Gets the value of the tpdob property.
             * 
             */
            public int getTPDOB() {
                return tpdob;
            }

            /**
             * Sets the value of the tpdob property.
             * 
             */
            public void setTPDOB(int value) {
                this.tpdob = value;
            }

            /**
             * Gets the value of the tpid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPID() {
                return tpid;
            }

            /**
             * Sets the value of the tpid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPID(String value) {
                this.tpid = value;
            }

            /**
             * Gets the value of the tpvehidentitype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPVEHIDENTITYPE() {
                return tpvehidentitype;
            }

            /**
             * Sets the value of the tpvehidentitype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPVEHIDENTITYPE(String value) {
                this.tpvehidentitype = value;
            }

            /**
             * Gets the value of the tpvehidentivalue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPVEHIDENTIVALUE() {
                return tpvehidentivalue;
            }

            /**
             * Sets the value of the tpvehidentivalue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPVEHIDENTIVALUE(String value) {
                this.tpvehidentivalue = value;
            }

            /**
             * Gets the value of the tpplateno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPPLATENO() {
                return tpplateno;
            }

            /**
             * Sets the value of the tpplateno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPPLATENO(String value) {
                this.tpplateno = value;
            }

            /**
             * Gets the value of the tpinsco property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPINSCO() {
                return tpinsco;
            }

            /**
             * Sets the value of the tpinsco property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPINSCO(String value) {
                this.tpinsco = value;
            }

            /**
             * Gets the value of the tpmobile property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPMOBILE() {
                return tpmobile;
            }

            /**
             * Sets the value of the tpmobile property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPMOBILE(String value) {
                this.tpmobile = value;
            }

            /**
             * Gets the value of the tpiban property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPIBAN() {
                return tpiban;
            }

            /**
             * Sets the value of the tpiban property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPIBAN(String value) {
                this.tpiban = value;
            }

            /**
             * Gets the value of the tpnationality property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPNATIONALITY() {
                return tpnationality;
            }

            /**
             * Sets the value of the tpnationality property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPNATIONALITY(String value) {
                this.tpnationality = value;
            }

            /**
             * Gets the value of the tppolno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTPPOLNO() {
                return tppolno;
            }

            /**
             * Sets the value of the tppolno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTPPOLNO(String value) {
                this.tppolno = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAMOUNT() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAMOUNT(BigDecimal value) {
                this.amount = value;
            }

            /**
             * Gets the value of the damageflag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDAMAGEFLAG() {
                return damageflag;
            }

            /**
             * Sets the value of the damageflag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDAMAGEFLAG(String value) {
                this.damageflag = value;
            }

            /**
             * Gets the value of the mobileno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMOBILENO() {
                return mobileno;
            }

            /**
             * Sets the value of the mobileno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMOBILENO(String value) {
                this.mobileno = value;
            }

        }

    }

}
