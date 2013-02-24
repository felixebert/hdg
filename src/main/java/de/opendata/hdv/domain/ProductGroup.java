package de.opendata.hdv.domain;

public class ProductGroup
{
	private final Integer nr;
	private final String name;

	public ProductGroup(Integer nr, String name)
	{
		this.nr = nr;
		this.name = name;
	}

	public Integer getNr()
	{
		return nr;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return "ProductGroup [nr=" + nr + ", name=" + name + "]";
	}
}
