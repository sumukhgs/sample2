package hopeStarInsuranceApprovedTestScripts;

import java.io.File;
import java.io.FileInputStream;
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

public class AddPaymentAndEditPaymentTestScript {
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
		
		
		WebDriver driver=wLib.launchBrowser(URL);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		wLib.maximize(driver);
//		driver.manage().window().maximize();
		
		wLib.waitForPageLoad(driver);
//		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		
		
		//step:-01 enter the valid credentials in login page
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//step:-02 click on payment module
		driver.findElement(By.xpath("//a[@href='payment.php']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		Thread.sleep(1000);
		
		
		
        String ClientId=eLib.readDataFromExcel("Add paymentclient", 0, 1);
        String month=eLib.readDataFromExcel("Add paymentclient", 1, 1);
        String amount=eLib.readDataFromExcel("Add paymentclient", 2, 1);
        String due=eLib.readDataFromExcel("Add paymentclient", 3, 1);
        String fine=eLib.readDataFromExcel("Add paymentclient", 4, 1);
//		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\clientLogin.xlsx");
//		Workbook wb=WorkbookFactory.create(fi);
//	    Sheet sh = wb.getSheet("Add paymentclient");
//	    
//	    String ClientId = sh.getRow(0).getCell(0).getStringCellValue();
//        String month = sh.getRow(1).getCell(1).getStringCellValue();
//        String amount = sh.getRow(2).getCell(1).getStringCellValue();
//        String due = sh.getRow(3).getCell(1).getStringCellValue();
//        String fine=sh.getRow(4).getCell(1).getStringCellValue();
	   
        
        //Step:-04 entering the values in text field
        driver.findElement(By.name("client_id")).sendKeys(String.valueOf(ClientId));
        driver.findElement(By.name("month")).sendKeys(month);
        Thread.sleep(1000);
        driver.findElement(By.name("amount")).sendKeys(String.valueOf(amount));
        driver.findElement(By.name("due")).sendKeys(String.valueOf(due));
        Thread.sleep(1000);
        driver.findElement(By.name("fine")).sendKeys(String.valueOf(fine));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        
        WebElement ele = driver.findElement(By.xpath("//div[@class='col-md-12']"));
        if(ele.isDisplayed())
        {
        	System.out.println("validated");
        }
        
        //step:-05 click on client module
        driver.findElement(By.xpath("//a[@href='client.php']")).click();
        Thread.sleep(1000);
        
        //step:-06 click on client status hyperlink
        driver.findElement(By.xpath("(//a[.='Client Status'])[1]")).click();
        Thread.sleep(1000);
        
        //step:-07 logout the application
        driver.findElement(By.xpath("//a[@href='logout.php']")).click();
        Thread.sleep(1000);
        
        
        //step:-08 close the window
        driver.quit();
        
        
        
	    
	    
		
		
	}

}
