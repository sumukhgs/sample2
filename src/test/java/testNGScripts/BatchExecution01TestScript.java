package testNGScripts;

import org.testng.annotations.Test;

import com.hopestar.GenericUtility.HopeStarBaseClass;

public class BatchExecution01TestScript extends HopeStarBaseClass{
	
	@Test
	public void addClient()
	{
		System.out.println("--New Client Added--");
	}
	
	@Test
	public void modifyClient()
	{
		System.out.println("--Modify the Client details--");
	}
	
	@Test
	public void deleteClient()
	{
		System.out.println("--Delete the Client From List--");
	}

}
