//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.19 at 09:54:45 AM IST 
//


package com.ibm.parkease.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;



@Root(name="parkingAreas")
public class ParkingAreasType {
	@Element
    private String parkingAreaName;
	@Element
    private String availableSlots;
	@Element
    private String totalSlots;

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