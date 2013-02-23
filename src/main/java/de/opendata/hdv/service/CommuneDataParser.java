package de.opendata.hdv.service;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import de.opendata.hdv.domain.Commune;
import de.opendata.hdv.domain.CommuneData;

public class CommuneDataParser
{
	private static final Logger log = Logger.getLogger(CommuneDataParser.class.getName());
	private final List<String[]> lines;

	public CommuneDataParser(List<String[]> lines)
	{
		this.lines = lines;
	}

	public Set<CommuneData> parseCommuneDatas()
	{
		Set<CommuneData> communeDataList = new LinkedHashSet<>();
		for (String[] line : lines)
		{
			CommuneData position = parseLine(line);
			if (position != null)
			{
				communeDataList.add(position);
			}
		}
		return Collections.unmodifiableSet(communeDataList);
	}

	private CommuneData parseLine(String[] line)
	{
		try
		{
			Integer populationTotal = Integer.valueOf(StringUtils.trim(line[9]));
			Commune commune = new Commune(line[0], line[7]);
			return new CommuneData(populationTotal, commune);
		}
		catch (Exception e)
		{
			log.error(line[7] + " - " + line[9]);
			return null;
		}
	}
}
