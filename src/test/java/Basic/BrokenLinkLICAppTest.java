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

public class BrokenLinkLICAppTest {
	public static void main(String[] args) 
	{
		
			WebDriverManager.chromedriver().setup();
		    WebDriver driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		    
		    driver.get("https://licindia.in/"); //LIC application
		    List<WebElement> links = driver.findElements(By.xpath("//a"));
		    
		    System.out.println(links.size());
		    
		    ArrayList<String> ref=new ArrayList<String>();
		    
		    for(int i=0;i<links.size();i++)
		    {
		    	
		    	String newlink=links.get(i).getAttribute("href");
		    	URL url=null;
		    	int statusCode=0;
		    	
		    		
		    	try {
					url=new URL(newlink);
					HttpURLConnection con=(HttpURLConnection)url.openConnection();			
							statusCode=con.getResponseCode();
							
							if(statusCode>=400)
							{
								ref.add(newlink+"--->"+statusCode);
							}
				}
				catch(Exception e)
				{
					ref.add(newlink+"--->"+statusCode);
				}
			}
			
			System.out.println(ref);
		}
		    
		    
		    
		

	}



