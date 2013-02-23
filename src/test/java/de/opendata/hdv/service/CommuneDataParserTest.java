package de.opendata.hdv.service;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import de.opendata.hdv.domain.CommuneData;

public class CommuneDataParserTest
{
	@Test
	public void testParseCommuneDataList()
	{
		CommuneDataParser parser = ParserFactory.createCommuneDataParser("data/communedata.txt");
		Set<CommuneData> communeDataList = parser.parseCommuneDatas();
		assertEquals(4164, communeDataList.size());
	}

	@Test
	public void testParseCommuneData()
	{
		CommuneDataParser parser = ParserFactory.createCommuneDataParser("data/communedata.txt");
		Set<CommuneData> communeData = parser.parseCommuneDatas();
		CommuneData communeData1 = communeData.iterator().next();
	}
}
