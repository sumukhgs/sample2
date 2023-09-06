package dataBaseTestScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hopestar.GenericUtility.IPathConstants;
import com.mysql.cj.jdbc.Driver;

public class SelectQueryDataBase {
	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
       Connection con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbusername,IPathConstants.dbpassword);
       Statement state = con.createStatement();
       String query="select * from Agent;";
       ResultSet answer = state.executeQuery(query);
       while(answer.next())
       {
    	   System.out.println(answer.getString(2));
       }
	}
	
	

}
