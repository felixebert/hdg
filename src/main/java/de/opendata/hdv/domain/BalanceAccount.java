package de.opendata.hdv.domain;

public class BalanceAccount
{
	private final Integer nr;
	private final String name;

	public BalanceAccount(Integer nr, String name)
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
		return "Konto [nr=" + nr + ", name=" + name + "]";
	}
}
