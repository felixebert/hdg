package de.opendata.hdv.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ParserFactoryTest
{
	@Test
	public void testCreateParser()
	{
		BilanzParser parser = ParserFactory.createBilanzParser("data/bilanz.txt");
		assertNotNull(parser);
	}
}
