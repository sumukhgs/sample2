 package dataBaseTestScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;// cj wala we have to import

public class SelectQueryTestScript {
	public static void main(String[] args) throws Exception{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/hopestar", "root","root");
		Statement state=con.createStatement();
		String query="select * from agent;";
		
		ResultSet ans=state.executeQuery(query);
		
		while(ans.next())
		{
			System.out.println(ans.getString(1)+ " "+ans.getInt(2)+" "+ans.getString(3)+" "+ans.getInt(4)+" "+ans.getInt(5));
		}
		
		con.close();
	}

}
