package com.ibm.parkease.services;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ibm.parkease.dao.LocationDAO;
import com.ibm.parkease.dto.LocationType;



/**
 * @author vasanth
 *
 */
@Path("/location")
public class LocationService {
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response createLocation(LocationType location)
	{
		Response response = new Response();

		try {

				LocationDAO locationDao = new LocationDAO();
				locationDao.save(location);
				response.setStatus("SUCCESS");

		} catch (SQLException exception) {
			exception.printStackTrace();
			response.setStatus("ERROR");
			response.setErrorDescription(exception.getMessage());
		}
		return response;
	}
	@POST
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response updateLocation(LocationType location)
	{
		Response response = new Response();

		try {

				LocationDAO locationDao = new LocationDAO();
				locationDao.update(location);
				response.setStatus("SUCCESS");

		} catch (SQLException exception) {
			exception.printStackTrace();
			response.setStatus("ERROR");
			response.setErrorDescription(exception.getMessage());
		}
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public LocationType getLocation(@QueryParam("locationName") String locationName)
	{
		LocationType location = null;

		try {
			LocationDAO locationDao = new LocationDAO();
			location = locationDao.get(locationName);
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			location = null;
		}
		return location;
	}	
	

}
