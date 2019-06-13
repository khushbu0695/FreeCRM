package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPageClass;
import com.crm.qa.pages.HomePageClass;
import com.crm.qa.pages.LoginPageClass;

import cm.crm.qa.util.TestUtil;

public class contactsPageTest extends TestBase{
	
	LoginPageClass loginPage;
	HomePageClass homePage;
	TestUtil testUtil;
	
	String sheetName="contacts";
	ContactsPageClass contactsPage;
	public contactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();	
		 testUtil=new TestUtil();
		 loginPage= new LoginPageClass();
		 homePage= new HomePageClass();
		 contactsPage=new ContactsPageClass();
		 Thread.sleep(10000);
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=testUtil.getTestdata(sheetName);
		return data;
	}
	

	@Test(priority=1)
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts Label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest()
	{
		contactsPage.selectContactsByName("test 2 test 2");		
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String ftName, String ltName, String comp) throws InterruptedException
	{
		homePage.clickOnNewContactsLnk();
		Thread.sleep(3000);
		//contactsPage.createNewContact("Miss", "Khubu", "jainu", "google");
		contactsPage.createNewContact(title, ftName, ltName, comp);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
