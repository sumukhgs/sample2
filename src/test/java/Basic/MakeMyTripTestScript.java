package Basic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTestScript {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.get("https://www.makemytrip.com");
	    
	    Actions act=new Actions(driver);
	    act.moveByOffset(30,30).click().perform();
	    
	    driver.findElement(By.xpath("//span[.='Departure']")).click();
	    
	    // we can use //div[text()='val'] ==> //div[.='value']  text()==.
	    String x="//div[.='April 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='30']";
	    String arrow="//span[@aria-label='Next Month']";
	    for(;;)
	    {
	    	try {
	    		driver.findElement(By.xpath(x)).click();
	    		}
	    	
	    	catch(Exception e)
	    	{
	    		driver.findElement(By.xpath(arrow)).click();
	    	}
	    } 
	    
	}

}
