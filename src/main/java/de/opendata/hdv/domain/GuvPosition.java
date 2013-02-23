package de.opendata.hdv.domain;

import java.math.BigDecimal;

public class GuvPosition
{
	private final Integer verwaltungsForm;
	private final Commune gemeinde;
	private final Signature signatur;
	private final BigDecimal value;

	public GuvPosition(Integer verwaltungsForm, Commune gemeinde, Signature signatur, BigDecimal value)
	{
		this.verwaltungsForm = verwaltungsForm;
		this.gemeinde = gemeinde;
		this.signatur = signatur;
		this.value = value;
	}

	public Integer getVerwaltungsForm()
	{
		return verwaltungsForm;
	}

	public Commune getGemeinde()
	{
		return gemeinde;
	}

	public Signature getSignatur()
	{
		return signatur;
	}

	public BigDecimal getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return "GuvPosition [verwaltungsForm=" + verwaltungsForm + ", gemeinde=" + gemeinde + ", signatur=" + signatur
				+ ", value=" + value + "]";
	}
}
