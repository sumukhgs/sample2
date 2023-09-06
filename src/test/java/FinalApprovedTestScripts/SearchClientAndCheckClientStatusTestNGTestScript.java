package FinalApprovedTestScripts;

import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.SearchResultPage;

public class SearchClientAndCheckClientStatusTestNGTestScript extends HopeStarBaseClass {
	@Test(groups= {"regression"})
	public void SearchClientAndCheckClientStatusViaNominee() throws Throwable
	{
    
		//step:-02 click on search field and enter the data in text field and press search button
	    HomePage hp=new HomePage(driver);
	    int ans=1511987599;
	    String val=Integer.toString(ans);
	    hp.search(val);
		
		//step:-03 click on client status link
		Thread.sleep(1500);
		SearchResultPage srp=new SearchResultPage(driver);
		srp.ClickOnCCL();
		
		//step:-04 to verify the client page is opening or not 
		EditClientStatusPage csp=new EditClientStatusPage(driver);
		if(csp.PageHeader())
		{
			System.out.println("client status page is visible");
		}
		else
		{
			System.out.println("client status page is not visible");
		}
        Thread.sleep(1500);
    }
}
