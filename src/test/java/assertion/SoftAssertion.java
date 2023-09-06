package assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test(enabled = false)
	public void softAssert()
	{
		System.out.println("--step-01--");
		System.out.println("--step-02--");
		SoftAssert s=new SoftAssert();
		s.assertEquals(true, false);//in-case it is false also , it will execute the complete script
		System.out.println("--step-03--");
		System.out.println("--step-04--");
		s.assertAll();// the execution will be not interupted but by using this method we can display the exception msg at last , we have to use it last only
		
	}
	
	@Test
	public void nullCheck()
	{
		System.out.println("--step-01--");
		System.out.println("--step-02--");
		int s=30;
		SoftAssert sa=new SoftAssert();
		sa.assertNull(s); //checks  weather the parameter is null 
		sa.assertNotNull(s);// checks  weather the parameter  is not null
		System.out.println("--step-03--");
		System.out.println("--step-04--");
		sa.assertAll();// to display the exception msg we use the method
	}

}
