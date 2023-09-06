package sanjaySirClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsTestscript {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String country="India";
		
		WebElement gold = driver.findElement(By.xpath("//span[text()='"+country+"']/../following-sibling::div[1]/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']"));
        WebElement silver = driver.findElement(By.xpath("//span[text()='"+country+"']/../following-sibling::div[2]/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']"));	
	    WebElement bronze = driver.findElement(By.xpath("//span[text()='"+country+"']/../following-sibling::div[3]/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']"));
        WebElement total =driver.findElement(By.xpath("//span[text()='"+country+"']/../following-sibling::div[4]/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']"));
	
	    System.out.println("Medal Winning Information");
	    System.out.println(country+ " has won "+gold.getText()+" gold medals,"+silver.getText()+" silver medals and"+bronze.getText()+" bronze medals");
	    System.out.println("total medal won by "+country+" is = "+total.getText());
        	
	}

}
