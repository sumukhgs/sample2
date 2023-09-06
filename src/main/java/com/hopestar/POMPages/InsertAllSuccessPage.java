package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InsertAllSuccessPage {
	
	@FindBy(xpath="//a[@href='addNominee.php']")
	private WebElement addnomineebtn;
	
	@FindBy(xpath="//a[@href='nominee.php']")
	private WebElement nomineelink;
	
	@FindBy(xpath="//a[@href='client.php']")
	private WebElement clientlink;
	
	@FindBy(xpath="//a[@href='agent.php']")
	private WebElement agentlink;
	
	@FindBy(xpath="//a[@href='policy.php']")
	private WebElement policylink;
	
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement paymentlink;
	
	@FindBy(xpath="//div[@class='col-md-12']")
	private WebElement successtextbox;
	
	
	public WebElement getClientlink() {
		return clientlink;
	}

	public WebElement getAgentlink() {
		return agentlink;
	}

	public WebElement getPolicylink() {
		return policylink;
	}

	public WebElement getPaymentlink() {
		return paymentlink;
	}

	public WebElement getAddnomineebtn() {
		return addnomineebtn;
	}

	public WebElement getNomineelink() {
		return nomineelink;
	}

	public WebElement getSuccesstextbox() {
		return successtextbox;
	}
	
	public InsertAllSuccessPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business Logic
	public void ClickOnNomineeLink()
	{
		getNomineelink().click();
	}
	
	public void ClickOnPaymentLink()
	{
		getPaymentlink().click();
	}
	
	public void InsertSuccessTextBox()
	{
		boolean res=getSuccesstextbox().isDisplayed();
		Assert.assertEquals(res, true);
	}
	
	public  void ClickOnClientLink()
	{
		getClientlink().click();
	}
	

}
