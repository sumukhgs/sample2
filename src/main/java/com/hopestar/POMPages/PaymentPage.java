package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	@FindBy(xpath="//a[text()='Add Payment']")
	private WebElement addpaymentbtn;
	
	@FindBy(xpath="//a[@href='editPayment.php?recipt_no=1665402552_677329954']")
	private WebElement editpaymentlink;

	public WebElement getAddpaymentbtn() {
		return addpaymentbtn;
	}

	public WebElement getEditpaymentlink() {
		return editpaymentlink;
	}
	
	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnAddPaymentBtn()
	{
		getAddpaymentbtn().click();
	}

}
