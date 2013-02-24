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
		assertEquals(11296, communeDataList.size());
	}

	@Test
	public void testParseCommuneData()
	{
		CommuneDataParser parser = ParserFactory.createCommuneDataParser("data/communedata.txt");
		Set<CommuneData> communeData = parser.parseCommuneDatas();
		CommuneData communeData1 = communeData.iterator().next();

		assertEquals("Flensburg, Stadt", communeData1.getCommune().getName());
		assertEquals("010010000", communeData1.getCommune().getId());
		assertEquals(89357, communeData1.getPopulationTotal().intValue());
	}
}
