package com.example.listview;

public class Movie
{
	private String name, director;
	
	public Movie()
	{
		setName(null);
		setDirector(null);
	}
	
	public Movie(String name, String director)
	{
		setName(name);
		setDirector(director);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDirector()
	{
		return director;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}
}
