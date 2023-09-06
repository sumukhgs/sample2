package hopeStarInsuranceApprovedTestScripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hopestar.GenericUtility.DataBaseUtility;
import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.JavaUtility;
import com.hopestar.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AddPaymentUsingAgentIDTestScript {
	public static void main(String[] args) throws Exception {
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String URL=fLib.readDataFrompropertyfile("url");
		String USERNAME=fLib.readDataFrompropertyfile("username");
		String PASSWORD=fLib.readDataFrompropertyfile("password");
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HopeStarInsuranceCredentials.properties");
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
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		//step:-01 enter the valid credentials in login page
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		Thread.sleep(1000);
		
		//step:-02 click on agents module
		driver.findElement(By.xpath("//a[@href='agent.php']")).click();
		Thread.sleep(1500);
		
		//step:-03 click on payments module
		driver.findElement(By.xpath("//a[@href='payment.php']")).click();
		Thread.sleep(1500);
		
		//step:-04 click on add payment button
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		Thread.sleep(1500);
		
		//step:-05 enter the data in text fields of payment 
		driver.findElement(By.name("client_id")).sendKeys("123456");
		driver.findElement(By.name("month")).sendKeys("april");
		driver.findElement(By.name("amount")).sendKeys("40000");
		driver.findElement(By.name("due")).sendKeys("500");
		driver.findElement(By.name("fine")).sendKeys("90");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String s=driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		
		if(s.contains("New Payment ADDED")) {
			System.out.println("validated");
		}
		
		Thread.sleep(1000);
		
		//step-06 click on payment module
		driver.findElement(By.xpath("//a[@href='payment.php']")).click();
		Thread.sleep(1500);
	    
		
		//step-07 close the window
		driver.quit();
		
		
	}

}
