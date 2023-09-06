package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.AddClientPage;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;

public class AddNewClientPOMTestScript  {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");

		WebDriver driver = wLib.launchBrowser(URL);
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);

		//step:-01 login to application using credentials
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);

		//step:-02 click on client module
		HomePage hp=new HomePage(driver);
		hp.clickClient();
		Thread.sleep(1000);
		
		//step:-03 click on add client button
		ClientPage cp=new ClientPage(driver);
		cp.ClickAddClient();

		//step:-04 Enter the client details
		eLib.getMultipleDataFromExcel("Sheet1", 0,1, driver);
		Thread.sleep(2000);

		AddClientPage acp=new AddClientPage(driver);
		acp.ClickSubmitBtn();
		Thread.sleep(2000);
		driver.quit();
	}
}
