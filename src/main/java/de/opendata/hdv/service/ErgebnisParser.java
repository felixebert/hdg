package de.opendata.hdv.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.opendata.hdv.domain.BalanceAccount;
import de.opendata.hdv.domain.Commune;
import de.opendata.hdv.domain.ErgebnisPosition;
import de.opendata.hdv.domain.ProductGroup;

public class ErgebnisParser
{
	private final List<String[]> lines;

	public ErgebnisParser(List<String[]> lines)
	{
		this.lines = lines;
	}

	public Set<ErgebnisPosition> parsePositions()
	{
		Set<ErgebnisPosition> positions = new LinkedHashSet<>();
		for (String[] line : lines)
		{
			ErgebnisPosition position = parseLine(line);
			positions.add(position);
		}
		return Collections.unmodifiableSet(positions);
	}

	private ErgebnisPosition parseLine(String[] line)
	{
		Commune gemeinde = new Commune(line[0], line[2], Integer.valueOf(line[1]));
		ProductGroup productGroup = new ProductGroup(Integer.valueOf(line[3]), line[4]);
		BalanceAccount balanceAccount = new BalanceAccount(Integer.valueOf(line[5]), line[6]);
		BigDecimal value = new BigDecimal(line[7]);
		return new ErgebnisPosition(gemeinde, productGroup, balanceAccount, value);
	}
}
