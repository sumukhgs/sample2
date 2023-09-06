package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//declaration
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement logoutbtn;
	
	@FindBy(className="searchBtn")
	private WebElement searchbtn;
	
	@FindBy(xpath="//a[@href='client.php']")
	private WebElement clientlink;
	
	@FindBy(xpath="//a[@href='agent.php']")
	private WebElement agentlink;
	
	@FindBy(xpath="//a[@href='policy.php']")
	private WebElement policylink;
	
	@FindBy(xpath="//a[@href='nominee.php']")
	private WebElement nomineelink;
	
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement paymentlink;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement homelogobtn;
	
    public WebElement getHomelogobtn() {
		return homelogobtn;
	}

	@FindBy(name="key")
    private WebElement searchbox;
	
	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getClientlink() {
		return clientlink;
	}

	public WebElement getAgentlink() {
		return agentlink;
	}

	public WebElement getPolicylink() {
		return policylink;
	}

	public WebElement getNomineelink() {
		return nomineelink;
	}

	public WebElement getPaymentlink() {
		return paymentlink;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickClient()
	{
		getClientlink().click();
	}
	
	public void clickAgent()
	{
		getAgentlink().click();
	}
	
	public void clickNominee()
	{
		getNomineelink().click();
	}
	
	public void  clickPayment()
	{
		getPaymentlink().click();
	}
	
	public void clickPolicy()
	{
		getPolicylink().click();
	}
	
	public void search(String value)
	{
		getSearchbox().sendKeys(value);
		getSearchbtn().click();
	}
	
	public void logout()
	{
		getLogoutbtn().click();
	}
	
}
