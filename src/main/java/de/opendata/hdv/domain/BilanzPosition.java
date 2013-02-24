package de.opendata.hdv.domain;

import java.math.BigDecimal;

public class BilanzPosition
{
	private final Commune gemeinde;
	private final Signature signatur;
	private final BigDecimal value;

	public BilanzPosition(Commune gemeinde, Signature signatur, BigDecimal value)
	{
		this.gemeinde = gemeinde;
		this.signatur = signatur;
		this.value = value;
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
		return "BilanzPosition [gemeinde=" + gemeinde + ", signatur=" + signatur + ", value=" + value + "]";
	}
}
