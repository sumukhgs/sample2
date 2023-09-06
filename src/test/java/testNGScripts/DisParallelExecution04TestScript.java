package testNGScripts;

import org.testng.annotations.Test;

import com.hopestar.GenericUtility.HopeStarBaseClass;

public class DisParallelExecution04TestScript extends HopeStarBaseClass {
	
	@Test
	public void cow()
	{
		System.out.println("--cow is herbivorus--");
	}
	
	@Test
	public void tiger()
	{
		System.out.println("--tiger is carnivorus--");
	}

}
