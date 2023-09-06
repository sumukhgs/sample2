package com.hopestar.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.hopestar.POMPages.HomePage;
import com.hopestar.POMPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HopeStarBaseClass {
	
	public WebDriverUtility wlib=new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	public FileUtility flib=new FileUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public  static WebDriver driver=null;
	//public static WebDriver sdriver;
	
	@BeforeSuite(groups ={"smoke","integration","regression"})
	public void configure_BS() throws Throwable
	{
		dlib.connectToDB();
		System.out.println("--Database connection is established--");
	}
	
	//uncomment the following line while using cross browser execution
	//@Parameters("BROWSER")
	@BeforeClass(groups ={"smoke","integration","regression"})
	public void Configure_BC() throws Throwable
	{
		String URL=flib.readDataFrompropertyfile("url");
		String BROWSER=flib.readDataFrompropertyfile("browser");
		// comment the above line only for Cross Browser Execution.
		if(BROWSER.equals("chrome"))
			{
				System.out.println("Chrome browser launched successfully");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(BROWSER.equals("firefox"))
			{
			
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else 
			{
				System.out.println("Edge browser launched successfully");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		System.out.println("--Browser is opened -- ");
		//sdriver=driver;
		wlib.maximize(driver);
		driver .get(URL);
		wlib.waitForPageLoad(driver);
			
	}
	
	
		
	@BeforeMethod(groups ={"smoke","integration","regression"})
	public void Configure_BM() throws Exception
	{
		String USERNAME=flib.readDataFrompropertyfile("username");
		String PASSWORD=flib.readDataFrompropertyfile("password");
		LoginPage  lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		System.out.println("--login to Application--");
	}
	
	@AfterMethod(groups ={"smoke","integration","regression"})
	public void Configure_AM()
	{
    	HomePage hp=new HomePage(driver);
		hp.logout();

		System.out.println("--application logout successfull--");
	}
	
	@AfterClass(groups ={"smoke","integration","regression"})
	public void Configure_AC()
	{
		driver.quit();
		System.out.println("--closed the Browser--");
	}
	
	@AfterSuite(groups ={"smoke","integration","regression"})
	public void configure_AS() throws Throwable
	{
		dlib.closeDB();
		System.out.println("--Database Connection Closed--");
	}

}
