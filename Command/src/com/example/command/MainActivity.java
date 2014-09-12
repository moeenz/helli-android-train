package com.example.command;

import java.io.DataOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/**/
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
	
	public Boolean execCommands(String... command)
	{
	    try
	    {
	        Runtime rt = Runtime.getRuntime();
	        Process process = rt.exec("su");
	        DataOutputStream os = new DataOutputStream(process.getOutputStream());

	        for(int i = 0; i < command.length; i++)
	        {
	            os.writeBytes(command[i] + "\n");
	            os.flush();
	        }
	        
	        os.writeBytes("exit\n");
	        os.flush();
	        process.waitFor();
	    }
	    catch (IOException e)
	    {
	        return false;
	    }
	    catch (InterruptedException e)
	    {
	        return false;
	    }
	    
	    return true; 
	}
}
