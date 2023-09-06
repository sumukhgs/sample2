package workbookdemonstation;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		TakesScreenshot ts=(TakesScreenshot)ele;
		File pic = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(".\\src\\test\\screenshot\\p1.png");
		FileUtils.copyFile(pic, file);
		driver.close
		();
		
	}

}
