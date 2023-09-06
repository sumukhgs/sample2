package dataBaseTestScripts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hopestar.GenericUtility.DataBaseUtility;

public class demo {
	public static void main(String[] args) throws Throwable {
		DataBaseUtility dLib=new DataBaseUtility();
		Connection con = dLib.connectToDB();
		Statement state = con.createStatement();
		String que="insert into agent values(10,'kishan',3456);";
		int result = state.executeUpdate(que);
		if(result>=1) {
			System.out.println("update ");
		}
		else
		{
			System.out.println("not updated");
		}
	
	}

}
