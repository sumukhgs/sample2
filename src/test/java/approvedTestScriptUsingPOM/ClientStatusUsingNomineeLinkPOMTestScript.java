package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.NomineePage;

public class ClientStatusUsingNomineeLinkPOMTestScript {
        public static void main(String[] args) throws Exception {
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");		
		
		WebDriver driver = wLib.launchBrowser(URL);
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);
		
		// step:-01 login page- entering credentials to application to login page
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		Thread.sleep(1000);
		
		
		// step:-02 click on nominee module
		HomePage hp=new HomePage(driver);
		hp.clickNominee();
		Thread.sleep(2000);
		
		// step:-03 click on client status hyperlink
		NomineePage np=new NomineePage(driver);
		np.ClickOnClientStatus();
		Thread.sleep(1000);
		
		driver.quit();
		
	}


}
