package FinalApprovedTestScripts;

import org.testng.annotations.Test;
import com.hopestar.GenericUtility.HopeStarBaseClass;
import com.hopestar.POMPages.AddNomineePage;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.EditClientStatusPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.InsertAllSuccessPage;
import com.hopestar.POMPages.NomineePage;

public class AddNomineeViaClientTestNGTestScript extends HopeStarBaseClass {
	
	@Test(groups= {"regression"})
	public void AddNomineeViaClient() throws Throwable
	{	
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
		elib.getMultipleDataFromExcel("nominee details", 0, 1, driver);
		Thread.sleep(1000);
		AddNomineePage anp=new AddNomineePage(driver);
		anp.ClickOnSubmitBtn();
		
		InsertAllSuccessPage insp=new InsertAllSuccessPage(driver);
		insp.InsertSuccessTextBox();
		Thread.sleep(2000);
			
		// step:-06 click back on nominee module
		insp.ClickOnNomineeLink();
		Thread.sleep(1000);
		//validation
		NomineePage np=new NomineePage(driver);
		np.Validation();
		
		
	  }
}
