package hopeStarInsuranceApprovedTestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hopestar.GenericUtility.DataBaseUtility;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.JavaUtility;
import com.hopestar.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNomineeViaClientStatusTestScript {
public static void main(String[] args) throws Throwable {
	DataBaseUtility dLib=new DataBaseUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	FileUtility fLib=new FileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	String URL=fLib.readDataFrompropertyfile("url");
	String USERNAME=fLib.readDataFrompropertyfile("username");
	String PASSWORD=fLib.readDataFrompropertyfile("password");
//		File file=new File(".\\src\\test\\resources\\HopeStarInsuranceCredentials.properties");
//		FileInputStream fis=new FileInputStream(file);
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String URL=pobj.getProperty("url");
//		String UN=pobj.getProperty("username");
//		String PWD=pobj.getProperty("password");
		
	
	    WebDriver driver = wLib.launchBrowser(URL);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
	    
	    wLib.maximize(driver);
//		driver.manage().window().maximize();
	    
	    wLib.waitForPageLoad(driver);
//		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
	    driver.get(URL);
		
		
		//step:-01 enter the valid credentials in login page
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[.='login']")).click();
		Thread.sleep(1500);
		
	    //step:-02 click on client module
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		Thread.sleep(2000);
		
		//step:-03 click on client status id
		driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1511986912']")).click();
		Thread.sleep(2000);
		
		
		//step:-04 click on add nominee link of particular client
		driver.findElement(By.xpath("//a[@href='addNominee.php?client_id=1511986912']")).click();
		Thread.sleep(1500);
		
		//step:-05 add nominee details in add nominee page
		
		eLib.getMultipleDataFromExcel("nominee details", 0, 1, driver);
//		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\clientLogin.xlsx");
//		Workbook wb=WorkbookFactory.create(fi);
//		Sheet sh=wb.getSheet("nominee details");
//		int lastrow=sh.getLastRowNum();
//		String name=null;
//		
//		for(int i=0;i<=lastrow;i++) {
//	    	String key=sh.getRow(i).getCell(0).getStringCellValue();
//	    	String Value=sh.getRow(i).getCell(1).getStringCellValue();
//	    WebElement el=	driver.findElement(By.name(key));
//	    	Thread.sleep(1000);
//	    	el.sendKeys(Value);
//	    	if(key.equals("name"))
//	    	{
//	    		name=Value;
//	    	}
//		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='col-md-12']"));
		if(ele.isDisplayed())
		{
			System.out.println("validated");
		}
		
		// step:-06 click back on nominee module
		driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
		Thread.sleep(1000);
		
		// verifying the added nominee detail in the nominee page
//	    String table= driver.findElement(By.xpath("//table[@class='table']")).getText();
//		if(table.contains(name))
//		{
//			System.out.println("double validated");
//		}
		//step:-06 logout the application
        driver.findElement(By.xpath("//a[@href='logout.php']")).click();
        Thread.sleep(1000);
        
        //step:-07 close the window
        driver.quit();

				
  }

}
