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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commune other = (Commune)obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
}
