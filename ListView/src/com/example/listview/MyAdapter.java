package com.example.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Movie>
{
	private List<Movie> movies;
	private Context context;
	
	public MyAdapter(Context context, int textViewResourceId)
	{
		super(context, textViewResourceId);
		this.context = context;
	}
	
	@Override
	public int getCount()
	{
		return getMovies().size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View v = null;
		LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.list_item, null);
		
		TextView name = (TextView) v.findViewById(R.id.name);
		TextView director = (TextView) v.findViewById(R.id.director);
		
		name.setText(getMovies().get(position).getName());
		director.setText(getMovies().get(position).getDirector());
	
		return v;
	}

	public List<Movie> getMovies()
	{
		return movies;
	}

	public void setMovies(List<Movie> movies)
	{
		this.movies = movies;
	}
}
