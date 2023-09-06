//using  only generic utilities
package hopeStarInsuranceApprovedTestScripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hopestar.GenericUtility.DataBaseUtility;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.JavaUtility;
import com.hopestar.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewClientTestScript {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		DataBaseUtility dLib=new DataBaseUtility();
		
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HopeStarInsuranceCredentials.properties");
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
		
		//step:-01 login to application using credentials
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//step:-02 click on client module 
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		Thread.sleep(1000);
		
		//step:-03 click on add client button
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		
		//step:-04 Enter the client details
		eLib.getMultipleDataFromExcel("Sheet1", 0,1, driver);
//		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\clientLogin.xlsx");
//		Workbook wb=WorkbookFactory.create(fi);
//		Sheet sh=wb.getSheet("Sheet1");
//		int num=sh.getLastRowNum();
//		for(int i=0;i<=num;i++)
//		{
//			String key=sh.getRow(i).getCell(0).getStringCellValue();
//			String value=sh.getRow(i).getCell(1).getStringCellValue();
//			driver.findElement(By.name(key)).sendKeys(value);
//			Thread.sleep(1000);
//		}
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
	}

}
