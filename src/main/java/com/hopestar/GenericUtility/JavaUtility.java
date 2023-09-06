package com.hopestar.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method is used to get  random number
	 * @author Sumukh g s
	 * @return
	 */
	
	public int getRandomNo() 
	{
		Random ran=new Random();
		int random=ran.nextInt(99999999);
		return random;
		
	}
	
	
	/**
	 * this method is used to get system date
	 * @author Sumukh g s
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	
	
	/**
	 * this method is used to get system date in format
	 * @author Sumukh g s
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy  hh-mm-ss");
		Date date=new Date();
		String systemDateInFormat=dateformat.format(date);
		return systemDateInFormat;
	}

}
