package com.example.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener
{
	private final int REFRESH_INTERVAL_GPS = 250;
	private final int REFRESH_INTERVAL_NETWORK = 400;
	
	private TextView latitude, longitude;
	
	private Location location;
	private LocationManager locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		latitude = (TextView) findViewById(R.id.latitude);
		longitude = (TextView) findViewById(R.id.longitude);
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, REFRESH_INTERVAL_GPS, 0, this );
		//locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, REFRESH_INTERVAL_NETWORK, 0, this );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLocationChanged(Location location)
	{
		if( location != null )
		{
			setLocation(location);
			longitude.setText("Longitude: " + getLocation().getLongitude());
			latitude.setText("Latitude: " + getLocation().getLatitude());
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras)
	{
		
	}

	@Override
	public void onProviderEnabled(String provider)
	{
		
	}

	@Override
	public void onProviderDisabled(String provider)
	{
		
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}
}
