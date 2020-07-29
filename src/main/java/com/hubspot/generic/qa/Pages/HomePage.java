package com.hubspot.generic.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.generic.qa.BasePage.BasePage;
import com.hubspot.generic.qa.Utilities.ElementUtil;

public class HomePage extends BasePage {

	
	WebDriver driver ;
	ElementUtil eleutil;
	
		
	By Maincontacts =By.xpath("//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']");
	By selectcontact=By.xpath("//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//div[contains(text(),'Contacts')]");
	
	public HomePage(WebDriver driver) {
	
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
	}
	
	public ContactPage doclickContacts() throws InterruptedException {
		
		eleutil.doClick(Maincontacts);
		//eleutil.actionClick(Maincontacts);
		eleutil.doClick(selectcontact);
		
	
		return new ContactPage(driver);
		
	}
	
	
}
