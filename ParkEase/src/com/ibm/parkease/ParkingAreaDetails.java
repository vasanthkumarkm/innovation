package com.ibm.parkease;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ibm.parkease.adapter.ParkingAreasAdapter;
import com.ibm.parkease.dao.LocationDataAccess;
import com.ibm.parkease.dto.LocationType;

public class ParkingAreaDetails extends Activity {
	
	
	
	
	LocationType locationType = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parking_area_details);
		
        ListView listView = ( ListView ) findViewById(R.id.listviewdetail);

		locationType = (LocationType) LocationDataAccess.locationList.get(getIntent().getIntExtra("location",0));
				
		ParkingAreasAdapter adapter = new ParkingAreasAdapter(getApplicationContext(), locationType.getParkingAreas(),locationType.getLocationAddress());
		listView.setAdapter(adapter);
		setTitle("Parking Details for "+locationType.getLocationName().replaceAll("_", " "));
		
		ListView parkingAreaListView = ( ListView ) findViewById(R.id.listviewdetail);
		
		parkingAreaListView.setOnItemClickListener (new OnItemClickListener() {
			  public void onItemClick(AdapterView parent, View view, int position, long id) {
			   
				 /* Intent intent = new Intent(ParkingAreaDetails.this, SimulateAvailablityLocationUpdates.class);
				  startActivity(intent);
				  return true;*/

				  Geocoder coder = new Geocoder(getApplicationContext());
				  List<Address> destinations = null;
				  try {
					  destinations = coder.getFromLocationName(locationType.getLocationAddress(),5);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  if(destinations.get(0)!=null)
				  {
						Address destination = destinations.get(0); 
						  
						 Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
								 Uri.parse("http://maps.google.com/maps?saddr=&daddr="+destination.getLatitude()+","+destination.getLongitude()));
								 startActivity(intent);
								 
				  }
				  
			  }
			});			

	}
	
@Override
protected void onStart() {
	Toast.makeText(getApplicationContext(), "Select Parking Area To Navigate", Toast.LENGTH_SHORT).show();

	super.onStart();
}

@Override
protected void onResume() {
	Toast.makeText(getApplicationContext(), "Select Parking Area To Navigate", Toast.LENGTH_SHORT).show();

	super.onResume();
}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.parking_area_details, menu);
		return true;
	}

}
