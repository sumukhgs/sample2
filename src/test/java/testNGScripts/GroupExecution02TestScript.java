package testNGScripts;

import org.testng.annotations.Test;

public class GroupExecution02TestScript {
	
	@Test(groups="regression")
	public void prepareFood()
	{
		System.out.println("-- some food is being prepared--");
	}
	
	@Test(groups = "smoke")
	public void cooking()
	{
		System.out.println("--cooking process is going on--");
	}
	
	@Test
	public void serveFoodl()
	{
		System.out.println("--serve the cooked food --");
	}

}
