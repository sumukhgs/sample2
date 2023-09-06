package testNGScripts;

import org.testng.annotations.Test;

import com.hopestar.GenericUtility.HopeStarBaseClass;

public class DisParalleExecution02TestScript extends HopeStarBaseClass {
	
	@Test
	public void crawl()
	{
		System.out.println("--baby likes to crawl--");
	}
	
	@Test
	public void run()
	{
		System.out.println("--boys like to run--");
	}
	
	@Test
	public void walk()
	{
		System.out.println("--old people like to walk--");
	}

}
