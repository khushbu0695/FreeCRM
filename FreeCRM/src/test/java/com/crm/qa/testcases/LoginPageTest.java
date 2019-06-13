package com.crm.qa.testcases;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePageClass;
import com.crm.qa.pages.LoginPageClass;

public class LoginPageTest extends TestBase{
	LoginPageClass lp;
	HomePageClass homepage;
	public LoginPageTest()
	{
		super();  //calling testbase class's constructor
	}
	
		@BeforeMethod
		public void setUp() throws InterruptedException
		{
			initialization();
			
			 lp= new LoginPageClass();
			 Thread.sleep(10000);
		}
		
		@Test(priority=1)
		public void titleTest() throws InterruptedException
		{
			String titleOfLoginPage=lp.validateLoginPageTitle();
			Assert.assertEquals(titleOfLoginPage, "CRMPRO - CRM software for customer relationship management, sales, and support.");
			Thread.sleep(10000);
		}
		
		@Test(priority=2)
		public void validateLogoTest() throws InterruptedException
		{
			boolean flag=lp.validateCRMImage();
			Assert.assertTrue(flag);	
			Thread.sleep(10000);
		}
		
		@Test(priority=3)
		public void loginTest() throws InterruptedException
		{
			homepage=lp.Login(prop.getProperty("username"),prop.getProperty("password"))	;	
			Thread.sleep(10000);
		}
		
		@AfterMethod
		public void tearDown() throws InterruptedException
		{
			
			driver.quit();
		}
}
