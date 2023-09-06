package selfPractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Trick04 {
	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/hopestar", "root","root");
		Statement state = con.createStatement();
		String q="select * from agent;";
		ResultSet ans = state.executeQuery(q);
		
		while(ans.next())
		{
			System.out.println(ans.getString(2)+"\t"+ans.getInt(1)+"\t"+ans.getInt(3));
		}
	
		
		Statement s2 = con.createStatement();
		String query="insert into agent values(8,'reddy',5647);";
		int demo = s2.executeUpdate(query);
		System.out.println(demo);
		
		if(demo>0)
		{
			System.out.println("successfull");
		}
		else
		{
			System.out.println("not successfull");
		}
			
	}
	

}
