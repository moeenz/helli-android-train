package com.example.gesturedetector;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private String longPressDetected = null;
	private String detectedGesture = null;
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gestureDetector = new GestureDetector(this, new GestureListener());
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		boolean eventConsumed = gestureDetector.onTouchEvent(event);
		if (eventConsumed)
        {
			if( longPressDetected != null )
			{
				Toast.makeText(this, longPressDetected, Toast.LENGTH_LONG).show();
				longPressDetected = null;
			}
			
            return true;
        }
        else
        {
        	return false;
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class GestureListener extends GestureDetector.SimpleOnGestureListener
	{
		@Override
		public boolean onSingleTapUp(MotionEvent e)
		{
			detectedGesture = e.toString();
			
			return true;
		}
		
		@Override
		public void onShowPress(MotionEvent e)
		{
			detectedGesture = e.toString();
		}
		
		@Override
		public void onLongPress(MotionEvent e)
		{
			detectedGesture = e.toString();
			longPressDetected = "LONG PRESSED" + e.getPressure();
		}
		
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
		{
			detectedGesture = e1.toString() + "||" + e2.toString();
			
			return true;
		}
		
		@Override
		public boolean onDown(MotionEvent e)
		{
			detectedGesture = e.toString();
			
			return true;
		}
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,	float velocityY)
		{
			detectedGesture = e1.toString() + "||" + e2.toString();
			
			return true;
		}
	}
}
