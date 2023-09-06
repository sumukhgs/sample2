package com.hopestar.POMPages;

import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.JavaUtility;

public class AddPaymentPage extends JavaUtility {
	ExcelUtility e=new ExcelUtility();
	JavaUtility j=new JavaUtility();
	
	
	@FindBy(name="client_id")
	private WebElement clientidfield;
	
	@FindBy(name="month")
	private WebElement monthfield;
	
	@FindBy(name="amount")
	private WebElement amountfield;
	
	@FindBy(name="due")
	private WebElement duefield;
	
	@FindBy(name="fine")
	private WebElement finefield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement addpaymentsubmitbtn;

	public WebElement getClientidfield() {
		return clientidfield;
	}

	public WebElement getMonthfield() {
		return monthfield;
	}

	public WebElement getAmountfield() {
		return amountfield;
	}

	public WebElement getDuefield() {
		return duefield;
	}

	public WebElement getFinefield() {
		return finefield;
	}

	public WebElement getAddpaymentsubmitbtn() {
		return addpaymentsubmitbtn;
	}
	
	public AddPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Business Logic
	public void ClickOnsubmitBtn()
	{
		getAddpaymentsubmitbtn().click();
	}
	
	//my referance delete it or use it
//	public void EnterPaymentDetail(HashMap<String, String> res,WebDriver driver) throws Throwable
//	{
//		for(Entry<String,String> set:res.entrySet())
//			{
//			   if(set.getKey().contains("amount"))
//			   {
//				 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+j.getRandomNo());
//			   }
//			   else
//			   {
//				   driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//				   Thread.sleep(500);
//			   }
//				
//			}
//	}

}
