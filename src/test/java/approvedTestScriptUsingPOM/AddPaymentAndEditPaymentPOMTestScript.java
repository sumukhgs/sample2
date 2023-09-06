package approvedTestScriptUsingPOM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.AddPaymentPage;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.InsertAllSuccessPage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.PaymentPage;
import testNGScripts.DataProviderclassss;
import testNGScripts.HopeStarDataProviderTestScript;

//@Test(dataProviderClass = HopeStarDataProviderTestScript.class, dataProvider="data1")
public class AddPaymentAndEditPaymentPOMTestScript {
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

		//step:-02 click on payment module
		HomePage hp=new HomePage(driver);
		hp.clickPayment();
		Thread.sleep(1500);
		PaymentPage pp=new PaymentPage(driver);
		pp.ClickOnAddPaymentBtn();
		
		eLib.getMultipleDataFromExcel("Add paymentclient",0, 1, driver);
		Thread.sleep(1000);
        AddPaymentPage app=new AddPaymentPage(driver);
        app.ClickOnsubmitBtn();
        Thread.sleep(1000);
        
        InsertAllSuccessPage asp=new InsertAllSuccessPage(driver);
        asp.InsertSuccessTextBox();
//        {
//        	System.out.println("validated , success page is visible");
//        }
//        else
//        {
//        	System.out.println("success page is not visible");
//        }
        
        //step:-05 click on client module
        asp.ClickOnClientLink();
        Thread.sleep(1000);
        
        //step:-06 click on client status hyperlink
        ClientPage cp=new ClientPage(driver);
        cp.ClickOnClientStatusLink();
        Thread.sleep(1000);
        
        //step:-07 logout the application
        EditClientStatusPage csp=new EditClientStatusPage(driver);
        csp.Logout();
        Thread.sleep(2000);
              
        //step:-08 close the window
        driver.quit();
        
        
        
	    
	    
		
		
	}

}
