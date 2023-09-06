package com.hopestar.GenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	
	/**
	 * this method is used to maximize the window
	 * @author Sumukh g s
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to implicitly wait
	 * @author Sumukh g s
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	/**
	 * this method is used to explicitly wait until the condition
	 * @param driver
	 * @param element
	 */
	
	public void waitUntilElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	/**
	 * this method is used to select dropdown by value
	 * @author Sumukh g s 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select sele=new Select(element);
		sele.selectByValue(value);
	}
	
	
	/**
	 * this method is used to select dropdown by index value
	 * @author Sumukh g s 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,int index)
	{
		Select sele=new Select(element);
		sele.selectByIndex(index);
	}
	
	
	/**
	 * this method is used to select dropdown by visible text
	 * @param text
	 * @param element
	 */
	
	public void select(String text,WebElement element)
	{
		Select sele=new Select(element);
		sele.selectByVisibleText(text);
	}
	
	/**
	 * this method is used to mouse hover action
	 * @author Sumukh g s
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * this method is used to drag and drop
	 * @author Sumukh g s
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	/**
	 * this method is used to double click
	 * @author Sumukh g s
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/**
	 * this method is used to right click 
	 * @author Sumukh g s
	 * @param driver
	 */
	public void rightclick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	
	/**
	 * this method is used to perform right click on element
	 * @author Sumukh g s 
	 * @param driver
	 * @param element
	 */
	public void rightclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * This method will Press Enter Key
	 * @author Sumukh g s
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will Press Enter Key
	 * @author Sumukh g s
	 * @param driver
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/** 
	 * This method is used to release the key
	 * @author Sumukh g s
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * this method is used to switch the frame based on name or id
	 * @author Sumukh g s
	 * @param driver
	 * @param nameOrid
	 */
	public void switchToFrame(WebDriver driver,String nameOrid)
	{
		driver.switchTo().frame(nameOrid);
	}
	
	/**
	 * This method will switch the frame based on address
	 * @author Sumukh g s
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	
	/**
	 * This method is used to accept alert popup
	 * @author Sumukh g s
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This method is used to cancel alert popup
	 * @author Sumukh g s
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will switch between windows
	 * @author Sumukh g s
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use getWindowHandes to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title 
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method will perform random scroll
	 * @author Sumukh g s
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	
	/**
	 * This method will scroll until specified element is found
	 * @author Sumukh g s
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	}
	
	/**
	 * this method is used to launch the browser 
	 * @author Sumukh g s
	 * @param url
	 * @throws Exception 
	 */
	public WebDriver launchBrowser(String url) throws Exception
	{
		FileUtility f=new FileUtility();
		String BROWSER = f.readDataFrompropertyfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.get(url);
			return driver;
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver =new FirefoxDriver();
			driver.get(url);
			return driver;
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.get(url);
			return driver;
		}
		 
	}
	
//	public void launchBrowserUsingTestNG()
//	{
//		public void config_BC(String BROWSER)throws Throwable
//		{
//			System.out.println("Launch browser");
//			//String BROWSER = fUtil.readDataFromPropertyFile("browser");
//			//commented above line while implementing cross browser execution
//			String URL = fUtil.readDataFromPropertyFile("url");
//			
//			if(BROWSER.equals("chrome"))
//			{
//				System.out.println("Chrome browser launched successfully");
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//			}
//			else if(BROWSER.equals("firefox"))
//			{
//			
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			}
//			else if(BROWSER.equals("edge"))
//			{
//			
//				System.out.println("Edge browser launched successfully");
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//			}
//			else
//			{
//				System.out.println("Invalid browser");
//			}
//			
//			wUtil.maximizeWindow(driver);
//			wUtil.implicitWait(driver);
//			driver.get(URL);
//		}
//	}
	
	

}
