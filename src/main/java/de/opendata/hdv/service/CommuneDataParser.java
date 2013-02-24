package de.opendata.hdv.service;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import de.opendata.hdv.domain.Commune;
import de.opendata.hdv.domain.CommuneData;

public class CommuneDataParser
{
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
		String populationTotalString = line[9];
		if (!StringUtils.isEmpty(populationTotalString))
		{
			Integer populationTotal = Integer.valueOf(populationTotalString.replaceAll(" ", ""));
			String communeId = line[2] + line[3] + line[4] + line[5];
			Commune commune = new Commune(communeId, line[7], null);
			return new CommuneData(populationTotal, commune);
		}
		return null;
	}
}
