//program to display all the teams who have played more than 30 matchs
package sanjaySirClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccMatchesPlayedTestScript {
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			List<WebElement> teams = driver.findElements(By.xpath("(//table//tr[*]/td[3])[text()>30]/../descendant::span[@class='u-hide-phablet']"));
			List<WebElement> matchPlayed = driver.findElements(By.xpath("(//table//tr[*]/td[3])[text()>30]"));
			for(int i=0;i<teams.size();i++)
			{
				System.out.println(teams.get(i).getText()+" = "+matchPlayed.get(i).getText());
			}
	}

}
