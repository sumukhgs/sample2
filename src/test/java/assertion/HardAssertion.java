package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class HardAssertion {
	

	public void HardAssert() {
		System.out.println("--Step-01--");
		System.out.println("--Step-02--");
		Assert.assertEquals(true,true);
		System.out.println("--Step-03--");
		System.out.println("--Step-04--");
		Assert.fail("check updates"); // to purposely failing the flow so that the next lines wont execute
		System.out.println("--Step-09--");
		System.out.println("--Step-10--");
	}
	
	@Test
	public void HardAssert2() {
		System.out.println("--Step-05--");
		System.out.println("--Step-06--");
		Assert.assertEquals("a","A"); // both are not equal so assertion fails 
		System.out.println("--Step-07--");
		System.out.println("--Step-08--");
		
	}
	
	@Test
	public void HardAssert3() {
		System.out.println("--Step-21--");
		System.out.println("--Step-22--");
		Assert.assertTrue(true);
		System.out.println("--Step-23--");
		System.out.println("--Step-24--");
	}
}
