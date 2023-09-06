package com.hopestar.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hopestar.GenericUtility.ExcelUtility;

public class NomineePage extends ExcelUtility {
	ExcelUtility e=new ExcelUtility();
	
	
	@FindBy(xpath="//a[text()='Add Nominee']")
	private WebElement addnomineebtn;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement logoutbtn;
	
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	@FindBy(xpath="//a[@href='clientStatus.php?client_id=1511987011']")
	private WebElement clientstatuslink;
	
	@FindBy(xpath="//table[@class='table']")
	private WebElement table;

	public WebElement getTable() {
		return table;
	}

	public WebElement getAddnomineebtn() {
		return addnomineebtn;
	}

	public WebElement getClientstatuslink() {
		return clientstatuslink;
	}
	
	
	//initialization
	public NomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	public void ClickOnAddNomineeBtn()
	{
		getAddnomineebtn().click();
	}
	
	public  void Validation() throws Throwable
	{
		String name=e.readDataFromExcel("nominee details",1,1);
		String result=getTable().getText();
		Assert.assertTrue(result.contains(name),"nominee not created");
//		if(result.contains(name))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}
	
	public void ClickOnClientStatus()
	{
		getClientstatuslink().click();
	}
	
	public void ClickLogout()
	{
		getLogoutbtn().click();
	}
	
}
