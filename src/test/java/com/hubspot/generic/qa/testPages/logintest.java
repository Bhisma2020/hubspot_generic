package com.hubspot.generic.qa.testPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.generic.qa.BasePage.BasePage;
import com.hubspot.generic.qa.Pages.LoginPage;

public class logintest extends BasePage{
	
	
	LoginPage login;
	BasePage basepage;
	
	
	
	public logintest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		BasePage.initialization();
		login = new LoginPage(driver);
		
	}
	
	
	@Test(priority=1)
	public void verifyusercanLogin() throws InterruptedException {
		login.Loginwithvalidcredential();
	
		//Thread.sleep(5000);
	
	}
	/*
	@Test(priority=1)
	public void validateTheTitle() throws InterruptedException {
		login.verifytitle();
	}
	*/
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
