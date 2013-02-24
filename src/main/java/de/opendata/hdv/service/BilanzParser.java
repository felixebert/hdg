package de.opendata.hdv.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.opendata.hdv.domain.BilanzPosition;
import de.opendata.hdv.domain.Commune;
import de.opendata.hdv.domain.Signature;

public class BilanzParser
{
	private final List<String[]> lines;

	public BilanzParser(List<String[]> lines)
	{
		this.lines = lines;
	}

	public Set<BilanzPosition> parsePositions()
	{
		Set<BilanzPosition> positions = new LinkedHashSet<>();
		for (String[] line : lines)
		{
			BilanzPosition position = parseLine(line);
			positions.add(position);
		}
		return Collections.unmodifiableSet(positions);
	}

	private BilanzPosition parseLine(String[] line)
	{
		Commune gemeinde = new Commune(line[0], line[2], Integer.valueOf(line[1]));
		Signature signatur = new Signature(line[3], line[4]);
		BigDecimal value = new BigDecimal(line[5]);
		return new BilanzPosition(gemeinde, signatur, value);
	}
}
