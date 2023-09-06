package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage {
	
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
	
	public AgentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	
	public void ClickOnPaymentLink()
	{
		getPaymentlink().click();
	}
	


}
