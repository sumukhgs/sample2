package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.JavaUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.EditClientDetailsOnlyPage;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.NomineePage;

public class EditClientViaNomineePOMTestScript {
public static void main(String[] args) throws Throwable {
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");
		
		WebDriver driver=wLib.launchBrowser(URL);
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);

		//step:-01 enter the valid credentials in login page
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		
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
		
//	    int phone = ju.getRandomNo();
//	    String val=Integer.toString(phone); 
		EditClientDetailsOnlyPage ecd=new EditClientDetailsOnlyPage(driver);
		ecd.UpdatePhoneNo();
		Thread.sleep(1500);
		
    	driver.quit();
		
		
		
		
	}


}
