package com.ibm.parkease;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.ibm.parkease.adapter.LocationsAdapter;
import com.ibm.parkease.dao.ILocationDataAccess;
import com.ibm.parkease.dao.LocationDataAccess;
import com.ibm.parkease.dto.LocationType;

class PopulateLocations extends AsyncTask<ListView, Void, String> {

	ListView locationListView = null;
	List<LocationType> locationsList = new ArrayList<LocationType>();
	Context mContext;
	public PopulateLocations(Context context)
	{
		mContext = context;
	}
    protected void onPostExecute(String feed) {
    	LocationsAdapter locationsAdapter = new LocationsAdapter(mContext,locationsList);
    	locationListView.setAdapter(locationsAdapter);
    	
    }

	@Override
	protected String doInBackground(ListView... params) {
		LocationDataAccess.locationList = new ArrayList();
		locationListView = params[0];
		ILocationDataAccess locationDataAccess = new LocationDataAccess();
		String[] locations = locationDataAccess.getLocations();
		for (int i = 0; i < locations.length; i++) {
			locationsList.add(locationDataAccess.getLocationInformation(locations[i]))  ;
		}
		return "";
	}

}