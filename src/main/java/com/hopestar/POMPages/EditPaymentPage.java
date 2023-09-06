package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPaymentPage {
	@FindBy(name="client_id")
	private WebElement clientidfield;
	
	@FindBy(name="month")
	private WebElement monthfield;
	
	@FindBy(name="amount")
	private WebElement amountfield;
	
	@FindBy(name="due")
	private WebElement duefield;
	
	@FindBy(name="fine")
	private WebElement finefield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement updatebtn;
	
	@FindBy(xpath="//a[.='Delete Payment']")
	private WebElement deletebtn;

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getClientidfield() {
		return clientidfield;
	}

	public WebElement getMonthfield() {
		return monthfield;
	}

	public WebElement getAmountfield() {
		return amountfield;
	}

	public WebElement getDuefield() {
		return duefield;
	}

	public WebElement getFinefield() {
		return finefield;
	}
	
	public EditPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickUpdateBtn()
	{
		getUpdatebtn().click();
	}
	
	public void ClickDeleteBtn()
	{
		getDeletebtn().click();
	}

}
