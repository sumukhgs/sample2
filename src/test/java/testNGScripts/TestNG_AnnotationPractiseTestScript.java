package testNGScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hopestar.GenericUtility.DataBaseUtility;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;
import com.hopestar.POMPages.ClientPage;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;

public class TestNG_AnnotationPractiseTestScript {
	DataBaseUtility dlib=new DataBaseUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	ExcelUtility elib=new ExcelUtility();
	FileUtility flib=new FileUtility();
	WebDriver driver=null;
	@BeforeSuite
	public void configure_BS() throws Throwable
	{
		dlib.connectToDB();
		System.out.println("--Database connection is established--");
	}
	
	@BeforeClass
	public void Configure_BC() throws Throwable
	{
		//String BROWSER=flib.readDataFrompropertyfile("browser");
		String URL=flib.readDataFrompropertyfile("url");
		driver = wlib.launchBrowser(URL);
		System.out.println("--Browser is opened -- ");
		
	}
	
	@BeforeMethod
	public void Configure_BM() throws Exception
	{
		String USERNAME=flib.readDataFrompropertyfile("username");
		String PASSWORD=flib.readDataFrompropertyfile("password");
		LoginPage  lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		System.out.println("--login to Application--");
	}
	
	@Test
	public void Run_Test()
	{
		
		HomePage hp=new HomePage(driver);
		hp.clickClient();
		System.out.println("--test run successfull--");
	}
	
	@AfterMethod
	public void Configure_AM()
	{
		ClientPage cp=new ClientPage(driver);
		cp.Logout();
		System.out.println("--logout from application--");
	}
	
	@AfterClass
	public void Configure_AC()
	{
		driver.quit();
		System.out.println("--closed the Browser--");
	}
	
	@AfterSuite
	public void configure_AS() throws Throwable
	{
		dlib.closeDB();
		System.out.println("--Database Connection Closed--");
	}

}
