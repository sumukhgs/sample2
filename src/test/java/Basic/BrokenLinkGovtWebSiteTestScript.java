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

public class BrokenLinkGovtWebSiteTestScript {
	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		System.out.println(links.size());
		
		ArrayList<String> ref=new ArrayList<String>();
		
		for(int i=0;i<links.size();i++)
		{
			String demo=links.get(i).getAttribute("href");
			//System.out.println(demo);  //to print the list of links
			URL url=null;
			int statusCode=0;
			try {
				url=new URL(demo);
				HttpURLConnection con=(HttpURLConnection)url.openConnection();			
						statusCode=con.getResponseCode();
						
						if(statusCode>=400)
						{
							ref.add(demo+"--->"+statusCode);
						}
			}
			catch(Exception e)
			{
				ref.add(demo+"--->"+statusCode);
			}
		}
		
		System.out.println(ref);
	}
	

}
