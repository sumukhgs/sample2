//Test script to find out all the mobile phones within the range of 70000/-
package sanjaySirClass;

import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathExample01 {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		Thread.sleep(1000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(1000);
		
		List<WebElement> mobilelist = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for (int i=0;i<mobilelist.size();i++)
		{
			try {
			String name=mobilelist.get(i).getText();
			name=name.replace(",","");
			Integer n=Integer.valueOf(name);
			if(n<70000)
			{
				System.out.println(n);
			}}
			catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

}
