//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.19 at 09:54:45 AM IST 
//


package com.ibm.parkease.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParkingAreasType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParkingAreasType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parkingAreaName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="availableSlots" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalSlots" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParkingAreasType", propOrder = {
    "parkingAreaName",
    "availableSlots",
    "totalSlots"
})
public class ParkingAreasType {

    @XmlElement(required = true)
    protected String parkingAreaName;
    @XmlElement(required = true)
    protected String availableSlots;
    @XmlElement(required = true)
    protected String totalSlots;

    /**
     * Gets the value of the parkingAreaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParkingAreaName() {
        return parkingAreaName;
    }

    /**
     * Sets the value of the parkingAreaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParkingAreaName(String value) {
        this.parkingAreaName = value;
    }

    /**
     * Gets the value of the availableSlots property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailableSlots() {
        return availableSlots;
    }

    /**
     * Sets the value of the availableSlots property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailableSlots(String value) {
        this.availableSlots = value;
    }

    /**
     * Gets the value of the totalSlots property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalSlots() {
        return totalSlots;
    }

    /**
     * Sets the value of the totalSlots property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalSlots(String value) {
        this.totalSlots = value;
    }

}
