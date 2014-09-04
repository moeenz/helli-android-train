package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends Activity
{
	private TextView name, director;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);
		
		name = (TextView) findViewById(R.id.t_name);
		director = (TextView) findViewById(R.id.t_director);
		
		Intent intent = getIntent();
		
		name.setText( intent.getStringExtra("movie_name"));
		director.setText( intent.getStringExtra("director_name"));
	}

}
