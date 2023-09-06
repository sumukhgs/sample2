package com.hopestar.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * this method is used to read data from properties file
	 * @param key
	 * @author Sumukh g s
	 * @return
	 * @throws Exception
	 */
	public String readDataFrompropertyfile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(IPathConstants.filepath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}
