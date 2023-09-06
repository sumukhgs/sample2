package sanjaySirClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class olympicAllListTestScript {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		int count=0;
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       
		List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		for(int i=0;i<country.size();i++)
		{
			System.out.println(i+":"+country.get(i).getText());
			count++;
		}
	
		
		System.out.println("total countries in olympics:"+count);
 }
}