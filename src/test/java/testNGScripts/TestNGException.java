package testNGScripts;

import org.testng.annotations.Test;

public class TestNGException {
	@Test(dependsOnMethods="Death")
	public void Birth() 
	{
		System.out.println("i am taking birth");
	}
	
	@Test
	public void Living() {
		System.out.println("i am living a good life");
	}
	
	@Test
	public void Death()
	{
		System.out.println("death is fixed in life");
	}
	
	@Test(dependsOnMethods="Birth")
	public void Afterdeath()
	{
		System.out.println("we will become stars");
	}

}
