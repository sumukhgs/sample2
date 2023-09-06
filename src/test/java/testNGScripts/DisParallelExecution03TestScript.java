package testNGScripts;

import org.testng.annotations.Test;

import com.hopestar.GenericUtility.HopeStarBaseClass;

public class DisParallelExecution03TestScript extends HopeStarBaseClass {
	
	@Test
	public void gun()
	{
		System.out.println("--gun is used to fire bullet--");
	}
	
	@Test
	public void bun()
	{
		System.out.println("--bun is used to eat--");
	}

}
