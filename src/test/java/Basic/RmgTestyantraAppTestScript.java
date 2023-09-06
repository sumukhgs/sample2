package Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgTestyantraAppTestScript {
	public static void main(String[] args) throws InterruptedException, SQLException {
		String expdata="our group project";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		//WebElement un=driver.findElement(By.xpath("//label[@for='usernmae']"));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].value='rmgyantra'",un);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		Thread.sleep(2000);
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		driver.findElement(By.linkText("Projects")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("Our Group Project");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Kiran");
		WebElement drop=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sc=new Select(drop);
		sc.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).submit();
		
		
		Driver jdriver=new Driver();
		DriverManager.registerDriver(jdriver);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
		
		Statement state=con.createStatement();
		String query="select * from project;";
	     ResultSet result = state.executeQuery(query);
	     boolean flag=false;
	     
	     while(result.next())
	     {
	    	String actual=result.getString(4);
	    	if(actual.equalsIgnoreCase(expdata))
	    	{
	    		flag=true;
	    		break;
	    	}
	     }
	     if(flag)
	     {
	    	 System.out.println("project created successfully");
	    	 
	     }
	     else
	     {
	    	 System.out.println("project not created");
	     }
		
		con.close();
	}

}
