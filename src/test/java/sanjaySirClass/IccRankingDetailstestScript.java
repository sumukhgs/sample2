//program to display all the team details according to ranking
package sanjaySirClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRankingDetailstestScript {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> pos_ele = driver.findElements(By.xpath("//tbody//tr/td[1]"));
		List<WebElement> name_ele = driver.findElements(By.xpath("//tbody//tr/descendant::span[@class='u-hide-phablet']"));
		List<WebElement> match_ele = driver.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[1]"));
		List<WebElement> points_ele = driver.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[2]"));
		List<WebElement> ratings_ele = driver.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[3]"));
		
	for(int i=0;i<pos_ele.size();i++) {
		System.out.println(pos_ele.get(i).getText()+" "+name_ele.get(i).getText()+" "+match_ele.get(i).getText()+" "+points_ele.get(i).getText()+" "+ratings_ele.get(i).getText());
	}
}
}
