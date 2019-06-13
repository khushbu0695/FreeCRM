package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass extends TestBase
{
	
	@FindBy(xpath = " //td[contains(text(),'User: kbu jain')]")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing page objects
		 public HomePageClass() {
			PageFactory.initElements(driver, this);
		}
		 
	public String verifyHomePageTitle()
	{
		return driver.getTitle();		
	}
	
	public ContactsPageClass clickOnContactsLink()
	{
		
		contactsLink.click();
		return new ContactsPageClass();
	}
	
	public boolean verifyCorrectUsername()
	{
		return usernameLabel.isDisplayed();
	}
	
	public DealsPageCass clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPageCass();
	}
	
	public TasksPageClass clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPageClass();
	}
	
	public void clickOnNewContactsLnk() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		//Thread.sleep(2000);
		newContactLink.click();
	}

}
