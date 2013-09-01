package com.example.mock.location.from.picture;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final String providerName = "MyFancyGPSProvider";
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		//Remember to remove your your provider before using it or after.
		//In other case it won't be remove till restarting the phone.
		if (locationManager.getProvider(providerName) != null) {
		    locationManager.removeTestProvider(providerName);
		}
		locationManager.addTestProvider(providerName, true, false, false, false, true, true, true,
		                               Criteria.POWER_LOW, Criteria.ACCURACY_FINE);
		Location loc = new Location(LocationManager.GPS_PROVIDER);
		loc.setLongitude(13);
		loc.setTime(System.currentTimeMillis());
		loc.setLatitude(10);
		locationManager.setTestProviderLocation(providerName, loc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
