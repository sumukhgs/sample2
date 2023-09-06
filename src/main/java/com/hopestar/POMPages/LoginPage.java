package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(name="username")
	private WebElement username;
	
	
	@FindBy(name="password")
	private WebElement password;
	
	
	@FindBy(xpath="//button[text()='login']")
	private WebElement loginbtn;
	
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//utilization
	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Business logic
	public void Login(String USERNAME,String PASSWORD) throws Exception
	{
		getUsername().sendKeys(USERNAME);
		getPassword().sendKeys(PASSWORD);
		Thread.sleep(2000);
		getLoginbtn().click();
		
		
	}

}
