package testNGScripts;

import org.testng.annotations.Test;

import com.hopestar.GenericUtility.HopeStarBaseClass;

public class ExtendedToBaseClassDemo  extends HopeStarBaseClass{
	
	@Test
	public void Run1()
	{
		System.out.println("--test named Run1 is executed--");
	}
	
	@Test
	public void Run2()
	{
		System.out.println("--welcome to second test named run2--");
	}

}
