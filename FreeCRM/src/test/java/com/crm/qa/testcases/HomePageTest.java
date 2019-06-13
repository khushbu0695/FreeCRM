package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPageClass;
import com.crm.qa.pages.HomePageClass;
import com.crm.qa.pages.LoginPageClass;

import cm.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	HomePageClass homePage;
	LoginPageClass loginPage;
	TestUtil testUtil;
	ContactsPageClass contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();	
		contactsPage=new ContactsPageClass();
		testUtil=new TestUtil();
		 loginPage= new LoginPageClass();
		 Thread.sleep(10000);
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "home page title not matched!!");
	}
	
	@Test (priority=2)
	public void verifyUserNameTest()
	{	testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
