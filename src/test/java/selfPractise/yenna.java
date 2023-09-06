package selfPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class yenna {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/");
		String username="kishan";
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.id("Email"));
		ele.sendKeys(username);
		Thread.sleep(2000);
		String result = ele.getAttribute("value");
		
		if(username.equals(result))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}




}
