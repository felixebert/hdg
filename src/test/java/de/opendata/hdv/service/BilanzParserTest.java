package de.opendata.hdv.service;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import de.opendata.hdv.domain.GuvPosition;

public class BilanzParserTest
{
	@Test
	public void testParseGuvPositions()
	{
		BilanzParser parser = ParserFactory.createBilanzParser("data/bilanz.txt");
		Set<GuvPosition> guvPositions = parser.parseGuvPositions();

		assertEquals(86618, guvPositions.size());
	}

	@Test
	public void testParseGuvPosition()
	{
		BilanzParser parser = ParserFactory.createBilanzParser("data/bilanz.txt");
		Set<GuvPosition> guvPositions = parser.parseGuvPositions();
		GuvPosition position1 = guvPositions.iterator().next();

		System.out.println(position1);
		assertEquals(1, position1.getVerwaltungsForm().intValue());
	}
}
