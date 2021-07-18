
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alienLegalStatusInfoResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alienLegalStatusInfoResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legalStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alienLegalStatusInfoResult", propOrder = {
    "legalStatus",
    "logId"
})
public class AlienLegalStatusInfoResult {

    protected boolean legalStatus;
    protected int logId;

    /**
     * Gets the value of the legalStatus property.
     * 
     */
    public boolean isLegalStatus() {
        return legalStatus;
    }

    /**
     * Sets the value of the legalStatus property.
     * 
     */
    public void setLegalStatus(boolean value) {
        this.legalStatus = value;
    }

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

}
