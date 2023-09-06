package hopeStarInsuranceApprovedTestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditClientViaNomineeTestScript {
	public static void main(String[] args) throws Exception {
		
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
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//step:-02 click on nominee module
		driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
		Thread.sleep(1500);
		
		//step:-03 click on client status hyperlink
		driver.findElement(By.xpath("//a[.='Client Status']")).click();
		Thread.sleep(1500);
		
		//step:-04 click on edit option present in client information page
		driver.findElement(By.xpath("//a[text()='Edit Client']")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		
		driver.quit();
		
		
		
		
	}

}
