package Basic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboCalenderTestScript {
	
	public static void main(String[] args) {
		String 	monthandyear="September 2024";
		String date="25";
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.goibibo.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span[@class='sc-iCfMLu ixvMbU']")).click();
			driver.findElement(By.xpath("//span[@class='sc-12foipm-21 lerOcM fswDownArrow']")).click();
			String actualdate="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";

			for(;;)
				try {
					driver.findElement(By.xpath(actualdate)).click();
					break;
				}
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			
	driver.findElement(By.xpath("//span[text()='Done']")).click();
	
	driver.findElement(By.xpath("//a[text()='Done']")).click();
		}

	}


