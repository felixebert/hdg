package de.opendata.hdv.domain;

public class Commune
{
	private final String id;
	private final String name;
	private final Integer verwaltungsForm;

	public Commune(String id, String name, Integer verwaltungsForm)
	{
		this.id = id;
		this.name = name;
		this.verwaltungsForm = verwaltungsForm;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Integer getVerwaltungsForm()
	{
		return verwaltungsForm;
	}

	@Override
	public String toString()
	{
		return "Commune [id=" + id + ", name=" + name + ", verwaltungsForm=" + verwaltungsForm + "]";
	}
}
