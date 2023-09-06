package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hopestar.GenericUtility.ExcelUtility;

public class AddClientPage {
	@FindBy(name="client_password")
	private WebElement clientpasswordfield;
	
	@FindBy(name="name")
	private WebElement namefield;
	
	@FindBy(name="sex")
	private WebElement sexfield;
	
	@FindBy(name="fileToUpload")
	private WebElement fileuploadfield;
	
	@FindBy(name="birth_date")
	private WebElement dobfield;
	
	@FindBy(name="maritial_status")
	private WebElement maritialstatusfield;
	
	@FindBy(name="nid")
	private WebElement nidfield;
	
	@FindBy(name="phone")
	private WebElement phonefield;
	
	@FindBy(name="address")
	private WebElement addressfield;
	
	@FindBy(name="policy_id")
	private WebElement policyidfield;
	
	@FindBy(name="nominee_name")
	private WebElement nomineenamefield;
	
	@FindBy(name="nominee_sex")
	private WebElement nomineesexfield;
	
	@FindBy(name="nominee_birth_date")
	private WebElement nomineedobfield;
	
	@FindBy(name="nominee_nid")
	private WebElement nomineenidfield;
	
	@FindBy(name="nominee_relationship")
	private WebElement nomineerelationshipfield;
	
	@FindBy(name="priority")
	private WebElement priorityfield;
	
	@FindBy(name="nominee_phone")
	private WebElement nomineephonefield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement clientsubmitbtn;
	
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

	public WebElement getClientpasswordfield() {
		return clientpasswordfield;
	}

	public WebElement getNamefield() {
		return namefield;
	}

	public WebElement getSexfield() {
		return sexfield;
	}

	public WebElement getFileuploadfield() {
		return fileuploadfield;
	}

	public WebElement getDobfield() {
		return dobfield;
	}

	public WebElement getMaritialstatusfield() {
		return maritialstatusfield;
	}

	public WebElement getNidfield() {
		return nidfield;
	}

	public WebElement getPhonefield() {
		return phonefield;
	}

	public WebElement getAddressfield() {
		return addressfield;
	}

	public WebElement getPolicyidfield() {
		return policyidfield;
	}

	public WebElement getNomineenamefield() {
		return nomineenamefield;
	}

	public WebElement getNomineesexfield() {
		return nomineesexfield;
	}

	public WebElement getNomineedobfield() {
		return nomineedobfield;
	}

	public WebElement getNomineenidfield() {
		return nomineenidfield;
	}

	public WebElement getNomineerelationshipfield() {
		return nomineerelationshipfield;
	}

	public WebElement getPriorityfield() {
		return priorityfield;
	}

	public WebElement getNomineephonefield() {
		return nomineephonefield;
	}

	public WebElement getClientsubmitbtn() {
		return clientsubmitbtn;
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
	
	public AddClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business logics
	
	public void ClickSubmitBtn()
	{
		getClientsubmitbtn().click();
	}
	
	public String GetNameField()
	{
		String naam = getNamefield().getText();
		return naam;
	}
	
	

}
