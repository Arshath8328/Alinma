
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for companyInfoBySponseredIqamaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="companyInfoBySponseredIqamaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalNumberOfSponsoredDependents" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalNumberOfSponsoreds" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "companyInfoBySponseredIqamaResult", propOrder = {
    "logId",
    "totalNumberOfSponsoredDependents",
    "totalNumberOfSponsoreds"
})
public class CompanyInfoBySponseredIqamaResult {

    protected int logId;
    protected int totalNumberOfSponsoredDependents;
    protected int totalNumberOfSponsoreds;

    /**
     * Gets the value of the logId property.
     * 
     */
    public int getLogId() {
        return logId;
    }

    /**
     * Sets the value of the logId property.
     * 
     */
    public void setLogId(int value) {
        this.logId = value;
    }

    /**
     * Gets the value of the totalNumberOfSponsoredDependents property.
     * 
     */
    public int getTotalNumberOfSponsoredDependents() {
        return totalNumberOfSponsoredDependents;
    }

    /**
     * Sets the value of the totalNumberOfSponsoredDependents property.
     * 
     */
    public void setTotalNumberOfSponsoredDependents(int value) {
        this.totalNumberOfSponsoredDependents = value;
    }

    /**
     * Gets the value of the totalNumberOfSponsoreds property.
     * 
     */
    public int getTotalNumberOfSponsoreds() {
        return totalNumberOfSponsoreds;
    }

    /**
     * Sets the value of the totalNumberOfSponsoreds property.
     * 
     */
    public void setTotalNumberOfSponsoreds(int value) {
        this.totalNumberOfSponsoreds = value;
    }

}
