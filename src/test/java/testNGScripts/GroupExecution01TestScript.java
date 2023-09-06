package testNGScripts;

import org.testng.annotations.Test;

public class GroupExecution01TestScript {
	
	@Test(groups="smoke")
	public void addMoney()
	{
		System.out.println("--add some money to account--");
	}
	
	@Test
	public void displayBalance()
	{
		System.out.println("--display  my balance--");
	}
	
	@Test(groups= {"regression","smoke"})
	public void withDrawal()
	{
		System.out.println("--remove monry from account--");
	}

}
