package workbookdemonstation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptDemo {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/homepage");
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,1000)","");
	      
	    
	    WebElement ele=driver.findElement(By.xpath("//h2[.='Explore ICC']/../child::div[@class='carousel-controls']"));
	   int y= ele.getLocation().getY();
	    js.executeScript("window.scrollBy(0,"+y+")", ele);
	    
	    // to move the driver control to element 
	    js.executeScript("arguments[0].scrollIntoView(true);",ele);
	    
	    
	    //To Scroll Until Page End
	    js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	    int count=0;
	    for(;;)
	    {
	    	js.executeScript("window.scrollBy(0,650)","");
	    	if(ele.isDisplayed())
	    	{
	    		count++;
	    		break;
	    	}
	    }
		System.out.println(count);
	}

}
