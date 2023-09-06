package selfPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class readDataFromCMD {
	
	@Test
	public void readFromCmd()
	{
	
	
	String BROWSER=System.getProperty("browser");
	String URL=System.getProperty("url");
	String USERNAME=System.getProperty("username");
	String PASSWORD=System.getProperty("password");
	String orgname=System.getProperty("orgname");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get(URL);
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
    driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//button[.='login']")).click();
	System.out.println("hello");
	
	
	}

}
