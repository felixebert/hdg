package de.opendata.hdv.domain;

import java.math.BigDecimal;

public class ErgebnisPosition
{
	private final Commune gemeinde;
	private final ProductGroup productGroup;
	private final BalanceAccount balanceAccount;
	private final BigDecimal value;

	public ErgebnisPosition(Commune gemeinde, ProductGroup productGroup, BalanceAccount balanceAccount, BigDecimal value)
	{
		this.gemeinde = gemeinde;
		this.productGroup = productGroup;
		this.balanceAccount = balanceAccount;
		this.value = value;
	}

	public Commune getCommune()
	{
		return gemeinde;
	}

	public ProductGroup getProductGroup()
	{
		return productGroup;
	}

	public BalanceAccount getBalanceAccount()
	{
		return balanceAccount;
	}

	public BigDecimal getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return "ErgebnisPosition [gemeinde=" + gemeinde + ", productGroup=" + productGroup + ", balanceAccount="
				+ balanceAccount + ", value=" + value + "]";
	}
}
