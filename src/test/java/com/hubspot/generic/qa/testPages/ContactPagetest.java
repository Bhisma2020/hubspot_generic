package com.hubspot.generic.qa.testPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hubspot.generic.qa.BasePage.BasePage;
import com.hubspot.generic.qa.Pages.ContactPage;
import com.hubspot.generic.qa.Pages.HomePage;
import com.hubspot.generic.qa.Pages.LoginPage;
import com.hubspot.generic.qa.Utilities.Constants;
import com.hubspot.generic.qa.Utilities.Excelutil;

public class ContactPagetest extends BasePage {

	Excelutil excel;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	Constants constant;
	ContactPage contactpage;
	public ContactPagetest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
	BasePage.initialization();
	excel = new Excelutil(); 
	loginpage = new LoginPage(driver);
	contactpage = new ContactPage(driver);
	homepage = new HomePage(driver);
	homepage=loginpage.Loginwithvalidcredential();
	contactpage = homepage.doclickContacts();

	}


	@DataProvider()
	public Object[][] getContactsTestData() throws InvalidFormatException{
	Object data[][] = Excelutil.getTestData(Constants.CONTACTS_SHEET_NAME);
	return data;
	
	}

	
	@Test(priority=2,dataProvider ="getContactsTestData")
	public void validateusercanCreateNewContacts(String email,String firstname,String lastname,String title) {
		contactpage.filltheformforContact(email, firstname, lastname, title);
	
	}
	
	@Test(priority =1)
	public void verifyTheContactsPagetitle() {
		String title=contactpage.dogetTitle();
		System.out.println("this is title------>"+title);
		Assert.assertEquals(title, "Contacts");
	
	}

	
	@Test(priority=3)
	public void deleteContacts() throws InterruptedException {
	contactpage.deletecontact();
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	}
