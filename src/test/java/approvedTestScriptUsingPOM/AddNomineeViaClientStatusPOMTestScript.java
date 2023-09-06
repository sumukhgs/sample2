package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.AddNomineePage;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.InsertAllSuccessPage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.NomineePage;

public class AddNomineeViaClientStatusPOMTestScript {
	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");
			
		WebDriver driver = wLib.launchBrowser(URL);
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);
			
		//step:-01 enter the valid credentials in login page
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		Thread.sleep(1500);
			
		//step:-02 click on client module
		HomePage hp=new HomePage(driver);
		hp.clickClient();
		Thread.sleep(2000);
			
		//step:-03 click on client status id
		ClientPage cp=new ClientPage(driver);
		cp.ClickOnClientStatusLink();
		Thread.sleep(2000);
			
		//step:-04 click on add nominee link of particular client
		EditClientStatusPage ecsp=new EditClientStatusPage(driver);
		ecsp.ClickOnAddNomineeLink();
		Thread.sleep(1500);
			
		//step:-05 add nominee details in add nominee page
		eLib.getMultipleDataFromExcel("nominee details", 0, 1, driver);
		Thread.sleep(1000);
		AddNomineePage anp=new AddNomineePage(driver);
		anp.ClickOnSubmitBtn();
		
		InsertAllSuccessPage insp=new InsertAllSuccessPage(driver);
		insp.InsertSuccessTextBox();
//		{
//			System.out.println("validated");	
//		}
//		else
//		{
//			System.out.println("not validated");
//		}
		Thread.sleep(2000);
			
		// step:-06 click back on nominee module
		insp.ClickOnNomineeLink();
		Thread.sleep(1000);
		//validation
		NomineePage np=new NomineePage(driver);
		np.Validation();
//		{
//			System.out.println("nominee is updated in the list");
//		}
//		else
//		{
//			System.out.println("nominee is not updated in the list");
//		}
		
	   //step:-06 logout the application
       np.ClickLogout();
       Thread.sleep(1000);
	        
	   //step:-07 close the window
	    driver.quit();			
	  }
}
