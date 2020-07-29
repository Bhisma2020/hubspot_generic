package com.hubspot.generic.qa.testPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hubspot.generic.qa.BasePage.BasePage;
import com.hubspot.generic.qa.Pages.ContactPage;
import com.hubspot.generic.qa.Pages.HomePage;
import com.hubspot.generic.qa.Pages.LoginPage;

public class HomePagetest extends BasePage {
	
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	public HomePagetest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		
	BasePage.initialization();
	loginpage = new LoginPage(driver);
	homepage=loginpage.Loginwithvalidcredential();
	//contactpage= new ContactPage();
	
		
	}
	
	@Test 
	public void verifyContacttabisClicked() throws InterruptedException {
		homepage.doclickContacts();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
