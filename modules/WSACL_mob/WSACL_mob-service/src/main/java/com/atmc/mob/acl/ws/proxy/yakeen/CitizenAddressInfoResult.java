
package com.atmc.mob.acl.ws.proxy.yakeen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for citizenAddressInfoResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="citizenAddressInfoResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressListList" type="{http://yakeen4alinmatm.yakeen.elm.com/}addressList13" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "citizenAddressInfoResult", propOrder = {
    "addressListList",
    "logId"
})
public class CitizenAddressInfoResult {

    @XmlElement(nillable = true)
    protected List<AddressList13> addressListList;
    protected int logId;

    /**
     * Gets the value of the addressListList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressListList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressListList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressList13 }
     * 
     * 
     */
    public List<AddressList13> getAddressListList() {
        if (addressListList == null) {
            addressListList = new ArrayList<AddressList13>();
        }
        return this.addressListList;
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
