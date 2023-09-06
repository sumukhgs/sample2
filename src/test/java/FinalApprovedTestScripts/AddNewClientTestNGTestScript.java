package FinalApprovedTestScripts;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.AddClientPage;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.HomePage;
//@Listeners(com.hopestar.GenericUtility.IListenerImpliClassToGenerateReport.class)// to generate the html report we have to un-comment it 
public class AddNewClientTestNGTestScript extends HopeStarBaseClass{
	
	@Test(groups={"smoke"})
	public void AddNewClient() throws Throwable
	{
		//step:-02 click on client module
		HomePage hp=new HomePage(driver);
		hp.clickClient();
		Thread.sleep(1000);
		
		//step:-03 click on add client button
		ClientPage cp=new ClientPage(driver);
		cp.ClickAddClient();
		//fail();  // uncomment it while using to generate the html report

		//step:-04 Enter the client details
		elib.getMultipleDataFromExcel("Sheet1", 0,1, driver);
		Thread.sleep(2000);

		AddClientPage acp=new AddClientPage(driver);
		acp.ClickSubmitBtn();	
	}
}
