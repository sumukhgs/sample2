package Basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderPopupTestScript {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//p[@class='sc-12foipm-18 dxLXYg fswWidgetTitle']")).click();
		
		driver.findElement(By.xpath("//div[text()='August 2023']/../..//p[text()='19']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		
		
		
	}

}
