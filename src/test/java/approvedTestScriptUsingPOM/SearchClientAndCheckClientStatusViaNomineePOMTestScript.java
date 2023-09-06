package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.SearchResultPage;

public class SearchClientAndCheckClientStatusViaNomineePOMTestScript {
        public static void main(String[] args) throws Exception {
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");
		
		WebDriver driver=wLib.launchBrowser(URL);
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);
		
		//step:-01 enter the valid credentials in login page
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
	    Thread.sleep(1500);
		
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
        
        csp.Logout();
        Thread.sleep(2000);
		
		//step:-05 close the window
		driver.quit();
	}


}
