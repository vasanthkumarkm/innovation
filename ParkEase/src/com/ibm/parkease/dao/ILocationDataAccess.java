package com.ibm.parkease.dao;

import com.ibm.parkease.dto.LocationType;

public interface ILocationDataAccess {

	public abstract String[] getLocations();

	public abstract LocationType getLocationInformation(String locationName);

}