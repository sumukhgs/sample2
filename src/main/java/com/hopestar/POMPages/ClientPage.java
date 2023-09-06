package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement logoutbtn;
	
	@FindBy(xpath="//a[text()='Add Client']")
	private WebElement addclientbtn;
	
	@FindBy(xpath="//a[@href='client.php']")
	private WebElement clientlink;
	
	@FindBy(xpath="//a[@href='agent.php']")
	private WebElement agentlink;
	
	@FindBy(xpath="//a[@href='policy.php']")
	private WebElement policylink;
	
	@FindBy(xpath="//a[@gref='nominee.php']")
	private WebElement nomineelink;
	
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement paymentlink;
	
	@FindBy(xpath="//a[@href='clientStatus.php?client_id=1511986912']")
	private WebElement clientstatuslink;

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getAddclientbtn() {
		return addclientbtn;
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

	public WebElement getClientstatuslink() {
		return clientstatuslink;
	}
	
	//initialization
	public ClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//Business logic
	public void ClickAddClient()
	{
		getAddclientbtn().click();
	}
	
	public void ClickOnClientStatusLink()
	{
		getClientstatuslink().click();
	}
	
	public void Logout()
	{
		getLogoutbtn().click();
	}
	

}
