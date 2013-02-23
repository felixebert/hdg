package de.opendata.hdv.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;
import de.opendata.hdv.util.ResourceUtils;

public class ParserFactory
{
	private static final Logger log = Logger.getLogger(ParserFactory.class.getName());

	public static BilanzParser createBilanzParser(String filename)
	{
		return new BilanzParser(getLines(filename));
	}

	public static CommuneDataParser createCommuneDataParser(String filename)
	{
		return new CommuneDataParser(getLines(filename));
	}

	private static List<String[]> getLines(String filename)
	{
		CSVReader reader = null;
		try
		{
			reader = new CSVReader(new FileReader(ResourceUtils.getResource(filename)), ';');
			return reader.readAll();
		}
		catch (Exception e)
		{
			log.error(e);
			return Collections.emptyList();
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					log.error(e);
				}
			}
		}
	}
}
