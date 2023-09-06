package sanjaySirClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchOptionAmazonXpathHomeWork04 {
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phones");
	    Thread.sleep(1000);
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@id='p_89-title']/../descendant::span[.='Samsung']")).click();
	 
	    
	     List<WebElement> mobname = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	     List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	     
	     for(int i=0;i<mobname.size();i++)
	     {
	    	 String name=mobname.get(i).getText();
	    	 String rate=price.get(i).getText();
	    	 rate=rate.replace(",", "");
	    	 Integer you=Integer.valueOf(rate);
	    	 if((you>8000) &&(you<12000) ) {
	    	 System.out.println(name+" = "+rate);
	    	 
	    	 } 
	     }
	     
	     
	     //driver.findElement(By.xpath("//span[.='Nokia']")).click();
	}
}
