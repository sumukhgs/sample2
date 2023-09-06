package FinalApprovedTestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.AddPaymentPage;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.InsertAllSuccessPage;
import com.hopestar.POMPages.PaymentPage;
//@Listeners(com.hopestar.GenericUtility.ListenerImplimentationClass.class)
public class AddPaymentAndEditTestNGTestscript extends HopeStarBaseClass {
	
	//  @Test(retryAnalyzer = com.hopestar.GenericUtility.IRetryListenerImplementationClass.class)// use it when u need to use retryAnalyzer listener
	  @Test
      public  void AddPaymentAndEdit() throws Throwable
{
		//step:-02 click on payment module
		HomePage hp=new HomePage(driver);
		hp.clickPayment();
		Thread.sleep(1500);
		PaymentPage pp=new PaymentPage(driver);
		pp.ClickOnAddPaymentBtn();
		
		elib.getMultipleDataFromExcel("Add paymentclient",0, 1, driver);
		Thread.sleep(1000);
        AddPaymentPage app=new AddPaymentPage(driver);
        app.ClickOnsubmitBtn();
        Thread.sleep(1000);
     //   Assert.fail();// to check retryAnalyzer keep it on 
       // Assert.fail();//to purposly fail the test to try iTestListener 
        InsertAllSuccessPage asp=new InsertAllSuccessPage(driver);
        asp.InsertSuccessTextBox();
        
        //step:-05 click on client module
        asp.ClickOnClientLink();
        Thread.sleep(1000);
        
        //step:-06 click on client status hyperlink
        ClientPage cp=new ClientPage(driver);
        cp.ClickOnClientStatusLink();
        Thread.sleep(1000);
	}

}
