package FinalApprovedTestScripts;

import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.AddPaymentPage;
import com.hopestar.POMPages.AgentPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.InsertAllSuccessPage;
import com.hopestar.POMPages.PaymentPage;

public class AddPaymentUsingAgentIDTestNGTestScript extends HopeStarBaseClass {
	@Test(groups= {"regression"})
	public void AddPaymentUsingAgentID() throws Throwable
	{
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
				elib.getMultipleDataFromExcel("Add paymentclient", 0,1, driver);
				Thread.sleep(2000);
				
				AddPaymentPage app=new AddPaymentPage(driver);
				app.ClickOnsubmitBtn();
		        
				InsertAllSuccessPage asp=new InsertAllSuccessPage(driver);
				asp.InsertSuccessTextBox();
//				{
//					System.out.println("success text box is visible");
//				}
//				else
//				{
//					System.out.println("success text box is not visible");
//				}
				
				//step-06 click on payment module
				asp.ClickOnPaymentLink();
				Thread.sleep(1500);
		  }
}
