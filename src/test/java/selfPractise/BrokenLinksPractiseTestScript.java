package selfPractise;

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

public class BrokenLinksPractiseTestScript{
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int total=links.size();
		System.out.println(total);
		int count=0;
		
		ArrayList<String> ref=new ArrayList<String>();
		
		for(int i=0;i<total;i++)
		{
			String linktext=links.get(i).getAttribute("href");
			URL url=null;
			int statuscode=0;
			
			try {
				url=new URL(linktext);
				HttpURLConnection x=(HttpURLConnection)url.openConnection();
				statuscode=x.getResponseCode();
				
				if(statuscode>=400)
				{
					ref.add(linktext+" ------>"+statuscode+" \n");
					count++;
				}
				
			}
			catch(Exception e)
			{
				ref.add(linktext+" ----->"+statuscode+"\n ");
			}
			
		}
		
		System.out.println(ref);
		System.out.println("total count"+count);
		
		
	}
}