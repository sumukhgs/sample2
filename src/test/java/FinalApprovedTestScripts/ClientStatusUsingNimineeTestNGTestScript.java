package FinalApprovedTestScripts;

import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.NomineePage;

public class ClientStatusUsingNimineeTestNGTestScript extends HopeStarBaseClass {
	@Test(groups= {"smoke"})
	public void ClientStatusUsingNomineeLink() throws Throwable 
	{	
		// step:-02 click on nominee module
		HomePage hp=new HomePage(driver);
		hp.clickNominee();
		Thread.sleep(2000);
		
		// step:-03 click on client status hyperlink
		NomineePage np=new NomineePage(driver);
		np.ClickOnClientStatus();
		System.out.println("--Client Status page is visible--");
		Thread.sleep(1000);
	}
}
