package com.ibm.parkease.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.ibm.parkease.dto.LocationType;
import com.ibm.parkease.dto.ParkingAreasType;
import com.ibm.parkease.util.DBUtil;

public class LocationDAO {
	 static Logger log = Logger.getLogger(LocationDAO.class.getName());
	public void save(LocationType location) throws SQLException {

		Statement stmt = DBUtil.getStatement();

		String sqlStatement = "INSERT INTO L_408893.LOCATION (L_408893.LOCATION.LOCATION_NAME,L_408893.LOCATION.ADDRESS,L_408893.LOCATION.GEOLOCATION) VALUES('"
				+ location.getLocationName()
				+ "','"
				+ location.getLocationAddress()
				+ "','"
				+ location.getGeoLocation() + "')";
		log.error(sqlStatement);
		stmt.executeUpdate(sqlStatement);
		List<ParkingAreasType> parkingAreas = location.getParkingAreas();

		for (Iterator<ParkingAreasType> iterator = parkingAreas.iterator(); iterator
				.hasNext();) {
			ParkingAreasType parkingArea = (ParkingAreasType) iterator.next();
			sqlStatement = "INSERT INTO L_408893.PARKING_AREAS (L_408893.PARKING_AREAS.LOCATION_NAME,L_408893.PARKING_AREAS.AREA_NAME,L_408893.PARKING_AREAS.TOTAL_SLOTS,L_408893.PARKING_AREAS.AVAILABLE_SLOTS) VALUES('"
					+ location.getLocationName()
					+ "','"
					+ parkingArea.getParkingAreaName()
					+ "','"
					+ parkingArea.getTotalSlots()
					+ "','"
					+ parkingArea.getAvailableSlots() + "')";
			log.error(sqlStatement);
			stmt.executeUpdate(sqlStatement);

		}

	}

	public void update(LocationType location) throws SQLException {

		Statement stmt = DBUtil.getStatement();

		String sqlStatement = "UPDATE  L_408893.LOCATION SET  L_408893.LOCATION.LOCATION_NAME='"
				+ location.getLocationName() + "', L_408893.LOCATION.ADDRESS='"
				+ location.getLocationAddress() + "',L_408893.LOCATION.GEOLOCATION='"
				+ location.getGeoLocation() + "' WHERE L_408893.LOCATION.LOCATION_NAME='"+location.getLocationName()+"'";

		stmt.executeUpdate(sqlStatement);

		List<ParkingAreasType> parkingAreas = location.getParkingAreas();

		for (Iterator<ParkingAreasType> iterator = parkingAreas.iterator(); iterator
				.hasNext();) {
			ParkingAreasType parkingArea = (ParkingAreasType) iterator.next();

			sqlStatement = "UPDATE L_408893.PARKING_AREAS SET L_408893.PARKING_AREAS.LOCATION_NAME='"
					+ location.getLocationName() + "',L_408893.PARKING_AREAS.AREA_NAME='"
					+ parkingArea.getParkingAreaName() + "',L_408893.PARKING_AREAS.TOTAL_SLOTS='"
					+ parkingArea.getTotalSlots() + "',L_408893.PARKING_AREAS.AVAILABLE_SLOTS='"
					+ parkingArea.getAvailableSlots()
					+ "' WHERE L_408893.PARKING_AREAS.LOCATION_NAME ='" + location.getLocationName()
					+ "' AND  L_408893.PARKING_AREAS.AREA_NAME='" + parkingArea.getParkingAreaName()
					+ "'";
			stmt.executeUpdate(sqlStatement);

		}

		

	}

	public LocationType get(String locationName) throws SQLException {
		Statement stmt = DBUtil.getStatement();
		String sqlStatement = null;

		sqlStatement = "SELECT L_408893.LOCATION.LOCATION_NAME,L_408893.LOCATION.ADDRESS,L_408893.LOCATION.GEOLOCATION FROM  L_408893.LOCATION where L_408893.LOCATION.LOCATION_NAME = '"
				+ locationName + "'";
		LocationType location = new LocationType();
		ResultSet resultSet = stmt.executeQuery(sqlStatement);
		if (resultSet.next()) {
			location.setGeoLocation(resultSet.getString("GEOLOCATION"));
			location.setLocationAddress(resultSet.getString("ADDRESS"));
			location.setLocationName(resultSet.getString("LOCATION_NAME"));
			
			sqlStatement = "SELECT L_408893.PARKING_AREAS.AREA_NAME,L_408893.PARKING_AREAS.TOTAL_SLOTS,L_408893.PARKING_AREAS.AVAILABLE_SLOTS FROM L_408893.PARKING_AREAS where L_408893.PARKING_AREAS.LOCATION_NAME = '"
					+ locationName + "'";
			ResultSet rs = stmt.executeQuery(sqlStatement);
			ParkingAreasType parkingArea = null;
			while (rs.next()) {
				parkingArea = new ParkingAreasType();
				parkingArea.setAvailableSlots(rs.getString("AVAILABLE_SLOTS"));
				parkingArea.setParkingAreaName(rs.getString("AREA_NAME"));
				parkingArea.setTotalSlots(rs.getString("TOTAL_SLOTS"));
				location.getParkingAreas().add(parkingArea);
			}
		}

		return location;
	}

	public String getLocations() {
		StringBuffer result = new StringBuffer();
		try {
			String sqlStatement = null;
			Statement stmt = DBUtil.getStatement();
			sqlStatement = "SELECT L_408893.LOCATION.LOCATION_NAME,L_408893.LOCATION.ADDRESS,L_408893.LOCATION.GEOLOCATION FROM  L_408893.LOCATION";
			ResultSet resultSet = stmt.executeQuery(sqlStatement);
			while (resultSet.next()) {
				result.append("|" + resultSet.getString("LOCATION_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

}
