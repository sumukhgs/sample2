package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.AddPaymentPage;
import com.hopestar.POMPages.AgentPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.InsertAllSuccessPage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.PaymentPage;

public class AddPaymentUsingAgentIDPOMTestScript {
public static void main(String[] args) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
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
		Thread.sleep(1000);
		
		//step:-02 click on agents module
		HomePage hp=new HomePage(driver);
		hp.clickAgent();
		Thread.sleep(1500);
		
		//step:-03 click on payments module
		AgentPage ap=new AgentPage(driver);
		ap.ClickOnPaymentLink();
		Thread.sleep(1500);
		
		//step:-04 click on add payment button
		PaymentPage pp=new PaymentPage(driver);
		pp.ClickOnAddPaymentBtn();
		Thread.sleep(1500);
		
		//step:-05 enter the data in text fields of payment 
		eLib.getMultipleDataFromExcel("Add paymentclient", 0,1, driver);
		Thread.sleep(2000);
		
		AddPaymentPage app=new AddPaymentPage(driver);
		app.ClickOnsubmitBtn();
        
		InsertAllSuccessPage asp=new InsertAllSuccessPage(driver);
		asp.InsertSuccessTextBox();
//		{
//			System.out.println("success text box is visible");
//		}
//		else
//		{
//			System.out.println("success text box is not visible");
//		}
		
		//step-06 click on payment module
		asp.ClickOnPaymentLink();
		Thread.sleep(1500);
		
	    //step-07 close the window
		driver.quit();
  }


}
