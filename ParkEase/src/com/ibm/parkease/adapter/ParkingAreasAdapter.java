package com.ibm.parkease.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ibm.parkease.R;
import com.ibm.parkease.dto.ParkingAreasType;

public class ParkingAreasAdapter extends BaseAdapter {

	List<ParkingAreasType> locations = null;
	LayoutInflater minflater;
	Context mycontext;
	String locationAddress;
	public ParkingAreasAdapter(Context context, List<ParkingAreasType> items, String locationAddress) {
		 this.mycontext=context;
		 minflater =LayoutInflater.from(context);
		 locations = items;
		 this.locationAddress = locationAddress;
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
		ParkingAreasType parkingArea = (ParkingAreasType) getItem(position);

		if (parkingArea != null) {
			ImageView image = (ImageView)view.findViewById(R.id.image);
			TextView header = (TextView) view.findViewById(R.id.header);
			TextView content = (TextView) view.findViewById(R.id.content);
			
			
			if(Integer.parseInt(parkingArea.getAvailableSlots()) > 10){
				image.setImageResource(R.drawable.green);
			}
			else if(Integer.parseInt(parkingArea.getAvailableSlots()) < 10 && Integer.parseInt(parkingArea.getAvailableSlots()) > 0)
			{
				image.setImageResource(R.drawable.yellow);
			}
			else
				image.setImageResource(R.drawable.red);
			header.setText(parkingArea.getParkingAreaName());
			content.setText(parkingArea.getAvailableSlots()+" slots available in this parking area");
			

		}
		return view;
	}
}
