
package hopeStarInsuranceApprovedTestScripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hopestar.GenericUtility.FileUtility;
import com.hopestar.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchClientAndCheckClientStatusViaNomineeTS {
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
//		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		
		//step:-01 enter the valid credentials in login page
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//step:-02 click on search field and enter the data in text field and press search button
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1511987599");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@class='searchBtn']")).submit();
		
		//step:-03 click on client status link
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[text()='Client Status']")).click();
		Thread.sleep(1500);
		
		//step:-04 to verify the client page is opening or not 
		WebElement ele = driver.findElement(By.xpath("//h1[@class='page-head-line']"));
		if(ele.isDisplayed()) {
			System.out.println("validated");
			System.out.println("the client page is opened");
		}
		else
		{
			System.out.println("the client page is not opening");
		}
		Thread.sleep(2000);
		
		//step:-05 close the window
		driver.quit();
	}

}
