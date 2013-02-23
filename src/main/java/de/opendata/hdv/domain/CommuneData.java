package de.opendata.hdv.domain;

public class CommuneData
{
	private final Integer populationTotal;
	private final Commune commune;

	public CommuneData(Integer populationTotal, Commune commune)
	{
		this.populationTotal = populationTotal;
		this.commune = commune;
	}

	public Integer getPopulationTotal()
	{
		return populationTotal;
	}

	public Commune getCommune()
	{
		return commune;
	}

	@Override
	public String toString()
	{
		return "CommuneData [populationTotal=" + populationTotal + ", commune=" + commune + "]";
	}
}
