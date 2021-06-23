
package com.atmc.mob.acl.ws.proxy.yakeen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alienSingleDepInfoByIqamaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alienSingleDepInfoByIqamaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dependentsListList" type="{http://yakeen4alinmatm.yakeen.elm.com/}dependentsList7" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "alienSingleDepInfoByIqamaResult", propOrder = {
    "dependentsListList",
    "logId"
})
public class AlienSingleDepInfoByIqamaResult {

    @XmlElement(nillable = true)
    protected List<DependentsList7> dependentsListList;
    protected int logId;

    /**
     * Gets the value of the dependentsListList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentsListList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentsListList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DependentsList7 }
     * 
     * 
     */
    public List<DependentsList7> getDependentsListList() {
        if (dependentsListList == null) {
            dependentsListList = new ArrayList<DependentsList7>();
        }
        return this.dependentsListList;
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
