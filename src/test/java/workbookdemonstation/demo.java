//test script to add payment to the client
package workbookdemonstation;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.AddPaymentPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;
import com.hopestar.POMPages.PaymentPage;

public class demo {
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
			
			LoginPage lp=new LoginPage(driver);
			lp.Login(USERNAME, PASSWORD);
			
			HomePage hp=new HomePage(driver);
			hp.clickPayment();
			
			PaymentPage pp=new PaymentPage(driver);
			pp.ClickOnAddPaymentBtn();
			
			HashMap<String, String> res = eLib.getMultipleDataFromExcel("Add paymentclient",0, 1, driver);
			
//			AddPaymentPage app=new AddPaymentPage(driver);
//		    app.EnterPaymentDetail(res, driver);
//			
//		    go to addpaymentpage in pom lib
//			 u will find the answer
//			
//			app.ClickOnsubmitBtn();
			
		}
        
        
	
}
