package sanjaySirClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonXpathHomeWork01 {
	public static void main(String[] args) throws Exception{
	      WebDriverManager.chromedriver().setup();
	      WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://www.amazon.in/");
	      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	      Thread.sleep(1000);
	      driver.findElement(By.id("nav-search-submit-button")).click();
	      List<WebElement> name = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	      List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	      
	      for(int i=0;i<name.size();i++)
	      {
	    	  String mobname=name.get(i).getText();
	    	  String mobprice=price.get(i).getText();
	    	  mobprice=mobprice.replace(",","");
	    	  System.out.println(mobname+" = "+mobprice);
	    	  
	      }
	      Thread.sleep(2000);
	      driver.quit();
	      
	   }

}
