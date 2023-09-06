package dataBaseTestScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTestScript {
	public static void main(String[] args) throws SQLException {
		
		//1] register the database
		Driver jdriver=new Driver();
		DriverManager.registerDriver(jdriver);
		
		//2]get connection to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/org", "root","root");
		
		//3] create statement
		Statement state=con.createStatement();
		String query="delete from testyantra where salary=5;";
		
		//4]execute the query
		int result=state.executeUpdate(query); // here the output will be in the form of integer type
		
		
		if(result>0)
		{
			System.out.println("update is successfull");
		}
		else
		{
			System.err.println("update is unsuccessfull");
		}
		
		//5]close the database connection
		con.close();
	}

}
