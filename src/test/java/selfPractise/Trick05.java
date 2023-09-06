package selfPractise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hopestar.GenericUtility.DataBaseUtility;

public class Trick05 {
public static void main(String[] args) throws Throwable {
	DataBaseUtility d=new DataBaseUtility();
	Connection con=null;
	con=d.connectToDB();
	Statement state = con.createStatement();
	String q="select * from agent;";
	ResultSet ans = state.executeQuery(q);
	while(ans.next())
	{
		System.out.println(ans.getString(2));
	}
}
}
