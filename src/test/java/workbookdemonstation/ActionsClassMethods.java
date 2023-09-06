package workbookdemonstation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassMethods {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='tm-menu']/descendant::a[@href='https://www.hyrtutorials.com/search/label/Tutorials']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		System.out.println("--moved over element--");
		TakesScreenshot ts=(TakesScreenshot)ele;
		File hyrPic = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(".\\src\\test\\screenshot\\p1.png");
		FileUtils.copyFile(hyrPic, file);
//		WebElement hov=driver.findElement(By.xpath("(//a[text()='Java'])[1]"));
//		act.moveToElement(hov).click().perform();
		
		
	}

}
