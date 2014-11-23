package com.ibm.parkease.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.ibm.parkease.dto.LocationType;

public class LocationDataAccess implements ILocationDataAccess,Serializable {

	public static ArrayList locationList = new ArrayList();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.parkease.dao.ILocationDataAccess#getLocations()
	 */
	@Override
	public String[] getLocations() {
		final String url = "http://ibmparkease.mybluemix.net/webservices/listlocations";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new StringHttpMessageConverter());
		String locations = restTemplate.getForObject(url, String.class);
		StringTokenizer tokenizer = new StringTokenizer(locations, "|");

		List<String> locationsList = new ArrayList<String>();

		while (tokenizer.hasMoreElements()) {
			String value = tokenizer.nextToken();
			if(value!=null && !value.equals(""))
			{
				locationsList.add(value);
			}
				
		}
		return locationsList.toArray(new String[tokenizer.countTokens()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ibm.parkease.dao.ILocationDataAccess#getLocationInformation(java.
	 * lang.String)
	 */
	@Override
	public LocationType getLocationInformation(String locationName) {
		final String url = "http://ibmparkease.mybluemix.net/webservices/location?locationName="+locationName;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new SimpleXmlHttpMessageConverter());
		LocationType location = restTemplate.getForObject(url,
				LocationType.class);
		locationList.add(location);
		return location;
	}
}
