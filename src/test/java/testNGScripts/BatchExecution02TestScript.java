package testNGScripts;

import org.testng.annotations.Test;

import com.hopestar.GenericUtility.HopeStarBaseClass;

public class BatchExecution02TestScript extends HopeStarBaseClass {
	
	@Test
	public void addAgent()
	{
		System.out.println("--New Agent Added--");
	}
	
	@Test
	public void modifyAgent()
	{
		System.out.println("--Modify the Agent details--");
	}
	
	@Test
	public void deleteAgent()
	{
		System.out.println("--Delete the Agent From List--");
	}


}
