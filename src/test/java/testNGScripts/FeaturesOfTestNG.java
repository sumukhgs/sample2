//the suit demonstrates of one pass,one fail and one skip
package testNGScripts;

import org.testng.annotations.Test;

public class FeaturesOfTestNG {
	//this method is skipped because it is depended on method DeleteData
	@Test(dependsOnMethods="DeleteData")
	public void CreateData()
	{
		System.out.println("data should br created");
	}
	
	//this method is successfull
	@Test
	public void EditData()
	{
		System.out.println("data must be edited");
	}
	
	// this method is failure because it is causing exception 
	@Test()
	public void DeleteData()
	{
		int x=1/0;
		System.out.println(x);
		System.out.println("data must be deleted after use");
	}

}
