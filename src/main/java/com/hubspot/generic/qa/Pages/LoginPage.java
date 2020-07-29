package com.hubspot.generic.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hubspot.generic.qa.BasePage.BasePage;
import com.hubspot.generic.qa.Utilities.ElementUtil;

public class LoginPage extends BasePage {

	
	WebDriver driver ;
	ElementUtil eleutil;
	
	By email=By.id("username");
	By password=By.id("password");
	By login=By.id("loginBtn");

	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(driver);
		
	}
	
	



	public HomePage Loginwithvalidcredential() { 
		//eleutil.waitForElementToBeVisible(email, 10);
		eleutil.doClick(email);
		eleutil.doSendKeys(email, prop.getProperty("email"));
		eleutil.doSendKeys(password, prop.getProperty("password"));
		eleutil.doClick(login);
		
		return new HomePage(driver);
	}
	
	public void verifytitle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(": HubSpot Login"));

		String title=ElementUtil.driver.getTitle();
		System.out.println("this is title---------->+"+title);
		Assert.assertEquals(title, "HubSpot Login");
	}
}