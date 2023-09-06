package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hopestar.GenericUtility.JavaUtility;

public class EditClientDetailsOnlyPage extends JavaUtility {
	
	JavaUtility jlib=new JavaUtility();
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phonefield;
	
	@FindBy(name="submit")
	private WebElement updatebtn;
	
	@FindBy(xpath="//a[.='Delete Client']")
	private WebElement deleteclientlink;

	public WebElement getPhonefield() {
		return phonefield;
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	public WebElement getDeleteclientlink() {
		return deleteclientlink;
	}
	
	public EditClientDetailsOnlyPage(WebDriver driver)
	{

    	PageFactory.initElements(driver, this);	
	}
	
	//Business Logic
	public void UpdatePhoneNo() throws Exception
	{
		 int phone = jlib.getRandomNo();
		 String val=Integer.toString(phone); 
		getPhonefield().clear();
		getPhonefield().sendKeys(val);
		Thread.sleep(1500);
		getUpdatebtn().click();
	}

}
