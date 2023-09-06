package dataBaseTestScripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class DemoDBTestscript {
	public static void main(String[] args) throws Exception {
		
		Driver jdriver = new Driver();
		DriverManager.registerDriver(jdriver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/org","root","root");
		Statement stat= connection.createStatement();
		String 	SelectQuery ="SELECT * FROM testyantra";
		String udata="insert into testyantra values('komal', 4,'kiran',5,7890)";
		ResultSet result = stat.executeQuery(SelectQuery);
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3)+" "+result.getInt(4)+" "+result.getInt(5));
		}
			
		int result1 = stat.executeUpdate(udata);
		if(result1==1) {
			System.out.println("data updated ");
		}
		else {
			System.out.println("data not updated ");
		}
		
			connection.close();
			
		}

	}


