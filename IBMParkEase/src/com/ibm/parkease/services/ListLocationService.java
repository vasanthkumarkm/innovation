package com.ibm.parkease.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.parkease.dao.LocationDAO;



/**
 * @author vasanth
 *
 */
@Path("/listlocations")
public class ListLocationService {
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getLocation()
	{
		String locations = null;

		try {
			LocationDAO locationDao = new LocationDAO();
			locations = locationDao.getLocations();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			locations = null;
		}
		return locations;
	}	
	

}
