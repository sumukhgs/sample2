package selfPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CmdPrograms {
	
	@Test
	public void LaunchGoogle()
	{
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("hello");
	}

	
}
