package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	@FindBy(xpath="(//a[.='Client Status'])[1]")
	private WebElement clientclientstatuslink;
	
	
	@FindBy(xpath="(//a[.='Client Status'])[2]")
	private WebElement nomineeclientstatuslink;


	public WebElement getClientclientstatuslink() {
		return clientclientstatuslink;
	}


	public WebElement getNomineeclientstatuslink() {
		return nomineeclientstatuslink;
	}
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Business Logic
	
	public void ClickOnCCL()
	{
		getClientclientstatuslink().click();
	}
	
	public void ClickOnNCL()
	{
		getNomineeclientstatuslink().click();
	}
}
