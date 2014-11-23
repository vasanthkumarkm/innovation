package com.ibm.parkease.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibm.parkease.R;
import com.ibm.parkease.dto.LocationType;

public class LocationsAdapter extends BaseAdapter {

	List<LocationType> locations = null;
	LayoutInflater minflater;
	Context mycontext;
	public LocationsAdapter(Context context, List<LocationType> items) {
		 this.mycontext=context;
		 minflater =LayoutInflater.from(context);
		 locations = items;
	}

	@Override
	public int getCount() {
		return locations.size();
	}

	@Override
	public Object getItem(int position) {
		return locations.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater vi;
			vi = LayoutInflater.from(mycontext);
			view = vi.inflate(R.layout.listview_layout, null);
		}
		LocationType location = (LocationType) getItem(position);

		if (location != null) {
			ImageView image = (ImageView)view.findViewById(R.id.image);
			TextView header = (TextView) view.findViewById(R.id.header);
			TextView content = (TextView) view.findViewById(R.id.content);
			if(location.getLocationName().equalsIgnoreCase("ibm_manyata"))
			image.setImageResource(R.drawable.manyata);
			else if(location.getLocationName().equalsIgnoreCase("ibm_sa"))
			image.setImageResource(R.drawable.sa);		
			else if(location.getLocationName().equalsIgnoreCase("ibm_daksh"))
			image.setImageResource(R.drawable.manyata);			
			else
				image.setImageResource(R.drawable.egl);
			
			header.setText(location.getLocationName().replaceAll("_", " "));
			content.setText(location.getLocationAddress());
			
		}
		return view;
	}
}
