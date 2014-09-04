package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener, OnItemLongClickListener
{
	private ListView list;
	private MyAdapter myAdapter;
	private List<Movie> movies;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		movies = new ArrayList<Movie>();
		movies.add(new Movie("A Seperation", "Asghar Farhadi"));
		movies.add(new Movie("Terminator", "Jame Cameron"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		movies.add(new Movie("Misson :: Impossible 2", "Tom Cruies"));
		
		list = (ListView) findViewById(R.id.list);
		myAdapter = new MyAdapter(this, 0);
		myAdapter.setMovies(movies);
		
		list.setAdapter(myAdapter);
		
		list.setOnItemClickListener(this);
		//list.setOnItemLongClickListener(this);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		//Toast.makeText(this, "Position[" + position + "]|" +
		//			movies.get(position).getName() + "|" + movies.get(position).getDirector(), 3000).show();
		
		Intent intent = new Intent();
		intent.putExtra("movie_name", movies.get(position).getName());
		intent.putExtra("director_name", movies.get(position).getDirector());
		intent.setClass(this, AnotherActivity.class);
		
		startActivity(intent);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
	{
		Toast.makeText(this, "Long Click at Position[" + position + "]|" +
				movies.get(position).getName() + "|" + movies.get(position).getDirector(), 3000).show();
		return false;
	}
}
