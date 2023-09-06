package com.hopestar.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	
	/**
	 * this method is used to connect to the database
	 * @author Sumukh g s
	 * @return 
	 * @throws Throwable
	 */
	public Connection connectToDB()throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbusername,IPathConstants.dbpassword);
		return con;
	}
	
	/**
	 * this method is used to execute the query and return the data
	 * @author Sumukh g s
	 * @param query
	 * @param columnNo
	 * @param ExpData
	 * @return
	 * @throws Exception
	 */
	
	public String executeQueryAndGetData(String query,int columnNo,String ExpData) throws Exception
	{
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actualData=result.getString(columnNo);
			if(actualData.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data verified");
			return ExpData;
		}
		else
		{
			System.out.println("data invalid");
			return "";
		}
	}
	
	/**
	 * this method is used to close the database connection
	 *@author Sumukh g s
	 * @throws Exception
	 */
	public void closeDB() throws Exception
	{
		con.close();
		
	}

}
