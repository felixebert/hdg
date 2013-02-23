package de.opendata.hdv.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.opendata.hdv.domain.Commune;
import de.opendata.hdv.domain.GuvPosition;
import de.opendata.hdv.domain.Signature;

public class BilanzParser
{
	private final List<String[]> lines;

	public BilanzParser(List<String[]> lines)
	{
		this.lines = lines;
	}

	public Set<GuvPosition> parseGuvPositions()
	{
		Set<GuvPosition> positions = new LinkedHashSet<>();
		for (String[] line : lines)
		{
			GuvPosition position = parseLine(line);
			positions.add(position);
		}
		return Collections.unmodifiableSet(positions);
	}

	private GuvPosition parseLine(String[] line)
	{
		Integer verwaltungsForm = Integer.valueOf(line[1]);
		Commune gemeinde = new Commune(line[0], line[2]);
		Signature signatur = new Signature(line[3], line[4]);
		BigDecimal value = new BigDecimal(line[5]);
		return new GuvPosition(verwaltungsForm, gemeinde, signatur, value);
	}
}
