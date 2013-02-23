package de.opendata.hdv.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ClassUtils;

public class ResourceUtils
{
	public static File getResource(String filename)
	{
		URL url = ClassUtils.getDefaultClassLoader().getResource(filename);
		try
		{
			return new File(url.toURI());
		}
		catch (URISyntaxException e)
		{
			throw new IllegalStateException(e);
		}
	}

	public static String getResourceAsString(String filename)
	{
		try
		{
			return FileUtils.readFileToString(getResource(filename));
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
