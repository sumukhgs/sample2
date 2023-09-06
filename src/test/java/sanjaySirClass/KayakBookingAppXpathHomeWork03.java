package sanjaySirClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakBookingAppXpathHomeWork03 {

	public static void main(String[] args)throws Throwable {
			String start_monthyear="September 2023";
			String Start_Date="2";
			String end_Monthyear="September 2023";
			String End_Date="8";
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.kayak.co.in");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[.='Flights']")).click();
			driver.findElement(By.xpath("//*[name()='svg' and @class='vvTc-item-icon']")).click();
			driver.findElement(By.xpath("//div[@class='BCcW']//input[@class='k_my-input']")).sendKeys("bengaluru");
			Thread.sleep(3000);
			
			Robot r= new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("mumbai");
			Thread.sleep(3000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
			String start_date="//div[text()='"+start_monthyear+"']/../../descendant::div[text()='"+Start_Date+"']";
			String arrow="//div[@class='ATGJ-navWrapper ATGJ-next-month']/descendant::span[@class='tUEz-icon']";
			try {
			driver.findElement(By.xpath(start_date)).click();}
			catch (Exception e) {
				driver.findElement(By.xpath(arrow)).click();
			}
			


			Thread.sleep(3000);
			String end_date="//div[text()='"+end_Monthyear+"']/../../descendant::div[text()='"+End_Date+"']";
			for(;;){try {
				WebElement e1=driver.findElement(By.xpath(end_date));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.elementToBeClickable(e1));
				if(e1.isDisplayed()) {
					e1.click();
					break;
				}}
				catch(Exception e) {
					driver.findElement(By.xpath(arrow)).click();
					
				}
			}	
			driver.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
			Set<String> wids = driver.getWindowHandles();
			Iterator<String> itw = wids.iterator();
			while(itw.hasNext())
			{
				String wid =itw.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains("=bestflight_a")) {
					break;
			}}
				driver.findElement(By.xpath("//div[@class='c1wE_-title']")).click();
				driver.findElement(By.xpath("//li[@aria-label='Slowest']")).click();
				String price =driver.findElement(By.xpath("(//div[@class='Hv20']/ancestor::div[@class='header-wrapper']/following-sibling::*[last()]/descendant::div[@class='f8F1-price-text'])[1]")).getText();
			      price =price.replace("₹", "").replace(",", "").replace(" ", "");
			      Integer n= Integer.valueOf(price);
			      if(n<15000) {
			    	  System.out.println("flight price below 15000");
			      }
			      else {
			    	  	  System.out.println("flight price is not below 15000");
				      
			      }
				System.out.println(price);
				System.out.println(n);
				Thread.sleep(5000);
				

		}

	}


