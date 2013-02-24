package de.opendata.hdv.service;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import de.opendata.hdv.domain.ErgebnisPosition;

public class ErgebnisParserTest
{
	@Test
	public void testParseGuvPositions()
	{
		ErgebnisParser parser = ParserFactory.createErgebnisParser("data/ergebnis2009.txt");
		Set<ErgebnisPosition> positions = parser.parsePositions();

		assertEquals(154783, positions.size());
	}

	@Test
	public void testParseGuvPosition()
	{
		ErgebnisParser parser = ParserFactory.createErgebnisParser("data/ergebnis2009.txt");
		Set<ErgebnisPosition> positions = parser.parsePositions();
		ErgebnisPosition position1 = positions.iterator().next();

		System.out.println(position1);
		assertEquals(1, position1.getGemeinde().getVerwaltungsForm().intValue());
	}
}
