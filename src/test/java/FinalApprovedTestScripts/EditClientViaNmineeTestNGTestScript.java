package FinalApprovedTestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.EditClientDetailsOnlyPage;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.NomineePage;

//@Listeners(com.hopestar.GenericUtility.ListenerImplimentationClass.class)
public class EditClientViaNmineeTestNGTestScript extends HopeStarBaseClass {
	@Test(groups= {"regression"})
	public void EditClientViaNominee() throws Throwable
	{
				//step:-02 click on nominee module
				HomePage hp=new HomePage(driver);
				hp.clickNominee();
				Thread.sleep(1500);
				
				//step:-03 click on client status hyperlink
				NomineePage np=new NomineePage(driver);
				np.ClickOnClientStatus();
				Thread.sleep(1500);
				
				//step:-04 click on edit option present in client information page
				EditClientStatusPage csp=new EditClientStatusPage(driver);
				csp.EditClient();
				Thread.sleep(1500);
				
				EditClientDetailsOnlyPage ecd=new EditClientDetailsOnlyPage(driver);
				ecd.UpdatePhoneNo();
				System.out.println("--Phone Number Updated Successfully --");
				Thread.sleep(1500);		
			}
}
