package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditClientStatusPage {
	
	@FindBy(xpath="//a[text()='Edit Client']")
	private WebElement editclientlink;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutbtn;
	
	@FindBy(xpath="//h1[@class='page-head-line']")
	private WebElement pageheader;
	
	public WebElement getPageheader() {
		return pageheader;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	@FindBy(xpath="//a[text()='Add Nominee']")
	private WebElement addnomineelink;
	
	@FindBy(xpath="//a[text()='Add Payment']")
	private WebElement addpaymentlink;
	
	@FindBy(xpath="//a[text()='Delete Client']")
	private WebElement deleteclientlink;

	public WebElement getEditclientlink() {
		return editclientlink;
	}

	public WebElement getAddnomineelink() {
		return addnomineelink;
	}

	public WebElement getAddpaymentlink() {
		return addpaymentlink;
	}

	public WebElement getDeleteclientlink() {
		return deleteclientlink;
	}
	
	public EditClientStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	public void ClickOnAddNomineeLink()
	{
		getAddnomineelink().click();
	}
	
	public void ClickOnAddPaymentLink()
	{
		getAddpaymentlink().click();
	}
	
	public  void Logout()
	{
		getLogoutbtn().click();
	}
	
	public void EditClient()
	{
		getEditclientlink().click();
	}
	
	public boolean PageHeader()
	{
		boolean res = getPageheader().isDisplayed();
		return res;
	}

}
