package de.opendata.hdv.domain;

public class Commune
{
	private final String id;
	private final String name;

	public Commune(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getid()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return "Gemeinde [id=" + id + ", name=" + name + "]";
	}
}
