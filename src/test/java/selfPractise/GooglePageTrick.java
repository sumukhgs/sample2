//test script to click on google page and select from dropdown s(it varies)
package selfPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageTrick {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement searchbar = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		searchbar.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='wM6W7d']")).click();
		
		
	}
}
