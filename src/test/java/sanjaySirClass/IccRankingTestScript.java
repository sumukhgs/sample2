// program to display top 10 teams in the ranking
package sanjaySirClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRankingTestScript {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		List<WebElement> teams = driver.findElements(By.xpath("(//table/tbody/tr[*]/td[2]/span[@class='u-hide-phablet'])[position()<10]"));
		
		System.out.println("top 10 teams in ICC ranking");
		System.out.println("***************************");
		for(int i=0;i<teams.size();i++)
		{
			System.out.println(teams.get(i).getText());
		}
	}

}
