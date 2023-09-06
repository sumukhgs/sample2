
package Basic;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTestScript {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://rmgtestingserver:8888/"); //vtiger application link
		//driver.get("http://localhost:8888/"); 
		driver.get("https://www.irctc.co.in/nget/train-search"); //railway application
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		List<WebElement> listlink=driver.findElements(By.xpath("//a"));
		System.out.println(listlink.size());
		int count=0;
		ArrayList<String> links=new ArrayList<String>();
		
		
			for(int i=0;i<listlink.size();i++)
			{
				String eachlink=listlink.get(i).getAttribute("href");
				
				URL url=null;
				int statusCode=0;
				try {
				
				    url=new URL(eachlink);// load the url
				
			    HttpURLConnection httpurlconnection=(HttpURLConnection) url.openConnection();//open the url connnection
				
				   statusCode=httpurlconnection.getResponseCode();
				
				if(statusCode >= 400)
				{
					links.add(eachlink+"----->"+statusCode+" \n");
                    count++;		
				}
			}
		
			catch(Exception e)
			{
				links.add(eachlink+"----->"+statusCode+" \n");
				
			}
		}
			System.out.println(links);
			System.out.println("the total broken links in website"+count);
	}
}
	

