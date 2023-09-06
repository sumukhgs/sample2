package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNomineePage {
	
	@FindBy(name="client_id")
	private WebElement clientidfield;
	
	@FindBy(name="name")
	private WebElement namefield;
	
	@FindBy(name="sex")
	private WebElement genderfield;
	
	@FindBy(name="birth_date")
	private WebElement dobfield;
	
	@FindBy(name="nid")
	private WebElement nidfield;
	
	@FindBy(name="relationship")
	private WebElement relationshipfield;
	
	@FindBy(name="priority")
	private WebElement priorityfield;
	
	@FindBy(name="phone")
	private WebElement phonefield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement addnomineesubmitbtn;

	public WebElement getClientidfield() {
		return clientidfield;
	}

	public WebElement getNamefield() {
		return namefield;
	}

	public WebElement getGenderfield() {
		return genderfield;
	}

	public WebElement getDobfield() {
		return dobfield;
	}

	public WebElement getNidfield() {
		return nidfield;
	}

	public WebElement getRelationshipfield() {
		return relationshipfield;
	}

	public WebElement getPriorityfield() {
		return priorityfield;
	}

	public WebElement getPhonefield() {
		return phonefield;
	}

	public WebElement getAddnomineesubmitbtn() {
		return addnomineesubmitbtn;
	}
	
	public AddNomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business logic
	public void ClickOnSubmitBtn()
	{
		getAddnomineesubmitbtn().click();
	}

}
